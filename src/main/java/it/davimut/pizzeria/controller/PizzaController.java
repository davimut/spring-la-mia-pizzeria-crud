package it.davimut.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import it.davimut.pizzeria.model.PizzaModel;
import it.davimut.pizzeria.repository.PizzaRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
   public String store(
		   @Valid @ModelAttribute ("pizza") PizzaModel pizza,
		   BindingResult bindingResult ) {
	   if (pizza.getPrice() <= 0) {
		   bindingResult.addError(new ObjectError("Errore di prezzo",
				   "il prezzo della pizza è obbligatorio"));
		   return "/pizzeria/create";
	   }
	   
       pizzaRepo.save(pizza);
       
       return "redirect:/pizzeria/menu";
   }
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("pizza", pizzaRepo.getReferenceById(id));
		
		return "/pizzeria/edit";
	}
	
	
	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute("pizza") PizzaModel pizza,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/pizzeria/edit";
		}
		
		pizzaRepo.save(pizza);
		
		return "redirect:/pizzeria/menu";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		pizzaRepo.deleteById(id);
		
		return "redirect:/pizzeria/menu";
	}
}


