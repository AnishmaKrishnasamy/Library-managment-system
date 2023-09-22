package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Passenger;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.Passenger_Repository;
import com.service.Passenger_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/passenger")		
public class Passenger_Controller {
	
	@Autowired
	Passenger_Repository passengerRepo;
	
	@Autowired
	Passenger_Service passengerService;
	
	


	  
		  @GetMapping("/getAll")
		  public ResponseEntity<List<Passenger>> getAllPassenger() {
		    List<Passenger> passenger = new ArrayList<Passenger>();
		
		    	passengerRepo.findAll().forEach(passenger::add);
			
			    if (passenger.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			
			    return new ResponseEntity<>(passenger, HttpStatus.OK);
		  }
		  
	  
	  


		  @GetMapping("/getPassByEmail/{pEmail}")
		  public ResponseEntity<Passenger> getPassByEmail(@PathVariable("pEmail") String pEmail) {
			  
			  Passenger passenger = passengerRepo.findById(pEmail)
					  .orElseThrow(() -> new ResourceNotFoundException("Not found Passenger with Email = " + pEmail));
		
		    	return new ResponseEntity<>(passenger, HttpStatus.OK);
		  }
		  
	  
	  

//		  
//		  }
		  
		  @PostMapping(value="store", consumes = MediaType.APPLICATION_JSON_VALUE)
		  public String storePassenger(@RequestBody Passenger passenger) {
			  System.out.println(passenger.getpEmail());
			  
			  return passengerService.storePassenger(passenger);
		  }
		  
	  
	  

		  
		  @PutMapping("/update/{pEmail}")
		  public ResponseEntity<Passenger> updatePassenger(@PathVariable("pEmail") String pEmail, 
				  										   @RequestBody Passenger passReq) {
			  
			  Passenger _passenger = passengerRepo.findById(pEmail)
					  .orElseThrow(() -> new ResourceNotFoundException("Not found Passenger with Email = " + pEmail));
		
			    _passenger.setpAddress(passReq.getpAddress());
			    _passenger.setpName(passReq.getpName());
			    _passenger.setpPassword(passReq.getpPassword());
			    _passenger.setpPhone(passReq.getpPhone());
			    _passenger.setpRole(passReq.getpRole());
			    _passenger.setUrl(passReq.getUrl());
			//  _passenger.setBooking(passReq.getBooking());  // Don't do this bcoz it will store null at the time of Update. 
			    
		    return new ResponseEntity<>(passengerRepo.save(_passenger), HttpStatus.OK);
		  }
		  
		  
	  

		  
		  @DeleteMapping("/delete/{pEmail}")
		  public ResponseEntity<ApiResponse> deletePassenger(@PathVariable("pEmail") String pEmail) {
			  
			  Passenger pass_email = passengerRepo.findById(pEmail)
				        .orElseThrow(() -> new ResourceNotFoundException("Not found Passenger with Email = " + pEmail));
			  
			  passengerRepo.deleteById(pEmail);
		    
		    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  return new ResponseEntity<ApiResponse>(new ApiResponse("Passenger details deleted Successfully", true), HttpStatus.OK);
		  }
		  
		  
	  

		  @DeleteMapping("/deleteAll")
		  public ResponseEntity<HttpStatus> deleteAllPassenger() {
			  
			  passengerRepo.deleteAll();
		    
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	  
		  
		  

		  
			@PostMapping(value = "login")
			public String login(@RequestBody Passenger passenger) {
				
				System.out.println("Controller: "+passenger.getpEmail());
				//Thread.sleep(3000);
				return passengerService.login(passenger);
			}
		  
	  

			
			@GetMapping("/booking/receipt")
		    public void generateReceipt(@RequestParam int bookingId, HttpServletResponse response) throws IOException, IOException {
		        passengerService.generateBookingReceipt(bookingId,response);
		    }
			
			
	  

		  
		 
		  
}
