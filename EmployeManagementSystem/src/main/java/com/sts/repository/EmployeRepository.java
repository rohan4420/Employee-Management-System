package com.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.model.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
}
