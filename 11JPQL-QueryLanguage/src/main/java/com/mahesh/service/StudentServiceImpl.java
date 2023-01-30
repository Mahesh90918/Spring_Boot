package com.mahesh.service;

import java.util.Iterator;
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

	@Override
	public Student deleteById2(Integer sid) {
		Iterator<Student> iterator = findAll().iterator();
		while (iterator.hasNext()) {
			Student stu = iterator.next();
			if (stu.getSid() == sid) {
				iterator.remove();
				return stu; // returns the deleted resource back
			}
		}
		return null;
	}

//	-----------------------

	@Override
	public List<Student> findBySname(String sname) {
		// TODO Auto-generated method stub
		return studentRepositry.findBySname(sname);
	}

	@Override
	public List<Student> findBySnameAndSfee(String sname, double sfee) {
		// TODO Auto-generated method stub
		return studentRepositry.findBySnameAndSfee(sname, sfee);
	}

	@Override
	public List<Student> findBySnameOrSfee(String sname, double sfee) {
		// TODO Auto-generated method stub
		return studentRepositry.findBySnameOrSfee(sname, sfee);
	}

	// -----Normal Way---------------

	@Override
	public List<Student> findBySname1(String sname) {
		// TODO Auto-generated method stub
		return studentRepositry.findBySname(sname);
	}

	@Override
	public List<Student> findBySnameAndSfee1(String sname, double sfee) {
		// TODO Auto-generated method stub
		return studentRepositry.findBySnameAndSfee1(sname, sfee);
	}

	@Override
	public List<Student> findBySnameOrSfee1(String sname, double sfee) {
		// TODO Auto-generated method stub
		return studentRepositry.findBySnameOrSfee1(sname, sfee);
	}

}
