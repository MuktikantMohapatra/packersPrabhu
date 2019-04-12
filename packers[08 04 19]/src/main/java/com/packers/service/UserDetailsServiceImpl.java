package com.packers.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.packers.bo.RolesBO;
import com.packers.bo.UserDetailsBO;
import com.packers.repo.RoleRepository;
import com.packers.repo.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsRepository userRepository;
/* @Autowired
	private RoleRepository roleRepository;*/
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetailsBO userDetails = userRepository.findByEmail(email);
	
		
		if (userDetails == null) {
			throw new UsernameNotFoundException("Email is invalid");
		}
System.out.println(userDetails);
				return new User(userDetails.getEmail(), userDetails.getPassword(), userDetails.getAuthoritites());
	}
}
