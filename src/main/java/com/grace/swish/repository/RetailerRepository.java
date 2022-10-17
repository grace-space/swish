package com.grace.swish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grace.swish.model.Retailer;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long>{
	
	Retailer findByRetailerName(String retailerName);

}
