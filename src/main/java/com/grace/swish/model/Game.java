package com.grace.swish.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gameId;
	
	private String title;
	
	private double rating;
	
	private double msrp;
	
	private String imgUrl;
	
	@ManyToMany(mappedBy = "games")
	private Set<Wishlist> wishlists;
	
	@ManyToMany(mappedBy = "games")
	private Set<Library> libraries;
	
	@ManyToMany
//	@JoinColumn(name = "genreId")
	@JoinTable(
			name = "game_genres",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "genre_id", referencedColumnName = "genreId") }
			)
	private Set<Genre> genres;
	
	@ManyToMany
//	@JoinColumn(name = "platformId")
	@JoinTable(
			name = "game_platforms",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "platform_id", referencedColumnName = "platformId") }
			)
	private Set<Platform> platforms;
	
	@ManyToMany
//	@JoinColumn(name = "formatId")
	@JoinTable(
			name = "game_format",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "format_id", referencedColumnName = "formatId") }
			)
	private Set<Format> formats;
	
	@ManyToMany
//	@JoinColumn(name = "retailerId")
	@JoinTable(
			name = "game_retailer",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "retailer_id", referencedColumnName = "retailerId") }
			)
	private Set<Retailer> retailers;
	
	@ManyToMany
//	@JoinColumn(name = "multiplayerId")
	@JoinTable(
			name = "game_multiplayer",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "multiplayer_id", referencedColumnName = "multiplayerId") }
			)
	private Set<Multiplayer> players;
	

}
