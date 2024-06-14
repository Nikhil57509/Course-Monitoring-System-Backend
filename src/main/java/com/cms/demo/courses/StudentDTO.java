package com.cms.demo.courses;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class StudentDTO {
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;
    
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;
    
    @Size(min = 6, message = "Confirm Password should have at least 6 characters")
    private String confirmPassword;
    
    @NotBlank(message = "Qualification is mandatory")
    @Pattern(regexp = "^(?!Qualification$).*", message = "Please select a valid qualification")
    private String qualification;
    
    @NotNull(message = "Passout Year is mandatory")
    @Min(value = 2000, message = "Passout Year must be greater than or equal to 2000")
    @Max(value = 2024, message = "Passout Year must be less than or equal to the current year")
    private int passoutYear;
    
    @NotBlank(message = "Selected Course is mandatory")
    private String selectedCourse;

    // Getters and setters

    // Method to validate password and confirmPassword
    public boolean isPasswordConfirmed() {
        return this.password.equals(this.confirmPassword);
    }

	 
	
}
