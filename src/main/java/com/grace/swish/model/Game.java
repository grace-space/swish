package com.grace.swish.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
	
	@Column(columnDefinition = "text")
	private String description;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "library")
	private Set<User> libraryUsers;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "wishlist")
	private Set<User> wishlistUsers;

	@ManyToMany
	@JoinTable(
			name = "game_genres",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "genre_id", referencedColumnName = "genreId") }
			)
	private Set<Genre> genres;
	
	@ManyToMany
	@JoinTable(
			name = "game_platforms",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "platform_id", referencedColumnName = "platformId") }
			)
	@JsonManagedReference
	private Set<Platform> platforms;
	
	@ManyToMany
	@JoinTable(
			name = "game_format",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "format_id", referencedColumnName = "formatId") }
			)
	private Set<Format> formats;
	
	@ManyToMany
	@JoinTable(
			name = "game_retailer",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "retailer_id", referencedColumnName = "retailerId") }
			)
	private Set<Retailer> retailers;
	
	@ManyToMany
	@JoinTable(
			name = "game_multiplayer",
			joinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") },
			inverseJoinColumns = { @JoinColumn(name = "multiplayer_id", referencedColumnName = "multiplayerId") }
			)
	private Set<Multiplayer> players;
	
	

}
