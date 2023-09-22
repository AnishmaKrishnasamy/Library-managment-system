package com.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Passenger;
import com.repository.Passenger_Repository;

import jakarta.servlet.http.HttpServletResponse;


@Service
public class Passenger_Service {
	
	@Autowired
	Passenger_Repository passengerRepo;
	
	
	

	
	public String storePassenger(Passenger passenger) {
		boolean res = passengerRepo.existsById(passenger.getpEmail());
		System.out.println(res);
		if(res) {
			return "Passenger details didn't store...\nYou have already Registered...";
		}
		else {
			passengerRepo.save(passenger);
			return "Passenger("+ passenger.getpName() +") Registered successfully...";
		}
	}	
	
	


	public String login(Passenger passenger) {
		String email = passenger.getpEmail();
		String password = passenger.getpPassword();
		
		Optional<Passenger> op = passengerRepo.findById(passenger.getpEmail());
		System.out.println("**************************"+op);
		
		if(op.isPresent()) {
			Passenger p = op.get();
			
			if(p.getpPassword().equals(passenger.getpPassword())) {
				return "WELCOME";
			} else {
				return "Password may be worng";
			}
		} else {
			return "Email or Password may be worng";
		}
	}



			public void generateBookingReceipt(int bookingId, HttpServletResponse response) throws IOException {
		        
				

		            
		            

		            
		            response.setContentType("application/pdf");
		            response.setHeader("Content-Disposition", "inline; filename=booking_receipt.pdf");

		            		            
		        }
		    }


			

// =======================================================================================================
// =======================================================================================================
			


