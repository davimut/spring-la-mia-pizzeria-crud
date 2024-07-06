package it.davimut.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.davimut.pizzeria.repository.PizzaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@Controller
@RequestMapping("/pizzeria")
public class PizzaController {

	@Autowired
	private PizzaRepository pizzaRepo;
	
   @GetMapping("/menu")
   public String pizze (Model model) {
	 model.addAttribute("pizze", pizzaRepo.findAll());
     return "pizzeria/index";
}
   @GetMapping("/dettaglio/{id}")
   public String dettaglioPizza (@PathVariable("id") Integer id, Model model) {
	 model.addAttribute("dettaglio", pizzaRepo.getReferenceById(id));
     return "pizzeria/dettaglio";
}
}


