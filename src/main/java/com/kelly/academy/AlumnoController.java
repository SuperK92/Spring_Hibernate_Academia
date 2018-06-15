package com.kelly.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.kelly.academy.model.Alumno;
import com.kelly.academy.service.AlumnoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AlumnoController {
	
	private AlumnoService alumnoService;
	
	@Autowired(required=true)
	@Qualifier(value="alumnoService")
	public void setAlumnoService(AlumnoService as) {
		this.alumnoService = as;
	}
	
	@RequestMapping(value="/alumno", method = RequestMethod.GET)
	public String listAlumnoes(Model model) {
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("listAlumnos", this.alumnoService.listAlumnos());
		return "alumno";
	}
	
	@RequestMapping(value= "/alumno/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("alumno") Alumno p){
		
		
		if(p.getId() == 0){
			//new person, add it
			this.alumnoService.addAlumno(p);
		}
		else{
			//existing person, call update
		this.alumnoService.updateAlumno(p);
		}
		
		return "redirect:/alumno";
		
	}
	
	@RequestMapping("/alumno/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.alumnoService.removeAlumno(id);
        return "redirect:/alumno";
    }
 
    @RequestMapping("/alumno/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("alumno", this.alumnoService.getAlumnoById(id));
        model.addAttribute("listAlumnos", this.alumnoService.listAlumnos());
        return "alumno";
    }
	
}
