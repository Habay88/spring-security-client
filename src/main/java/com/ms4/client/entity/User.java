package com.ms4.client.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Column(length = 60)
    private String password;

   //private String role;
    private boolean enabled = false;

@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
@JoinTable(
		name = "user_role",
		joinColumns = {@JoinColumn(name = "user_id")},
		inverseJoinColumns= {@JoinColumn(name= "role_id")}
		)
    private Set<Role> role = new HashSet<>(); 
    
   
}
