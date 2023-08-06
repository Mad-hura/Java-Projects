package com.voterapp.service;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIdException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth{
	
	String[] localities = {"KRpuram","JPnagar","Indiranagar","Hosakote","Hoodi"};

	private boolean checkAge(int age) throws UnderAgeException{
		if(age<18) {
			throw  new UnderAgeException("under age");
			}return true;
	}
	
	private boolean checkLocality(String lo) throws LocalityNotFoundException{
		boolean check=true;
		for(String locality:localities) {
			if(locality.equals(lo)) {
				check=false;
			}
		}
		if(check)
			throw new LocalityNotFoundException("Locality not found");
		return true;
	}
	
	private boolean checkVoterId(int vid) throws NoVoterIdException{
		if(vid<1000 || vid>9999) {
			throw new NoVoterIdException("voter id not found");
		}
		return true;
	}

	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InValidVoterException {
	    try {
	    	if(checkAge(age)&&checkLocality(locality)&&checkVoterId(voterId))
	    		return true;
	    }catch(UnderAgeException e) {
	    	System.out.println(e.getMessage());
	    }catch(LocalityNotFoundException e) {
	    	System.out.println(e.getMessage());
	    }catch(NoVoterIdException e) {
	    	System.out.println(e.getMessage());
	    }
		return false;
	}

}
