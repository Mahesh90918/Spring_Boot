package com.example.demo.mathTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.demo.Method.DemoMethod;

@RunWith(Parameterized.class)
public class ParaMetarizedTest {
	private DemoMethod demoMethod;
	private int num1;
	private int num2;
	private int excepted;

	public ParaMetarizedTest(int num1, int num2, int excepted) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.excepted = excepted;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> sumresults() {
		return Arrays.asList(new Object[][] { { 1, 2, 3 }, { 3, 2, 5 }, { 5, 2, 7 }, { 5, 2, 4 }, { 5, 5, 7 } });
	}

	@Before
	public void init() {
		demoMethod = new DemoMethod();
	}

	@Test
	public void test() {
		assertEquals(excepted, demoMethod.sum(num1, num2));
	}

}
