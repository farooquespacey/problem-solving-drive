package com.spacey.ps.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _03_MappingTest {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		List<Integer> l1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(l1.get(1));

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		Integer[] nums = numbers.toArray(new Integer[0]);// numbers.stream().toArray(Integer[]::new);

		Map<Integer, String> mapOddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0)
				.collect(Collectors.toMap(Function.identity(), x -> String.valueOf(x)));
		System.out.println(mapOddNumbers); // {1=1, 3=3, 5=5}

		Stream.of("a", "b", "c");
		String x = "1 2 3 4";
		Arrays.stream(x.split(" ")).map(Integer::parseInt)
		.filter(e -> e % 2 == 0)
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}

}
