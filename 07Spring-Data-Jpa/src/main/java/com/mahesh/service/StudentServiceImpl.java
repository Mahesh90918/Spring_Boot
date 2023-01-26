package com.mahesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.bean.Student;
import com.mahesh.dao.StudentRepositry;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepositry studentRepositry;

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepositry.save(student);
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return studentRepositry.save(student);
	}

	@Override
	public Student saveorUpdate(Student student) {
		// TODO Auto-generated method stub
		return studentRepositry.save(student);
	}

	@Override
	public Student FindById(Integer sid) {
		// TODO Auto-generated method stub
		return studentRepositry.findById(sid).get();
	}

	@Override
	public Optional<Student> FindById1(Integer sid) {
		// TODO Auto-generated method stub
		return studentRepositry.findById(sid);
	}

	@Override
	public void delete(Integer sid) {
		// TODO Auto-generated method stub
		Student entity = new Student();
		entity.setSid(sid);
		studentRepositry.delete(entity);

	}

	@Override
	public void deleteById(Integer sid) {

		studentRepositry.deleteById(sid);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepositry.findAll();
	}

}
