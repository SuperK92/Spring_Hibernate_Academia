package com.kelly.academy;


import java.util.ArrayList;
import java.util.List;

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

import com.kelly.academy.model.Curso;
import com.kelly.academy.model.Profesor;
import com.kelly.academy.service.CursoService;
import com.kelly.academy.service.ProfesorService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CursoController {
	
	private CursoService cursoService;
	
	@Autowired(required=true)
	@Qualifier(value="cursoService")
	public void setCursoService(CursoService cs) {
		this.cursoService = cs;
	}
	
	@RequestMapping(value="/curso", method = RequestMethod.GET)
	public String listCursos(Model model) {
		model.addAttribute("curso", new Curso());
		model.addAttribute("listCursos", this.cursoService.listCursos());
		model.addAttribute("profesor", new Profesor());
		model.addAttribute("listaProfesores", this.cursoService.listaProfesores());
		
		return "curso";
	}
	
	@RequestMapping(value= "/curso/add", method = RequestMethod.POST)
	public String addCurso(@ModelAttribute("curso") Curso c){
		
		
		if(c.getId() == 0){
			//new person, add it
			this.cursoService.addCurso(c);
		}
		else{
			//existing person, call update
		this.cursoService.updateCurso(c);
		}
		
		return "redirect:/curso";
		
	}
	
	@RequestMapping("/curso/remove/{id}")
    public String removeCurso(@PathVariable("id") int id){
		
        this.cursoService.removeCurso(id);
        return "redirect:/curso";
    }
 
    @RequestMapping("/curso/edit/{id}")
    public String editCurso(@PathVariable("id") int id, Model model){
        model.addAttribute("curso", this.cursoService.getCursoById(id));
        model.addAttribute("listCursos", this.cursoService.listCursos());
        model.addAttribute("listaProfesores", this.cursoService.listaProfesores());
        return "curso";
    }
	
}
