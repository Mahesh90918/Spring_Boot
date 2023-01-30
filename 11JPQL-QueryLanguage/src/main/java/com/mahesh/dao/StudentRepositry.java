package com.mahesh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mahesh.bean.Student;

public interface StudentRepositry extends JpaRepository<Student, Integer> {

	// first Way
	// Select * from Student where sname=?"
	List<Student> findBySname(String sname);

	// Select * from Student where sname=? and sfee=?"
	List<Student> findBySnameAndSfee(String sname, double sfee);

	// Select * from Student where sname=? or sfee=?"
	List<Student> findBySnameOrSfee(String sname, double sfee);

	// -------------------------------------------------------------------------------------
	// Second Way
	// HIBERNATE Query
	// Select * from Student where sname=?"
	@Query(value = "Select s from Student s where sname=?1")
	List<Student> findBySname1(String sname);

	// Select * from Student where sname=? and sfee=?"
	@Query(value = "Select s from Student s where sname=?1 and sfee=?2")
	List<Student> findBySnameAndSfee1(String sname, double sfee);

	// Select * from Student where sname=? or sfee=?"
	@Query(value = "Select s from Student s where sname=?1 or sfee=?2")
	List<Student> findBySnameOrSfee1(String sname, double sfee);

	// Select s from Student s where sname like %?1%
	@Query(value = "Select s from Student s where sname like %?1%")
	List<Student> sameAsLIke(String sname);
//-------------------------------------------------------------------------------------

	// Third Way
	// Select * from Student_Jpa1 where sname=?"
	// SQL Query
	@Query(value = "Select * from student_jpa1 where sname=?1", nativeQuery = true)
	List<Student> findBySname2(String sname);

	// Select * from Student_Jpa1 where sname=? and sfee=?"
	@Query(value = "Select * from student_jpa1 where sname=?1 and sfee=?2", nativeQuery = true)
	List<Student> findBySnameAndSfee2(String sname, double sfee);

	// Select * from Student_Jpa1 where sname=? or sfee=?"
	@Query(value = "Select * from student_jpa1 where sname=?1 or sfee=?2", nativeQuery = true)
	List<Student> findBySnameOrSfee2(String sname, double sfee);

	// -------------------------------------------------------------------------------------

	// fourth Way
	// Named Query
	// This Name is Equal to Named Query Name
	List<Object[]> maheshFindAll(String sname);

	List<Object[]> maheshFindAll1(String sname);

}
