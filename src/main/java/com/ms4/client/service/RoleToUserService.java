package com.ms4.client.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms4.client.entity.Role;
import com.ms4.client.entity.User;
import com.ms4.client.repository.RoleRepository;
import com.ms4.client.repository.UserRepository;

@Service
public class RoleToUserService {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	// Assign role to user
	public void assignUserRole(Long userId, Integer roleId) {
		User user = userRepository.findById(userId).orElse(null);
		Role role = roleRepository.findById(roleId).orElse(null);
		Set<Role> userRoles =  user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		userRepository.save(user);
		
	}
	public void unassignUserRole(Integer userId, Integer roleId){
	    User user  = userRepository.findById(userId).orElse(null);
	    user.getRoles().removeIf(x -> x.getId()==roleId);
	    userRepository.save(user);
	}
	//https://www.kindsonthegenius.com/spring-boot/complete-application-with-spring-boot-role-based-authorization/
}
