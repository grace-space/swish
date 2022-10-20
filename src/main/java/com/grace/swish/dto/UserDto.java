package com.grace.swish.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private long userId;
	
	@NotEmpty(message = "Username cannot be blank")
	private String username;
	
	@NotEmpty(message = "E-mail cannot be blank")
	@Email
	private String email;
	
	@NotEmpty(message = "Password cannot be blank")
	private String password;
	
	

}
