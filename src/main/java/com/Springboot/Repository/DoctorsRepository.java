package com.Springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Springboot.Entity.DoctorsEntity;



public interface DoctorsRepository extends JpaRepository<DoctorsEntity, Integer>{

	public DoctorsEntity findByName(String name);
	
	@Query(value = "select id, name, salary, specialist from doctor order by salary desc, name asc", nativeQuery=true)
	public List<DoctorsEntity> findAllBySalary();

}

