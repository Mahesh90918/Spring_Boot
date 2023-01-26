package com.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.Matchers.stringContainsInOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.bean.Employee;

public class HamcrestTest {
	@Test
	public void test1() {
		String str = "abc";
		String str1 = "ABC";
		assertThat(str, equalToIgnoringCase(str1));
		assertThat("abc", is("abc"));
		assertThat("abc", equalToIgnoringWhiteSpace("   abc  "));
		assertThat("abc", is(equalToIgnoringWhiteSpace("   abc  ")));
		assertThat("abc", not(equalToIgnoringWhiteSpace("   abcd  ")));
	}

	@Test
	public void givenString_whenContainsGivenSubstring_thenCorrect() {
		String str = "calligraphy";
		assertThat(str, stringContainsInOrder(Arrays.asList("call", "graph")));
	}

	@Test
	public void test2() {
		Employee e1 = new Employee(01, "mahesh", 321, "sdfg");
		Employee e2 = new Employee(01, "mahesh", 321, "sdfg");
		assertThat(e1, equalTo(e2));
	}

	@Test
	public void given2Beans_whenHavingSameValues_thenCorrect() {
		Employee e1 = new Employee(01, "mahesh", 321, "sdfg");
		Employee e2 = new Employee(01, "mahesh", 321, "sdfg");
		assertThat(e1, samePropertyValuesAs(e2));
	}

	@Test
	public void givenBean_whenToStringReturnsRequiredString_thenCorrect() {
		Employee e1 = new Employee(01, "mahesh", 321, "sdfg");
		String str = e1.toString();
		assertThat(e1, hasToString(str));
	}

	@Test
	public void givenBean_whenHasValue_thenCorrect() {
		Employee e1 = new Employee(01, "mahesh", 321, "sdfg");
		assertThat(e1, hasProperty("name"));
		assertThat(e1, instanceOf(Employee.class));
		assertThat(e1, sameInstance(e1));
	}

	@Test
	public void givenBean_whenHasCorrectValue_thenCorrect() {
		Employee e1 = new Employee(01, "siva", 321, "sdfg");
		assertThat(e1, hasProperty("name", equalTo("siva")));
	}

	@Test
	public void givenCollection_whenEmpty_thenCorrect() {
		List<String> emptyList = new ArrayList<>();
		assertThat(emptyList, empty());
	}

	@Test
	public void givenAListAndValues_whenChecksListForGivenValues_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList("collections", "beans", "text", "number");
		assertThat(hamcrestMatchers, containsInAnyOrder("beans", "text", "collections", "number"));
	}

	@Test
	public void givenArrayAndValue_whenValueFoundInArray_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList("collections", "beans", "text", "number");
		assertThat(hamcrestMatchers, hasItems("text"));
	}

	@Test
	public void givenArrayAndValue_whenValueFoundInArray_thenCorrect1() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat("text", isOneOf(hamcrestMatchers));
	}

	@Test
	public void givenAnInteger_whenGreaterThan0_thenCorrect() {
		assertThat(1, greaterThan(0));
		assertThat(5, greaterThanOrEqualTo(5));
		assertThat(5, lessThan(7));
		assertThat(5, lessThanOrEqualTo(7));
	}

	@Test
	public void givenADouble_whenCloseTo_thenCorrect() {
		assertThat(1.2, closeTo(1, 0.5));
	}

	@Test
	public void givenList_whenEachElementGreaterThan0_thenCorrect() {
		List<Integer> list = Arrays.asList(2, 3, 5, 6);
		int baseCase = 1;
		assertThat(list, everyItem(greaterThan(baseCase)));
	}
}
