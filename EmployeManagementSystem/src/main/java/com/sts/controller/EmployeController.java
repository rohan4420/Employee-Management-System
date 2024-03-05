package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.model.Employe;
import com.sts.service.EmployeService;

@Controller
public class EmployeController {
	
	@Autowired
	EmployeService employeService;

	//	display list of all employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listofemploye",employeService.getAllEmploye());
		return "index";
	}
//	Add employe
	@GetMapping("/addNewEmploye")
	public String addEmploye(Model model) {
		Employe employe = new Employe();
		//	create model attribute to bind data
		model.addAttribute("employe",employe);
		return "addEmploye";
	}
	@PostMapping("/saveEmploye")
	public String saveEmploye(@ModelAttribute("employe") Employe employe) {
		//save employe to databse
		employeService.addEmploye(employe);
		return "redirect:/";
	}
//	update employe
	@GetMapping("/updateNewEmploye/{id}")
	public String updateEmploye(@PathVariable (value = "id") long id,Model model) {
		//get employe form service
		Employe employe = employeService.updateEmployeByID(id);
		model.addAttribute("employe",employe);
		return "upadateEmploye";
	}
   //delete employe	
	@GetMapping("/deleteEmploye/{id}")
	public String deleteEmploye(@PathVariable (value = "id") long id) {
		employeService.deleteEmployeId(id);
		return "redirect:/";
	}
	
}
