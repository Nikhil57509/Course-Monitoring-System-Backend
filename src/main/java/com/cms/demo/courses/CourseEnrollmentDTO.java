package com.cms.demo.courses;



import java.util.List;

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
public class CourseEnrollmentDTO {
   
    private Long studentId;
    private List<Long> courseIds;
    private String studentName;
}
