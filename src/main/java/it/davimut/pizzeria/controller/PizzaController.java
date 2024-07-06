package it.davimut.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.davimut.pizzeria.model.PizzaModel;
import it.davimut.pizzeria.repository.PizzaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;







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
   @GetMapping("/create")
   public String create(Model model) {
	   model.addAttribute("pizza",new PizzaModel());
       return "/pizzeria/create";
   }
   
   @PostMapping("/create")
   public String postMethodName(@RequestBody String entity) {
       //TODO: process POST request
       
       return entity;
   }
   
   
}


