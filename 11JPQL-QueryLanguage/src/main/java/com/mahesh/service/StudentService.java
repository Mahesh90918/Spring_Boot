package com.mahesh.service;

import java.util.List;
import java.util.Optional;

import com.mahesh.bean.Student;

public interface StudentService {

	Student save(Student student);

	Student update(Student student);

	Student saveorUpdate(Student student);

	Student FindById(Integer sid);

	Optional<Student> FindById1(Integer sid);

	void delete(Integer sid);

	void deleteById(Integer sid);

	Student deleteById2(Integer sid);

	List<Student> findAll();

	List<Student> findBySname(String sname);

	List<Student> findBySnameAndSfee(String sname, double sfee);

	List<Student> findBySnameOrSfee(String sname, double sfee);

	List<Student> findBySname1(String sname);

	List<Student> findBySnameAndSfee1(String sname, double sfee);

	List<Student> findBySnameOrSfee1(String sname, double sfee);
}
