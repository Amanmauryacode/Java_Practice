package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Email;
import com.masai.model.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	@Query("select u.email from User u where u.id=?1 And u.email.mail_id = ?2")
	public Email getEmailDetailsFromUser(Integer uid,Integer eid);
}
