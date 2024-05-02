package com.cms.demo.courses;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
	public String name;
	public String mobile;
	public String email;
	public String password;
	public String username;

}
