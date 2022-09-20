package com.Springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Entity.DoctorsEntity;
import com.Springboot.Exception.DoctorsExist;

@Service
public class Doctorsimplementation implements DoctorsService{
		
		@Autowired
		private com.Springboot.Repository.DoctorsRepository DoctorsRepository;
		
		@Override
		public String addDoctor(DoctorsEntity Doctor) {
			DoctorsEntity clearDocData = DoctorsRepository.findByName(Doctor.getName());
			if (clearDocData == null)
			{
				DoctorsRepository.save(Doctor);
				return "New Doctor Added to the Database";}
			else 
				throw new DoctorsExist ("Doctor Data Already Existed in the Database");
		}

		@Override
		public DoctorsEntity updateDoctor(DoctorsEntity Doctor, int id)
		{
			java.util.Optional<DoctorsEntity> ed = DoctorsRepository.findById(id);
			DoctorsEntity eda = ed.get();
			eda.setName(Doctor.getName());
			eda.setSalary(Doctor.getSalary());
			eda.setSpecialist(Doctor.getSpecialist());
			DoctorsRepository.save(eda);
			return eda;}
		
		@Override
		public List<DoctorsEntity> getDoctor(){
			return DoctorsRepository.findAllBySalary();}

		@Override
		public String addDoctors(DoctorsEntity Doctor) throws DoctorsExist {
			// TODO Auto-generated method stub
			return null;
		}

		
	}

