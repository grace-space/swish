package com.grace.swish.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Multiplayer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long multiId;
	private String multiType;

}
