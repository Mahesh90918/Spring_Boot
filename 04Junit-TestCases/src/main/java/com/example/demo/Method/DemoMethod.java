package com.example.demo.Method;

public class DemoMethod {

	public int sum(int a, int b) {

		if (a < 0 || b < 0) {
			throw new IllegalAccessError();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return a + b;

	}

	public static void main(String[] args) {
		DemoMethod d = new DemoMethod();
		int excepted = 30;
		int actual = d.sum(10, 20);
		if (excepted == actual) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
	}
}
