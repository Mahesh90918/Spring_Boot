package com.mahesh.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mahesh.bean.Student;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

	@Autowired
	StudentRepositry studentRepositry;

	@Test
	public void connectionTest() {
		assertNotNull(studentRepositry);
		System.out.println(studentRepositry);
	}

	@Test
	public void findAll() {
		List<Student> list = studentRepositry.findAll();
		assertThat(list, not(empty()));
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void SameAsLike() {
		List<Student> list = studentRepositry.sameAsLIke("M");
		System.out.println(list);

	}

	@Test
	public void findByname() {
		List<Student> list1 = studentRepositry.findBySname("mahesh");
		List<Student> list2 = studentRepositry.findBySname1("mahesh");
		List<Student> list3 = studentRepositry.findBySname2("mahesh");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);

	}

	@Test
	public void FindByNameAndFee() {
		List<Student> list1 = studentRepositry.findBySnameAndSfee("mahesh", 10000.00);
		List<Student> list2 = studentRepositry.findBySnameAndSfee1("mahesh", 10000.00);
		List<Student> list3 = studentRepositry.findBySnameAndSfee2("mahesh", 10000.00);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);

	}

	@Test
	public void FindByNameOrFee() {
		List<Student> list1 = studentRepositry.findBySnameOrSfee("mahesh", 10000.00);
		List<Student> list2 = studentRepositry.findBySnameOrSfee1("mahesh", 10000.00);
		List<Student> list3 = studentRepositry.findBySnameOrSfee2("mahesh", 10000.00);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);

	}

	@Test
	public void namedQquery() {
		Student s1 = new Student(01, "mahesh", 12345, "mahses@sadds");
		Student s2 = new Student(01, "mahesh", 12345, "mahses@sadds");

		List<Object[]> list1 = studentRepositry.maheshFindAll(s1.getSname());
		List<Object[]> list2 = studentRepositry.maheshFindAll1(s2.getSname());
		for (Object[] objects : list1) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
			System.out.println(objects[3]);
		}
		for (Object[] objects : list2) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
			System.out.println(objects[3]);
		}
	}

}
