package com.ms4.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms4.client.entity.Role;
import com.ms4.client.exception.ResourceNotFoundException;
import com.ms4.client.repository.RoleRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/roles")
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}	
	
	@PostMapping("/roles")
	public Role createRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	// get employee by id rest api
		@GetMapping("/roles/{id}")
		public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
			Role role = roleRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			return ResponseEntity.ok(role);
		}
		
		@PutMapping("/roles/{id}")
		public ResponseEntity<Role> updateRolee(@PathVariable Integer id, @RequestBody Role roleDetails){
			Role role = roleRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			role.setDescription(roleDetails.getDescription());
			role.setDetails(roleDetails.getDetails());
			
			
			Role updatedRole = roleRepository.save(role);
			return ResponseEntity.ok(updatedRole);
		}
		// delete employee rest api
		@DeleteMapping("/roles/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteRole(@PathVariable Integer id){
			Role role = roleRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			roleRepository.delete(role);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
