package com.grace.swish.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Format implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long formatId;
	private String formatType;
	
	@ManyToMany(mappedBy = "formats")
	private Set<Game> games;
	

}
