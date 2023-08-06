package com.userapp.service;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public interface IValidationService {
	boolean validateUsername(String username)throws NameExistsException;
	boolean validatePassword(String password)throws TooLongException,TooShortException;
	}

