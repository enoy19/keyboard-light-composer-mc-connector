package org.enoy.klc.minecraft.connector.values;

import java.util.function.Function;

public class ValueUtil {

	public static <A, B, C> Function<A, C> getValue(Function<A, B> func1, Function<B, C> func2) {
		return value -> func2.apply(func1.apply(value));
	}

	public static <A, B, C, D> Function<A, D> getValue(Function<A, B> func1, Function<B, C> func2, Function<C, D> func3) {
		return value -> func3.apply(func2.apply(func1.apply(value)));
	}

	public static <A, B, C, D, E> Function<A, E> getValue(Function<A, B> func1, Function<B, C> func2, Function<C, D> func3, Function<D, E> func4) {
		return value -> func4.apply(func3.apply(func2.apply(func1.apply(value))));
	}

	@SafeVarargs
	public static <T> Function<T, T> getValue(Function<T, T>... functions) {
		return last -> {
			for (int i = functions.length - 1; i >= 0; i--) {
				last = functions[i].apply(last);
			}
			return last;
		};
	}

}
