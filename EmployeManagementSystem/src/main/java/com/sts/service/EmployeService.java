package com.sts.service;

import java.util.List;
import com.sts.model.Employe;


public interface EmployeService {
	
	List <Employe> getAllEmploye();
	void addEmploye(Employe employe);
	Employe updateEmployeByID(long id);
	void deleteEmployeId(long id);
}
