package org.java.app.controller;

import org.java.app.db.pojo.Deal;
import org.java.app.db.pojo.Pizza;
import org.java.app.db.service.DealService;
import org.java.app.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class DealController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DealService dealService;
	
	@GetMapping("/{id}/new-deal")
	public String create(@PathVariable int id, Model model) {
		model.addAttribute("deal", new Deal());
		model.addAttribute("pizza", pizzaService.findById(id));
		
		return "create-update-deal";
	}
	
	@PostMapping("/{pizza_id}/new-deal")
	public String store(@PathVariable("pizza_id") int id, @Valid @ModelAttribute Deal deal, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("pizza", pizzaService.findById(id));
			
			return "create-update-deal";
		}
		
		deal.setPizza(pizzaService.findById(id));
		
		dealService.saveDeal(deal);
		
		return "redirect:/" + id;
	}
	
	@GetMapping("/deals/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Deal deal = dealService.findById(id);
		model.addAttribute("deal", deal);
		model.addAttribute("pizza", pizzaService.findById(deal.getPizza().getId()));
		
		return "create-update-deal";
	}
	
	@PostMapping("/deals/edit/{id}")
	public String update(@PathVariable int id, @Valid @ModelAttribute Deal deal, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("pizza", pizzaService.findById(id));
			
			return "create-update-deal";
		}
		
		Deal originalDeal = dealService.findById(id);
		Pizza pizza = originalDeal.getPizza();
		
		deal.setPizza(pizza);
		
		dealService.saveDeal(deal);
		
		return "redirect:/" + pizza.getId();
	}
	
	@PostMapping("/deals/delete/{id}")
	public String delete(@PathVariable int id) {
		int pizzaId = dealService.findById(id).getPizza().getId();
		
		dealService.deleteById(id);
		
		return "redirect:/" + pizzaId;
	}
}
