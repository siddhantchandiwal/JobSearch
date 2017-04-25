package com.neu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "educationLevel" , "error.invalid.educationLevel","Education Level Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "major" , "error.invalid.major", "Major required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gpa" , "error.invalid.gpa", "GPA cannot be left blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startYear" , "error.invalid.startYear", "Start Year cannot be left blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expYearOfGraduation" , "error.invalid.expYearOfGraduation","Graduation year cannot be kept blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "universityName" , "error.invalid.universityName","University Name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "universityAddress" , "error.invalid.universityAddress","Address cannot be left blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName" , "error.invalid.companyName","Company Name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyType" , "error.invalid.companyType","Company Type required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle" , "error.invalid.jobTitle","Job Title required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annualStartPay" , "error.invalid.annualStartPay", "Start Pay cannot be left blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annualEndPay" , "error.invalid.annualEndPay","End pay cannot be left blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyCity" , "error.invalid.companyCity","City required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyState" , "error.invalid.companyState","State required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyCountry" , "error.invalid.companyCountry","Country required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyZipCode" , "error.invalid.companyZipCode","Zip code required");
		
		
		
	}

}
