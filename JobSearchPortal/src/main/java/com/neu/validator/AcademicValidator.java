package com.neu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.pojo.AcademicProfile;



public class AcademicValidator implements Validator{
	
	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(AcademicProfile.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
	}

}
