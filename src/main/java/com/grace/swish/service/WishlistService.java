package com.grace.swish.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grace.swish.model.Wishlist;
import com.grace.swish.repository.WishlistRepository;

import jakarta.transaction.Transactional;
import lombok.*;

@Service
@AllArgsConstructor
public class WishlistService {
	
	@Autowired
	private WishlistRepository wishlistRepository;

	/*
	 * Create wishlist
	 */
	public void createWishlist(Wishlist wishlist) {
		wishlistRepository.save(wishlist);
	}
	
	/*
	 * See wishlist
	 */
	public Set<Wishlist> readWishlist(long userId) {
		return wishlistRepository.findAllByUserUserId(userId);
	}

}
