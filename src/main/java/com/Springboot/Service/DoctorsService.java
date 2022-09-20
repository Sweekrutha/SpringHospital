package com.Springboot.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Springboot.Entity.DoctorsEntity;
import com.Springboot.Exception.DoctorsExist;

@Service
public interface DoctorsService {
	
		
		public String addDoctors(DoctorsEntity Doctor) throws DoctorsExist;
		
		public List<DoctorsEntity> getDoctor();
		
		public DoctorsEntity updateDoctor(DoctorsEntity Doctor, int id) ;

		public String addDoctor(DoctorsEntity doctor);
	}

