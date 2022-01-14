package org.generation.italy.controller;


import javax.validation.Valid;


import org.generation.italy.model.Pizza;
import org.generation.italy.service.IngredientiService;
import org.generation.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	private PizzaService service;
	@Autowired
	private IngredientiService ingService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("list", service.findAllSortedByRecent());
		return "/pizza/list";
	}
	
	
	@GetMapping("/detail/{id}")//leggiamo una variabile dalla path id
	public String detail(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pizza", service.getById(id));
		return "/pizza/detail";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		model.addAttribute("ingredienteList", service.findAllSortedByRecent());
		return "/pizza/edit";
		
	}
	
	@PostMapping("/create") //ci permette di ricevere i dati
	public String doCreate(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bidingReasult, Model model) {
		
		if(bidingReasult.hasErrors()) {
			model.addAttribute("edit", false);
			model.addAttribute("ingredienteList", ingService.findAllSortByCategory());
			return "/pizza/edit";
		}
		//else salva i dati
		service.save(formPizza); //poi dobbiamo ritornare la lista
		return "redirect:/pizza";
	}
	
	@GetMapping("/edit/{id}")
		public String edit(@PathVariable("id") Integer id, Model model) {
			model.addAttribute("pizza", service.getById(id));
			model.addAttribute("ingredienteList", ingService.findAllSortByCategory());
			return "/pizza/edit";
		}
	
	
}
