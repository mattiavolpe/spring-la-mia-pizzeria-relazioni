package org.java.app.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String index(@RequestParam(required = false) String filter, Model model) {
		List<Pizza> pizzas = filter == null
								? pizzaService.findAll()
								: pizzaService.filterByNameOrDescription(filter, filter);
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("filter", filter);
		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable int id, Model model) {
		Pizza pizza = pizzaService.findById(id);
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		
		return "create-update";
	}
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute Pizza pizza, BindingResult bindingResult, Model model) {
		return storeUpdate(pizza, bindingResult);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("pizza", pizzaService.findById(id));
		
		return "create-update";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute Pizza pizza, BindingResult bindingResult, Model model) {
		return storeUpdate(pizza, bindingResult);
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		pizzaService.deleteById(id);
		
		return "redirect:/";
	}
	
	private String storeUpdate(Pizza pizza, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "create-update";
		}
		
		try {
			pizzaService.savePizza(pizza);			
		} catch (Exception e) {
			return "create-update";
		}
		
		return "redirect:/";
	}
}
