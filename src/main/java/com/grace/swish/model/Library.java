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
public class Library implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long libraryId;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToMany
	@JoinColumn(name = "gameId")
	private Set<Game> games;

}
