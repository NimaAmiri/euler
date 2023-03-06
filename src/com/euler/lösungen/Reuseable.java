package com.euler.lösungen;

public class Reuseable {
	public static boolean isEvenValue(int i) {
		if (i % 2 == 0)
			return true;
		return false;
	}

	public static boolean isPrime(long number) {
		if (number <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++)
			if (number % i == 0)
				return false;
		return true;
	}

	public static int[] keepBiggerValue(int nr, int compare) {
		if (nr > compare) {
			compare = nr;
			nr = 1;
		} else {
			nr = 1;
		}
		return new int[] { nr, compare };
	}

}
