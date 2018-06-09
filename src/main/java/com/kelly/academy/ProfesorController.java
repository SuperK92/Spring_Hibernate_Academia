package com.kelly.academy;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelly.academy.model.Profesor;
import com.kelly.academy.service.ProfesorService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProfesorController {
	
	private ProfesorService profesorService;
	
	@Autowired(required=true)
	@Qualifier(value="profesorService")
	public void setProfesorService(ProfesorService ps) {
		this.profesorService = ps;
	}
	
	@RequestMapping(value="/profesor", method = RequestMethod.GET)
	public String listProfesores(Model model) {
		model.addAttribute("profesor", new Profesor());
		model.addAttribute("listProfesores", this.profesorService.listProfesor());
		return "profesor";
	}
	
	@RequestMapping(value= "/profesor/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("profesor") Profesor p){
		
		
		if(p.getId() == 0){
			//new person, add it
			this.profesorService.addProfesor(p);
		}
		else{
			//existing person, call update
		this.profesorService.updateProfesor(p);
		}
		
		return "redirect:/profesor";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.profesorService.removeProfesor(id);
        return "redirect:/profesor";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("profesor", this.profesorService.getProfesorById(id));
        model.addAttribute("listProfesores", this.profesorService.listProfesor());
        return "profesor";
    }
	
}
