package com.stackroute.Distributorservice.service;
import java.util.List;

import com.stackroute.Distributorservice.exceptions.DistributorAlreadyExistsException;
import com.stackroute.Distributorservice.exceptions.DistributorNotFoundException;
import com.stackroute.Distributorservice.model.*;

public interface DistributorService {
	Distributor createDistributor(Distributor distributor)throws DistributorAlreadyExistsException;
	//boolean deleteDistributor(String distributorId)throws DistributorNotFoundException;
	//public Distributor getDistributorById(String DistributorId) throws DistributorNotFoundException;
	//public List<Movies> getAllMoviesByDistributorLocation(String DistributorLocation);
	//Distributor updateDistributor(String distributorId, Distributor distributor) throws DistributorNotFoundException;
	Distributor distributorLocation(String location) throws DistributorNotFoundException;
	

}
