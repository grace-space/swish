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
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gameId;
	
	private String title;
	
	private double rating;
	
	private double msrp;
	
	private String imgUrl;
	
	@ManyToMany(mappedBy = "game")
	private Set<Wishlist> wishlists;
	
	@ManyToMany(mappedBy = "game")
	private Set<Library> libraries;
	
	@ManyToMany
	@JoinColumn(name = "genreId")
	private Set<Genre> genres;
	
	@ManyToMany
	@JoinColumn(name = "platformId")
	private Set<Platform> platforms;
	
	@ManyToMany
	@JoinColumn(name = "formatId")
	private Set<Format> formats;
	
	@ManyToMany
	@JoinColumn(name = "retailerId")
	private Set<Retailer> retailers;
	
	@ManyToMany
	@JoinColumn(name = "multiplayerId")
	private Set<Multiplayer> multiplayerTypes;
	

}
