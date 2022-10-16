package com.grace.swish.model;

import java.io.Serializable;

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
	private long wishId;
	
	// i need to fix up my relationships still... 
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "gameId")
	private Game game;
	
	
	

}
