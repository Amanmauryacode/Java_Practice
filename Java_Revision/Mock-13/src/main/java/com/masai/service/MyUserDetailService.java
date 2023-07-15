package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userOpt = userRepo.findByUserName(username);
		if(userOpt.isEmpty())throw new UsernameNotFoundException("User not found with name : "+username);
		
		User user = userOpt.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		SimpleGrantedAuthority sga=new SimpleGrantedAuthority(user.getRole().toString());
		authorities.add(sga);
		
		return new org.springframework.security.core.userdetails.User(username, username, authorities);
	}

}
