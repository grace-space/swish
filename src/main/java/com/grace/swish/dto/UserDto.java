package com.grace.swish.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private long userId;
	
	@NotEmpty
	private String username;
	
	@NotEmpty(message = "Email should not be empty")
	@Email
	private String email;
	
	@NotEmpty(message = "Password should not be empty")
	private String password;
	
	

}
