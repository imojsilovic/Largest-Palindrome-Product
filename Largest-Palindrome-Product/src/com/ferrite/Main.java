package com.ferrite;

public class Main {

	public static void main(String[] args) {
		System.out.println("Start...");
		System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);

		System.out.println("Iteration method.");

		long beginTime = System.nanoTime();

		long palindrome = 999_999L;

		boolean notFound = true;
		while (notFound) {
			for (long factor = 999L; factor > 99L; --factor) {
				if (palindrome % factor == 0 && palindrome / factor < 1_000L) {
					notFound = false;
					break;
				}
			}
			if (notFound) {
				palindrome = prevPalindrome(palindrome);
			}
		}

		System.out.println(String.format("Time: %.3f [ms]", (System.nanoTime() - beginTime) / 1_000_000.));
		System.out.println("Largest palindrome: " + palindrome);

		System.out.println("End.");

	}

	public static long prevPalindrome(long palindrome) {
		long palindromeBase = palindrome / 1_000L - 1L;
		for (long extend = palindromeBase; extend > 0; extend /= 10) {
			palindromeBase = palindromeBase * 10L + extend % 10L;
		}
		return palindromeBase;
	}

}
