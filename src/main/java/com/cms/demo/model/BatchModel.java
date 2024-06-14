package com.cms.demo.model;



import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class BatchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String courseName;
    private String instructorName;
    private int capacity;
    private int currentEnrollment;
 private  LocalDateTime time;
    private String status;
    private String description;
    private LocalDate createdDate;
    private LocalDate updatedDate;

}