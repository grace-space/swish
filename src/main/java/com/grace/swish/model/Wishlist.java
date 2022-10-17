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
public class Wishlist implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wishlistId;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToMany
//	@JoinColumn(name = "gameId")
	@JoinTable(
			name = "wishlist_games",
			joinColumns = { @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlistId") },
			inverseJoinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") }
			)
	private Set<Game> games;
	
	
	

}
