package com.example.demo.mathTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.example.demo.Method.PrimeNumber;

@RunWith(Parameterized.class)
public class PrimeNumberTest {

	PrimeNumber primeNumber;
	int num1;
	Boolean excepted;

	public PrimeNumberTest(int num1, Boolean excepted) {
		super();
		this.num1 = num1;
		this.excepted = excepted;
	}

	@Before
	public void init() {
		primeNumber = new PrimeNumber();
	}

	@Parameterized.Parameters
	public static Collection primenums() {
		return Arrays.asList(
				new Object[][] { { 2, true }, { 6, true }, { 6, false }, { 19, true }, { 22, false }, { 23, true } });
	}

	@Test
	public void test() {
		assertEquals(excepted, primeNumber.isPrime(num1));
	}
}
