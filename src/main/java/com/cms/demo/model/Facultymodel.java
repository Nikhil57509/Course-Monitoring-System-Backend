package com.cms.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Facultymodel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Facultyid;
	private String name;
	private String  mobile;
	private String email;
	private String username;
	private String password;

}
