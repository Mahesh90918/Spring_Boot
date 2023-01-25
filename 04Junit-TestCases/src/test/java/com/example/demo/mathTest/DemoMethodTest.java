package com.example.demo.mathTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.demo.Method.DemoMethod;

public class DemoMethodTest {

	private static DemoMethod demo = new DemoMethod();

	@BeforeClass
	public static void beforeclass() {
		System.out.println("Before Class");
		demo = new DemoMethod();
	}

	@Before
	public void before() {
		System.out.println("Before ");

	}

	@After
	public void after() {
		System.out.println("After");

	}

	@Test
	public void test() {
		System.out.println("test ");
		assertEquals(30,demo.sum(10, 20));
	}
	@Test
	public void test1() {
		System.out.println("test 1");
		demo.sum(10, 20);
	}

	// Exception Handling
	@Test(expected = IllegalAccessError.class)
	public void test2() {
		System.out.println("test 2");
		demo.sum(-10, 20);
	}

	// Exception Handling
	@Test(expected = IllegalAccessError.class)
	public void test3() {
		System.out.println("test 3");
		System.out.println("It will get IllegalAccessError");
		demo.sum(10, -20);
	}

	@Test(timeout = 3000)
	@Ignore
	public void test4() {
		System.out.println("test 4");
		System.out.println("It will take Above 3 Seconds");
		demo.sum(10, 20);
	}

	@AfterClass
	public static void afterclass() {
		System.out.println("After Class");
	}

}
