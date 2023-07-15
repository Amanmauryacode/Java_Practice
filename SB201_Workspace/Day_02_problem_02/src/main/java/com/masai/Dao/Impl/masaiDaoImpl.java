package com.masai.Dao.Impl;

import javax.persistence.EntityManager;

import com.masai.Dao.masaiDAO;
import com.masai.EMUtil.DBUtil;
import com.masai.entity.Student;

public class masaiDaoImpl implements masaiDAO {

	public Student findStudentById(int id) {
		EntityManager em = DBUtil.getEntityManager();

		Student student = em.find(Student.class, id);

		em.close();
		return student;
	}

	public String saveStudent(Student student) {
		EntityManager em = DBUtil.getEntityManager();

		String msg = "Student Inserted";

		em.getTransaction().begin();

		em.persist(student);

		em.getTransaction().commit();
		em.close();

		return msg;

	}

	public String deleteStudentById(int id) {
		EntityManager em = DBUtil.getEntityManager();

		String msg = "Student Sucessfully Deleted";

		Student student = em.find(Student.class, id);

		if (student != null) {
			em.getTransaction().begin();

			em.remove(student);

			em.getTransaction().commit();
		} else {
			msg = "Student Not Exist!";
		}

		em.close();

		return msg;
	}

	public String updateStudentLevel(int id, int level) {
		String msg = "Student Sucessfully Updated";
		EntityManager em = DBUtil.getEntityManager();
		Student student = em.find(Student.class, id);
		
		if (student != null) {
			em.getTransaction().begin();
			student.setLevel(level);
			em.getTransaction().commit();
		} else {
			msg = "Student Not Exist!";
		}

		em.close();
		return msg;
	}

}
