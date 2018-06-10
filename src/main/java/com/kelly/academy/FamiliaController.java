package com.kelly.academy;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelly.academy.model.Familia;
import com.kelly.academy.service.FamiliaService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FamiliaController {
	
	private FamiliaService familiaService;
	
	@Autowired(required=true)
	@Qualifier(value="familiaService")
	public void setFamiliaService(FamiliaService ps) {
		this.familiaService = ps;
	}
	
	@RequestMapping(value="/familia", method = RequestMethod.GET)
	public String listProfesores(Model model) {
		model.addAttribute("familia", new Familia());
		model.addAttribute("listFamilias", this.familiaService.listFamilias());
		return "familia";
	}
	
	@RequestMapping(value= "/familia/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("familia") Familia p){
		
		
		if(p.getId() == 0){
			//new person, add it
			this.familiaService.addFamilia(p);
		}
		else{
			//existing person, call update
		this.familiaService.updateFamilia(p);
		}
		
		return "redirect:/familia";
		
	}
	
	@RequestMapping("/familia/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.familiaService.removeFamilia(id);
        return "redirect:/familia";
    }
 
    @RequestMapping("/familia/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("familia", this.familiaService.getFamiliaById(id));
        model.addAttribute("listFamilias", this.familiaService.listFamilias());
        return "familia";
    }
	
}
