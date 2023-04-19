//package com.ms4.client.service;
//
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ms4.client.entity.Role;
//import com.ms4.client.entity.User;
//import com.ms4.client.repository.RoleRepository;
//import com.ms4.client.repository.UserRepository;
//
//@Service
//public class RoleToUserService {
//
//	@Autowired
//	RoleRepository roleRepository;
//	
//	@Autowired
//	UserRepository userRepository;
//	
//	// Assign role to user
//	public void assignUserRole(Long userId, Integer roleId) {
//		User user = userRepository.findById(userId).orElse(null);
//		Role role = roleRepository.findById(roleId).orElse(null);
//		Set<Role> userRoles =  user.getRole();
//		userRoles.add(role);
//		user.setRole(userRoles);
//		userRepository.save(user);
//		
//	}
//	public void unassignUserRole(Long userId, Integer roleId){
//	    User user  = userRepository.findById(userId).orElse(null);
//	    user.getRole().removeIf(x -> x.getId()==roleId);
//	    userRepository.save(user);
//	}
//	public Set<Role> getUserRoles(User user) {
//		// TODO Auto-generated method stub
//		return user.getRole();
//	} 
//	public List<Role> getUserNotRoles(User user){
//		   return roleRepository.getUserNotRoles(user.getId());
//		}
//	
//	//https://www.kindsonthegenius.com/spring-boot/complete-application-with-spring-boot-role-based-authorization/
//}
