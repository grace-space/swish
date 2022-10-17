package com.grace.swish.model;


import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Multiplayer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long multiplayerId;
	private String multiplayerType;
	
	@ManyToMany(mappedBy = "players")
	private Set<Game> games;

}
