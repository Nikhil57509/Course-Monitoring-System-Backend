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
public class CourseDTO {
    private String name;
    private String description;
    private String duration;
    private LocalDate startDate;
    private LocalDate endDate;
    private String schedule;
    private String status;
    private float cost;

    // Getters and setters
}
