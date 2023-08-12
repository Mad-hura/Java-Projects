package com.doctorapp.service;

import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
	void addDoctor(Doctor doctor);
	
	int updateDoctor(int doctorId,double fees);
	Doctor getById(int doctorId);
	void deleteDoctor(int doctorId);
	List<Doctor> getAllDoctor();
	
	List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndExp(String speciality,int experience) throws DoctorNotFoundException;
	List<Doctor> getBySpecialityandFees(String speciality,double fees) throws DoctorNotFoundException;
	
	

}
