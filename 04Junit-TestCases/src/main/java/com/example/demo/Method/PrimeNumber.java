package com.example.demo.Method;

public class PrimeNumber {

	public static boolean isPrime(final int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isPrime(3));
	}

}
