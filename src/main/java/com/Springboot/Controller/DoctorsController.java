package com.Springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Entity.DoctorsEntity;
import com.Springboot.Service.DoctorsService;

@RestController
public class DoctorsController {
	

	    @Autowired
	    private DoctorsService service;
	    
	    @PostMapping("/Doctor")
	    public String addDoctor(@RequestBody DoctorsEntity Doctor) {
	        return service.addDoctor(Doctor);}

	    @PutMapping("/Doctor/{id}/{salary}")
	    public DoctorsEntity updDoctor(@PathVariable int salary, @PathVariable int id, @RequestBody DoctorsEntity Doctor) {
	        return service.updateDoctor(Doctor, salary);
	    }

	    @GetMapping("/Doctor")
	    public List<DoctorsEntity> getAllDoctor(){
	        return service.getDoctor();
	    }
	    
	    @ExceptionHandler(value = com.Springboot.Exception.DoctorsExist.class)
		public ResponseEntity<String> DocExist(
				com.Springboot.Exception.DoctorsExist ExistExp) {
			return new ResponseEntity<String>("Doctor already exists!", HttpStatus.CONFLICT);

	    }
	}