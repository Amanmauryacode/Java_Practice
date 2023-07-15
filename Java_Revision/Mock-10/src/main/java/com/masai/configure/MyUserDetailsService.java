package com.masai.configure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.entity.MyUserDetails;
import com.masai.entity.User;
import com.masai.repository.UserRepository;

@Service
public class MyUserDetailsService implements  UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> optUser  = userRepo.findByUserName(username);
		if(optUser.isPresent()) {
			return new MyUserDetails(optUser.get());
		}else {
			throw new UsernameNotFoundException("User not found in record with name : "+username);
		}
	}

}
