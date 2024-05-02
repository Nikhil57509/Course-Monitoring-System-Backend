package com.cms.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.demo.courses.Course;
import com.cms.demo.model.Coursemodel;
import com.cms.demo.repo.Courserepo;
@Service
public class Courseserviceimpl implements Courseservice {

	@Autowired
	private Courserepo courserepo;
	public List<Course> getallcourses() {
		
		List<Coursemodel> courses=courserepo.findAll();
		return this.convertcourses(courses);
	}
	private List<Course> convertcourses(List<Coursemodel> courses) {
		// TODO Auto-generated method stub
List<Course> coursess =new ArrayList<>();
for(Coursemodel c:courses)
{
      Course cou=new Course(c.getName(),c.getDescription(),c.getFee());
      coursess.add(cou);
}
return coursess;
}

}

