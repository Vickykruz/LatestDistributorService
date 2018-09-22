package com.stackroute.Distributorservice.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.Distributorservice.exceptions.DistributorAlreadyExistsException;
import com.stackroute.Distributorservice.exceptions.DistributorNotFoundException;
import com.stackroute.Distributorservice.model.Distributor;
import com.stackroute.Distributorservice.model.Movies;
import com.stackroute.Distributorservice.repository.DistributorRepository;

@Service
public class DistributorServiceImpl implements DistributorService {
	
	DistributorRepository distributorRepository;
	
@Autowired
public DistributorServiceImpl(DistributorRepository distributorRepository) {
	this.distributorRepository=distributorRepository;
}

public Distributor createDistributor(Distributor distributor)throws DistributorAlreadyExistsException{

	Distributor ds=distributorRepository.insert(distributor);
	if(ds==null)
	{
		throw new DistributorAlreadyExistsException("already");
	}
	return ds;
}

public Distributor distributorLocation(String location) throws DistributorNotFoundException
{
	Distributor dis=distributorRepository.getBydistributorLocation(location);
	if(dis==null)
	{
		throw new DistributorNotFoundException("not found");
	}
	return dis;
}

/*	Distributor savedDistributor=null;
	if(distributorRepository.existsById(distributor.getDistributorId())) {
		throw new DistributorAlreadyExistsException("Distributor with ID" +distributor.getDistributorId()+"Already Exists");
	}
	else {
		savedDistributor = distributorRepository.insert(distributor);
	
	if(savedDistributor==null) {
		throw new DistributorAlreadyExistsException("Distributor with ID"+distributor.getDistributorId()+"Already Exists");
	}
}
	return savedDistributor;*/


/*@Override
public Distributor updateDistributor(String distributorId , Distributor distributor)throws DistributorNotFoundException{
	try {
		Distributor fetchDistributor = distributorRepository.findById(distributorId).get();
		fetchDistributor.setDistributorName(distributor.getDistributorId());
		fetchDistributor.setDistributorId(distributor.getDistributorId());
		fetchDistributor.setDistributorLocation(distributor.getDistributorLocation());
		
		distributorRepository.save(fetchDistributor);
		return fetchDistributor;
	}
	catch(NoSuchElementException exception) {
		throw new DistributorNotFoundException("Distributor does not exists");
		
	}
}

@Override
public boolean deleteDistributor(String distributorId)throws DistributorNotFoundException{
	boolean status = false;
	try {
		Distributor fetchDistributor = distributorRepository.findById(distributorId).get();
		if(fetchDistributor != null) {
			distributorRepository.delete(fetchDistributor);
			status = true;
		}
	}
	catch(NoSuchElementException exception) {
		throw new DistributorNotFoundException("Distributor does not exists");
		
	}
	return status;
}
	@Override
	public Distributor getDistributorById(String distributorId)throws DistributorNotFoundException{
		Distributor fetchDistributor =distributorRepository.findById(distributorId).get();
		if(fetchDistributor == null) {
			throw new DistributorNotFoundException("User Does Not Exists");
			
		}
		return fetchDistributor;
	}
	@Override
	public List<Movies> getAllMoviesByDistributorLocation(String distributorLocation) {
	      List<Movies> movie = distributorRepository.findByDistributorLocation(distributorLocation);

	       return movie;
	   }
	
	*/
	}