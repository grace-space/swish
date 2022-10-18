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

	// changing these to be unidirectional 
//	@ManyToMany(mappedBy = "games")
//	private Set<Wishlist> wishlists;
	
	@ManyToMany(mappedBy = "games")
	private Set<Library> libraries;
	
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

	// manually added getters/setters & constructors earlier to try to troubleshoot something, but lombok is working better
//	public Game() {}
//	
//	public Game(long gameId, String title, double rating, double msrp, String imgUrl) {
//		super();
//		this.gameId = gameId;
//		this.title = title;
//		this.rating = rating;
//		this.msrp = msrp;
//		this.imgUrl = imgUrl;
//	}
//
//	public long getGameId() {
//		return gameId;
//	}
//
//	public void setGameId(long gameId) {
//		this.gameId = gameId;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public double getRating() {
//		return rating;
//	}
//
//	public void setRating(double rating) {
//		this.rating = rating;
//	}
//
//	public double getMsrp() {
//		return msrp;
//	}
//
//	public void setMsrp(double msrp) {
//		this.msrp = msrp;
//	}
//
//	public String getImgUrl() {
//		return imgUrl;
//	}
//
//	public void setImgUrl(String imgUrl) {
//		this.imgUrl = imgUrl;
//	}
//
//	public Set<Wishlist> getWishlists() {
//		return wishlists;
//	}
//
//	public void setWishlists(Set<Wishlist> wishlists) {
//		this.wishlists = wishlists;
//	}
//
//	public Set<Library> getLibraries() {
//		return libraries;
//	}
//
//	public void setLibraries(Set<Library> libraries) {
//		this.libraries = libraries;
//	}
//
//	public Set<Genre> getGenres() {
//		return genres;
//	}
//
//	public void setGenres(Set<Genre> genres) {
//		this.genres = genres;
//	}
//
//	public Set<Platform> getPlatforms() {
//		return platforms;
//	}
//
//	public void setPlatforms(Set<Platform> platforms) {
//		this.platforms = platforms;
//	}
//
//	public Set<Format> getFormats() {
//		return formats;
//	}
//
//	public void setFormats(Set<Format> formats) {
//		this.formats = formats;
//	}
//
//	public Set<Retailer> getRetailers() {
//		return retailers;
//	}
//
//	public void setRetailers(Set<Retailer> retailers) {
//		this.retailers = retailers;
//	}
//
//	public Set<Multiplayer> getPlayers() {
//		return players;
//	}
//
//	public void setPlayers(Set<Multiplayer> players) {
//		this.players = players;
//	}
	
	

}
