package com.neu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.pojo.Profile;



public class ProfileValidator implements Validator{
	
	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(Profile.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
	}

}
