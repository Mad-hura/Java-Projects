package com.doctorapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.doctorapp.dao.DoctorDaoImpl;
import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService{
	
	IDoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public void addDoctor(Doctor doctor) {
		// call the method of DoctorDao
		doctorDao.addDoctor(doctor);
		
	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		int result = doctorDao.updateDoctor(doctorId, fees);
		if(result == 0)
			throw new ArithmeticException();
		return result;
	}

	@Override
	public Doctor getById(int doctorId) {
		Doctor doctor = doctorDao.findById(doctorId);
		if(doctor == null) 
			return null;
		return doctor;
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorDao.deleteDoctor(doctorId);
		
	}

	@Override
	public List<Doctor> getAllDoctor() {
		List<Doctor> doctorList = doctorDao.findAllDoctor();
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		List<Doctor> doctors = doctorDao.findBySpeciality(speciality);
		if(doctors.isEmpty())
			throw new DoctorNotFoundException("doctor with speciality not found");
		return doctors.stream()
				.sorted((d1,d2)->d1.getDoctorName().compareTo(d2.getDoctorName()))
				.collect(Collectors.toList());
		
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		List<Doctor> doctors = doctorDao.findBySpecialityAndExp(speciality,experience);
		if(doctors.isEmpty())
			throw new DoctorNotFoundException("doctor with speciality and experinece not found");
		return doctors.stream()
				.sorted((d1,d2)->d1.getDoctorName().compareTo(d2.getDoctorName()))
				.collect(Collectors.toList());
		
	}

	@Override
	public List<Doctor> getBySpecialityandFees(String speciality, double fees) throws DoctorNotFoundException {
		List<Doctor> doctors = doctorDao.findBySpecialityandFees(speciality, fees);
		if(doctors.isEmpty())
			throw new DoctorNotFoundException("doctor with speciality and fees not found");
		return doctors.stream()
				.sorted((d1,d2)->d1.getDoctorName().compareTo(d2.getDoctorName()))
				.collect(Collectors.toList());	}

}
