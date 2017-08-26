package org.enoy.klc.minecraft.connector;

import org.enoy.klc.minecraft.connector.values.definitions.KlcMinecraftAbstractValue;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KlcConnector implements Runnable {

	private static final long CONNECT_TIMEOUT = 3000L;
	private static final int PORT = 42359;

	private static KlcConnector instance;

	private List<KlcMinecraftAbstractValue<?, ?>> register;

	private Socket socket;
	private PrintWriter out;
	private volatile boolean connected;

	private KlcConnector() {
		connected = false;
		register = new ArrayList<>();
	}

	@Override
	public void run() {

		final byte[] buffer = new byte[1024];

		System.out.println("KLC connecting...");
		while (!Thread.interrupted()) {

			try {
				socket = new Socket("127.0.0.1", PORT);
				System.out.println("KLC connected!");
				out = new PrintWriter(socket.getOutputStream());

				connected = true;

				InputStream in = socket.getInputStream();

				while (in.read(buffer) != -1) {
					sleep(100);
				}

			} catch(ConnectException e) {
				// IGNORE
			} catch (IOException e) {
				System.out.println("KLC disconnected!");
				System.out.println("KLC connecting...");
			} finally {
				connected = false;
				disconnect();
			}

			sleep(CONNECT_TIMEOUT);

		}

		System.out.println("KLC Terminated!");

	}

	public void send() {
		String message =
				register.stream()
						.map(KlcMinecraftAbstractValue::getData)
						.filter(Objects::nonNull)
						.map(KlcData::format)
						.collect(Collectors.joining("\n"));

		sendMessage(message);
	}

	private void sendMessage(String message) {
		if (connected) {
			try {
				out.println(message);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void register(KlcMinecraftAbstractValue<?, ?> klcMinecraftValue) {
		System.out.println("Registering: " + klcMinecraftValue.getClass().getSimpleName());
		register.add(klcMinecraftValue);
	}

	private void disconnect() {
		try {
			if (out != null)
				out.close();
			if (socket != null)
				socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out = null;
			socket = null;
		}
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore
		}
	}

	public static void start() {
		Thread klcConnectorThread = new Thread(getInstance());
		klcConnectorThread.setDaemon(true);
		klcConnectorThread.start();
	}

	public static KlcConnector getInstance() {
		return instance == null ? (instance = new KlcConnector()) : instance;
	}

}
