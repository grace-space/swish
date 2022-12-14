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
public class Retailer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long retailerId;
	private String retailerName;
	
//	@ManyToMany(mappedBy = "retailers")
//	private Set<Game> games;

}
