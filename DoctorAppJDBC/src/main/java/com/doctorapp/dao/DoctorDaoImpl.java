package com.doctorapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConnection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {

	@Override
	public void addDoctor(Doctor doctor) {
    try(Connection connection = DbConnection.openConnection();
    		PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);){
    	     statement.setString(1, doctor.getDoctorName());
    	     statement.setInt(3,doctor.getExperience());
    	     statement.setDouble(4,doctor.getFees());
    	     statement.setString(2,doctor.getSpeciality());
    	     statement.execute();		
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		Connection connection;
		PreparedStatement preparedStatement=null;
		int result = 0;
		 try {
				connection = DbConnection.openConnection();
	            preparedStatement = connection.prepareStatement(Queries.UPDATEQUERY); 
	            preparedStatement.setDouble(1, fees);
	            preparedStatement.setInt(2, doctorId);
	            result = preparedStatement.executeUpdate();
	            System.out.println(result);
	        }catch(SQLException e) {
	        	e.printStackTrace();
	        }finally {
	        	DbConnection.closeConnection();
	        	try {
	        		if(preparedStatement != null)
	        			preparedStatement.close();
	        	}catch(SQLException e) {
	        		e.printStackTrace();
	        	}
	        }
	  return result;
	}

	@Override
	public Doctor findById(int doctorId) {
		Doctor doctor = new Doctor();
        try { Connection connection = DbConnection.openConnection();

                PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYID); 

            statement.setInt(1, doctorId);

           ResultSet result = statement.executeQuery();
           while (result.next()) {
     	   String name = result.getString("doctorName");
     	   int docId = result.getInt("doctorId");
     	   String speciality = result.getString("speciality");
     	   double fees = result.getDouble("fees");
     	   int experience = result.getInt("experience");
     	   doctor.setDoctorId(doctorId);
     	   doctor.setDoctorName(name);
     	   doctor.setExperience(experience);
     	   doctor.setFees(fees);
     	   doctor.setSpeciality(speciality);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		try(Connection connection = DbConnection.openConnection();
	    		PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);){
			    statement.setInt(1, doctorId);
			    statement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Doctor> findAllDoctor() {
		List<Doctor> doctors = new ArrayList<Doctor>();
        try (Connection connection = DbConnection.openConnection();
           PreparedStatement statement = connection.prepareStatement(Queries.QUERYALL);) {
        	ResultSet result = statement.executeQuery();
               while (result.next()) {
            	   Doctor doctor = new Doctor();
            	   String name = result.getString("doctorName");
            	   int doctorId = result.getInt("doctorId");
            	   String speciality = result.getString("speciality");
            	   double fees = result.getDouble("fees");
            	   int experience = result.getInt("experience");
            	   doctor.setDoctorId(doctorId);
            	   doctor.setDoctorName(name);
            	   doctor.setExperience(experience);
            	   doctor.setFees(fees);
            	   doctor.setSpeciality(speciality);
            	   doctors.add(doctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
		
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) throws DoctorNotFoundException {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement;
		List<Doctor> doctorList = new ArrayList<>();
		ResultSet result=null;
		try {
			statement=connection.prepareStatement(Queries.QUERYBYSPECIALITY);
			statement.setString(1, speciality);
			result=statement.executeQuery();
			while(result.next()) {
				Doctor doctor = new Doctor();
				                String name = result.getString("doctorName");
				                int doctorId = result.getInt("doctorId");
				                String spec = result.getString("speciality");
				                double fees = result.getDouble("fees");
				                int experience = result.getInt("experience");
				                doctor.setDoctorId(doctorId);
				                doctor.setDoctorName(name);
				                doctor.setExperience(experience);
				                doctor.setFees(fees);
				                doctor.setSpeciality(speciality);
				                doctorList.add(doctor);
				
			}
			}catch(SQLException e) {
				e.printStackTrace();}
		return doctorList;
		
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement;
		List<Doctor> doctorList = new ArrayList<>();
		ResultSet result=null;
		try {
			statement=connection.prepareStatement("select * from doctor where speciality =? and experience=? ");
			statement.setString(1, speciality);
			statement.setInt(2, experience);
			result=statement.executeQuery();
			while(result.next()) {
				Doctor doctor = new Doctor();
                String name = result.getString("doctorName");
                int doctorId = result.getInt("doctorId");
                String spec = result.getString("speciality");
                double fees = result.getDouble("fees");
                int experience1 = result.getInt("experience");
                doctor.setDoctorId(doctorId);
                doctor.setDoctorName(name);
                doctor.setExperience(experience);
                doctor.setFees(fees);
                doctor.setSpeciality(speciality);
                doctorList.add(doctor);
				
			}
			}catch(SQLException e) {
				e.printStackTrace();}
		return doctorList;
		
	}

	@Override
	public List<Doctor> findBySpecialityandFees(String speciality, double fees) throws DoctorNotFoundException {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement;
		List<Doctor> doctorList = new ArrayList<>();
		ResultSet result=null;
		try {
			statement=connection.prepareStatement("select * from doctor where speciality =? and fees=? ");
			statement.setString(1, speciality);
			statement.setDouble(2, fees);
			result=statement.executeQuery();
			while(result.next()) {
				Doctor doctor = new Doctor();
                String name = result.getString("doctorName");
                int doctorId = result.getInt("doctorId");
                String spec = result.getString("speciality");
                double fees1 = result.getDouble("fees");
                int experience = result.getInt("experience");
                doctor.setDoctorId(doctorId);
                doctor.setDoctorName(name);
                doctor.setExperience(experience);
                doctor.setFees(fees);
                doctor.setSpeciality(speciality);
                doctorList.add(doctor);

				
			}
			}catch(SQLException e) {
				e.printStackTrace();}
		return doctorList;
		
	}

}
