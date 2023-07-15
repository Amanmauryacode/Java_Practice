package com.masai.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.masai.entity.Student;
import com.masai.entity.Teacher;
import com.masai.exception.StudentNotFoundException;
import com.masai.exception.TeacherNotFoundException;
import com.masai.utility.EMUtil;

public class CollageDAOImpl implements CollageDAO {

	@Override
	public void addStudent(Student student) {

		EntityManager em = EMUtil.provideEntityManager();
		em.getTransaction().begin();;
		em.persist(student);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Student getStudent(int studentId) throws StudentNotFoundException {
		
		EntityManager em = EMUtil.provideEntityManager();
		Student std = em.find(Student.class, studentId);
		if(std==null)throw new StudentNotFoundException("Student Not Found ");
		return std;
	}

	@Override
	public void registerTeacher(Teacher teacher, int id)throws StudentNotFoundException {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		Student std = em.find(Student.class, id);
		if(std==null)throw new StudentNotFoundException("Student Not Found ");
		
		em.getTransaction().begin();
		em.persist(teacher);
		em.getTransaction().commit();
		em.close();
		System.out.println("Done");
		
	}

	@Override
	public Teacher getTeacher(int teacherId) throws TeacherNotFoundException{

		EntityManager em = EMUtil.provideEntityManager();
		Teacher teacher = em.find(Teacher.class, teacherId);
		if(teacher==null)throw new TeacherNotFoundException("Teacher Not Found ");
		return teacher;
	}

	@Override
	public void registerTeacherWithDiffStudents(int teacherId, int studentId)throws TeacherNotFoundException,StudentNotFoundException {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Student std = em.find(Student.class, studentId);
		if(std==null)throw new StudentNotFoundException("Student Not Found ");
		
		Teacher teacher = em.find(Teacher.class, teacherId);
		if(teacher==null)throw new TeacherNotFoundException("Teacher Not Found ");
		
		
		
		em.getTransaction().begin();
		std.getTeacherList().add(teacher);
		em.getTransaction().commit();
		em.close();
		
	}

}
