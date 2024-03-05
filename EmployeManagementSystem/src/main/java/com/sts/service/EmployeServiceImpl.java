package com.sts.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.model.Employe;
import com.sts.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements EmployeService{
	
	@Autowired
	private EmployeRepository employeRepo;
	
	@Override
	public List<Employe> getAllEmploye() {
		return employeRepo.findAll();
	}

	@Override
	public void addEmploye(Employe employe) {
		 this.employeRepo.save(employe);
		
	}

	@Override
	public Employe updateEmployeByID(long id) {
		Optional <Employe> optional = employeRepo.findById(id);
		Employe employe = null;
		if(optional.isPresent()) {
			employe = optional.get();
		}else {
			throw new RuntimeException("Employe not found for id ::" + id);
		}
		return employe;
	}

	@Override
	public void deleteEmployeId(long id) {
		this.employeRepo.deleteById(id);
		
	}
	

}
