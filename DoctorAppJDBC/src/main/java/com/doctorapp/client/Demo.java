package com.doctorapp.client;

import java.util.List;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class Demo {
	public static void main(String[] args) {
		Doctor doctor = new Doctor("Johnathan","Cardiologist",700,18);
		IDoctorService doctorService=new DoctorServiceImpl();
		doctorService.addDoctor(doctor);
		doctorService.updateDoctor(3, 400);
		//doctorService.deleteDoctor(2);
		System.out.println("All doctors:");
		doctorService.getAllDoctor().forEach(System.out::println);
		System.out.println("Doctors by speciality:");
		doctorService.getBySpeciality("Ortho").forEach(System.out::println);
		System.out.println("Doctors by Id:");
		Doctor doc = doctorService.getById(3);
		System.out.println(doc);
		System.out.println("Doctors by speciality and Exp:");
		List<Doctor> doc1 = doctorService.getBySpecialityAndExp("Ortho",12);
		System.out.println(doc1);
		System.out.println("Doctors by speciality and fees:");
		List<Doctor> doc2 = doctorService.getBySpecialityandFees("Ortho", 3000);
		System.out.println(doc2);
		
		
		
	} 

}
