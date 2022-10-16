package com.grace.swish.model;

import java.io.Serializable;

import jakarta.persistence.GenerationType;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Platform implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long platformId;
	private String platformName;

}
