package com.grace.swish.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToMany(mappedBy = "platforms", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonBackReference
	@JsonIgnore
	private Set<Game> games;

}
