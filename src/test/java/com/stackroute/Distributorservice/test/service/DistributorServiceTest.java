package com.stackroute.Distributorservice.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.Distributorservice.exceptions.DistributorAlreadyExistsException;
import com.stackroute.Distributorservice.exceptions.DistributorNotFoundException;
import com.stackroute.Distributorservice.model.Distributor;
import com.stackroute.Distributorservice.model.Movies;
import com.stackroute.Distributorservice.repository.DistributorRepository;
import com.stackroute.Distributorservice.service.DistributorServiceImpl;



public class DistributorServiceTest {

	 @Mock
	 	DistributorRepository distributorRepository;


	 	Distributor distributor;

	    @InjectMocks
	    DistributorServiceImpl distributorService;
/*
	    List<Movies> moviesList = null;
	    Optional<Distributor> options;*/

	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);

	        distributor = new Distributor();
	        distributor.setDistributorId("Vignesh008");
	        distributor.setDistributorName("vignesh");
	        distributor.setDistributorLocation("Chennai");
	        

	    }

	    @Test
	    public void registerDistributorSuccess() throws DistributorAlreadyExistsException {
	        when(distributorRepository.insert((Distributor) any())).thenReturn(distributor);
	        Distributor distributorSaved = distributorService.createDistributor(distributor);
	        assertEquals(distributor, distributorSaved);

	    }

	    @Test(expected = DistributorAlreadyExistsException.class       )
	    public void registerDistributorFailure() throws DistributorAlreadyExistsException {
	        when(distributorRepository.insert((Distributor) any())).thenReturn(null);
	        Distributor distributorSaved = distributorService.createDistributor(distributor);
	        assertEquals(distributor, distributorSaved);

	    }

/*	   @Test
	    public void updateDistributorLocation() throws DistributorNotFoundException {
	        when(distributorRepository.findById(distributor.getDistributorId()));
	        distributor.setDistributorLocation("Chennai");
	        Distributor fetchedDistributor = distributorService.distributorLocation(location)(distributor.getDistributorLocation(), distributor));
	        assertEquals(distributor, fetchedDistributor);

	    }

	  private String location(String distributorLocation, Distributor distributor2) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*  @Test
	    public void deleteDistributorSuccess() throws DistributorNotFoundException {
	        when(distributorRepository.findById(distributor.getDistributorId())).thenReturn(options);
	        boolean flag = distributorService.deleteDistributor(distributor.getDistributorId());
	        assertEquals(true, flag);

	    }*/

 	    @Test
 
	    public void getDistributorByLocation() throws DistributorNotFoundException {

	        when(distributorRepository.findById(distributor.getDistributorLocation()));

	        Distributor fetchedDistributor = distributorService.distributorLocation(distributor.getDistributorLocation());

	        assertEquals(distributor, fetchedDistributor);

	    }


	}
