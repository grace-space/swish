package com.grace.swish.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table
public class User implements Serializable, UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
    private final Set<GrantedAuthority> authorities = new HashSet<>();


	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	
	@Column(unique = true, length = 16)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany
	@JoinTable(
			name = "user_library",
			joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "userId") },
			inverseJoinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") }
			)
	private Set<Game> library;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany
	@JoinTable(
			name = "user_wishlist",
			joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "userId") },
			inverseJoinColumns = { @JoinColumn(name = "game_id", referencedColumnName = "gameId") }
			)
	private Set<Game> wishlist;
	
	
	public User() {
		authorities.add(new SimpleGrantedAuthority("USER"));
	}
	
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

	
	
	
	
	
	

}
