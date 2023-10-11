package org.java.app.controller;

import org.java.app.db.pojo.Deal;
import org.java.app.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DealController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("{id}/new-deal")
	public String create(@PathVariable int id, Model model) {
		
		model.addAttribute("deal", new Deal());
		model.addAttribute("pizza", pizzaService.findById(id));
		
		return "create-deal";
	}
}
