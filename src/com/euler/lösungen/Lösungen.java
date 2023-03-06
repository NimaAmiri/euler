package com.euler.lösungen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Lösungen {

	public static void main(String[] args) {
		Lösungen.largestProductInGrid();

	}

	public static void multiplesOf3Or5() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
//				System.out.println(i + " is a Multiples of 3 or 5.");
				sum += i;
			}
		}
		System.out.print("Sum of all is equal: " + sum);
	}

	public static void evenFibonacciNumbers() {
		int sum = 0;
		int first = 1;
		int second = 1;
		int nextFibboNr = 1;
		while (nextFibboNr < 4000000) {
			if (Reuseable.isEvenValue(nextFibboNr))
				sum += nextFibboNr;
			nextFibboNr = first + second;
			first = second;
			second = nextFibboNr;
		}
		System.out.println(sum);
	}

	public static void largestPrimeFactor() {
		long number = 600851475143L;
		ArrayList<Integer> factorizedNumbers = new ArrayList<>();
		for (long i = 1; i < number; i++)
			if (number % i == 0)
				if (Reuseable.isPrime(i))
					factorizedNumbers.add((int) i);

		int largestPrimeFactor = Collections.max(factorizedNumbers);
		System.out.println(factorizedNumbers);
		System.out.println(largestPrimeFactor);
	}

	public static void largestPalindromeProduct() {
		int palindromicNumber;
		ArrayList<Integer> palindromicList = new ArrayList<>();
		for (int number = 100; number < 1000; number++) {
			for (int nextNumber = 101; nextNumber < 1000; nextNumber++) {
				palindromicNumber = number * nextNumber;
				int reversed = Integer.parseInt(new StringBuilder().append(palindromicNumber).reverse().toString());
				if (palindromicNumber == reversed) {
					palindromicList.add(palindromicNumber);
				}
			}
		}
		System.out.println(palindromicList);
		System.out.println(Collections.max(palindromicList));
	}

	public static void smallestMultiple() {

		for (int i = 1; true; i++) {
			int allNumbers = 0;
			for (int x = 1; x < 21; x++) {
				if (i % x == 0) {
					allNumbers++;
				} else {
					break;
				}
			}
			if (allNumbers == 20) {
				System.out.print(i);
				break;
			}
		}
	}

	public static void sumSquareDifferece() {
		int sumOfSquares = 0, squaresOfSum, difference;
		ArrayList<Integer> intRange = new ArrayList<>();
//		IntStream.range(1, 11).forEach(intRange::add);
		squaresOfSum = IntStream.rangeClosed(1, 100).sum();
		squaresOfSum = (int) Math.pow(squaresOfSum, 2);
		for (int i = 1; i < 101; i++) {
			intRange.add((int) Math.pow(i, 2));
		}
		sumOfSquares = intRange.stream().mapToInt(Integer::intValue).sum();
		difference = squaresOfSum - sumOfSquares;
		System.out.print(difference);
	}

	public static void listOf10001Prime() {
		ArrayList<Integer> primeList = new ArrayList<>();
		IntStream.rangeClosed(2, 1000001)
				.filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0))
				.forEach(primeList::add);
		System.out.print(primeList.get(10000));

	}

	public static void largestProduktInSeries() {
		ArrayList<String> listOfAdjacentNumbers = new ArrayList<>();
		String list = null;
		long first = 0, maxNumber = 1;
		String digits = "73167176531330624919225119674426574742355349194934"
				+ "96983520312774506326239578318016984801869478851843"
				+ "85861560789112949495459501737958331952853208805511"
				+ "12540698747158523863050715693290963295227443043557"
				+ "66896648950445244523161731856403098711121722383113"
				+ "62229893423380308135336276614282806444486645238749"
				+ "30358907296290491560440772390713810515859307960866"
				+ "70172427121883998797908792274921901699720888093776"
				+ "65727333001053367881220235421809751254540594752243"
				+ "52584907711670556013604839586446706324415722155397"
				+ "53697817977846174064955149290862569321978468622482"
				+ "83972241375657056057490261407972968652414535100474"
				+ "82166370484403199890008895243450658541227588666881"
				+ "16427171479924442928230863465674813919123162824586"
				+ "17866458359124566529476545682848912883142607690042"
				+ "24219022671055626321111109370544217506941658960408"
				+ "07198403850962455444362981230987879927244284909188"
				+ "84580156166097919133875499200524063689912560717606"
				+ "05886116467109405077541002256983155200055935729725"
				+ "71636269561882670428252483600823257530420752963450";
		for (int i = 0; i <= digits.length() - 13; i++) {
			for (int j = i; j < i + 13; j++) {
				maxNumber *= Character.getNumericValue(digits.charAt(j));
				listOfAdjacentNumbers.add(String.valueOf(digits.charAt(j)));
			}
			if (first < maxNumber) {
				first = maxNumber;
				list = String.join(", ", listOfAdjacentNumbers);
			}
			maxNumber = 1;
			listOfAdjacentNumbers.clear();
			list.replaceAll("", list);
		}

		System.out.println("Largest product of seire (" + list + ") is " + first);
	}

	public static void specialPythagoreanTriple() {

		for (int a = 0; a < 1001; a++) {
			for (int b = 0; b < 1001; b++) {
				for (int c = 0; c < 1001; c++) {
					if (a + b + c == 1000 && a < b && b < c && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
						System.out.print(a + " * " + b + " * " + c + " = " + (a * b * c));
				}
			}
		}
	}

	public static void summationOfPrimes() {
		ArrayList<Long> primeNumbers = new ArrayList<>();
		for (int i = 0; i < 2000001; i++) {
			if (Reuseable.isPrime(i)) {
				primeNumbers.add((long) i);
			}
		}
		System.out.println(primeNumbers.stream().mapToLong(Long::longValue).sum());
	}

	public static void largestProductInGrid() {
		int productofNr = 1, compare = 0;
		int[][] grid = { { 8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8 },
				{ 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0 },
				{ 81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65 },
				{ 52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91 },
				{ 22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80 },
				{ 24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50 },
				{ 32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70 },
				{ 67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21 },
				{ 24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72 },
				{ 21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95 },
				{ 78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92 },
				{ 16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57 },
				{ 86, 56, 0, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58 },
				{ 19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40 },
				{ 4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66 },
				{ 88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69 },
				{ 4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36 },
				{ 20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16 },
				{ 20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54 },
				{ 1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48 } };
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 20; column++) {
				// to right and to Downward
				if (column < 17) {
					// to right
					productofNr = grid[row][column] * grid[row][column + 1] * grid[row][column + 2]
							* grid[row][column + 3];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
				if (row < 17) {
					// downward
					productofNr = grid[row][column] * grid[row + 1][column] * grid[row + 2][column]
							* grid[row + 3][column];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
				// to left and to upward
				if (column > 2) {
					// left
					productofNr = grid[row][column] * grid[row][column - 1] * grid[row][column - 2]
							* grid[row][column - 3];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
				if (row > 2) {
					// upward
					productofNr = grid[row][column] * grid[row - 1][column] * grid[row - 2][column]
							* grid[row - 3][column];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
				// diagonal up and right
				if (row > 2 && column < 17) {
					productofNr = grid[row][column] * grid[row - 1][column + 1] * grid[row - 2][column + 2]
							* grid[row - 3][column + 3];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
				// diagonal up and left
				if (row > 2 && column > 2) {
					productofNr = grid[row][column] * grid[row - 1][column - 1] * grid[row - 2][column - 2]
							* grid[row - 3][column - 3];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
				// diagonal down and left
				if (row < 17 && column > 2) {
					productofNr = grid[row][column] * grid[row + 1][column - 1] * grid[row + 2][column - 2]
							* grid[row + 3][column - 3];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
				// diagonal down and right
				if (row < 17 && column < 17) {
					productofNr = grid[row][column] * grid[row + 1][column + 1] * grid[row + 2][column + 2]
							* grid[row + 3][column + 3];
					Reuseable.keepBiggerValue(productofNr, compare);
					int result[] = Reuseable.keepBiggerValue(productofNr, compare);
					productofNr = result[0];
					compare = result[1];
				}
			}
		}
		System.out.print(compare);
	}
}
