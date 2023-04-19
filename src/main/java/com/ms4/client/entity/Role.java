package com.ms4.client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class Role {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
private Long id;
private String description;
private String details;

}
