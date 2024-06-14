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

public class Course {
	public String name;
	public String  desc;
	public Integer  fee;

}