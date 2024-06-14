package com.cms.demo.courses;

import java.time.LocalDate;

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
public class Batch {
    private Long id;
    private String batchName;
    private String startDate;
    private String endDate;
    private String courseName;
    private String instructorName;
    private int capacity;
    private int currentEnrollment;
    private String status;
    public String Time;
    private String description;
    private String createdDate;
    private String updatedDate;
	public void setStartDate(LocalDate localDate) {
		// TODO Auto-generated method stub
		
	}
	public void setEndDate(LocalDate localDate) {
		// TODO Auto-generated method stub
		
	}
	public void setCreatedDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}
	public void setUpdatedDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}
	public void setStartDate(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setEndDate(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setCreatedDate(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setUpdatedDate(Object now) {
		// TODO Auto-generated method stub
		
	}
	
    
}
