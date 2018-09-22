package com.stackroute.Distributorservice.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.Distributorservice.model.*;

@Repository
public interface DistributorRepository extends MongoRepository<Distributor, String> {

	Distributor getBydistributorLocation(String location);
	
}


