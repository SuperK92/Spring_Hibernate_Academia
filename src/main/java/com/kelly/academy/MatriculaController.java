package com.kelly.academy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelly.academy.model.Matricula;
import com.kelly.academy.model.Profesor;
import com.kelly.academy.service.MatriculaService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MatriculaController {
	
	private MatriculaService matriculaService;
	
	@Autowired(required=true)
	@Qualifier(value="matriculaService")
	public void setMatriculaService(MatriculaService cs) {
		this.matriculaService = cs;
	}
	
	@RequestMapping(value="/matricula", method = RequestMethod.GET)
	public String listMatriculas(Model model) {
		model.addAttribute("matricula", new Matricula());
		model.addAttribute("listMatriculas", this.matriculaService.listMatriculas());
		model.addAttribute("profesor", new Profesor());
		model.addAttribute("listaCursos", this.matriculaService.listCursos());
		model.addAttribute("listaAlumnos", this.matriculaService.listAlumnos());
		
		return "matricula";
	}
	
	@RequestMapping(value= "/matricula/add", method = RequestMethod.POST)
	public String addMatricula(@ModelAttribute("matricula") Matricula c){
		
		
		if(c.getId() == 0){
			//new person, add it
			this.matriculaService.addMatricula(c);
		}
		else{
			//existing person, call update
		this.matriculaService.updateMatricula(c);
		}
		
		return "redirect:/matricula";
		
	}
	
	@RequestMapping("/matricula/remove/{id}")
    public String removeMatricula(@PathVariable("id") int id){
		
        this.matriculaService.removeMatricula(id);
        return "redirect:/matricula";
    }
 
    @RequestMapping("/matricula/edit/{id}")
    public String editMatricula(@PathVariable("id") int id, Model model){
        model.addAttribute("matricula", this.matriculaService.getMatriculaById(id));
        model.addAttribute("listMatriculas", this.matriculaService.listMatriculas());
        model.addAttribute("listaCursos", this.matriculaService.listCursos());
		model.addAttribute("listaAlumnos", this.matriculaService.listAlumnos());
        return "matricula";
    }
	
}
