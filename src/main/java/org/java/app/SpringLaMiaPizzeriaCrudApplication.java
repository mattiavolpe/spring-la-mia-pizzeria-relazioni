package org.java.app;

import java.time.LocalDate;
import java.util.List;

import org.java.app.db.pojo.Deal;
import org.java.app.db.pojo.Pizza;
import org.java.app.db.service.DealService;
import org.java.app.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private DealService dealService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pizza pizza1 = new Pizza("Margherita", "Tomato sauce and mozzarella", "https://images.pexels.com/photos/6605214/pexels-photo-6605214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 650);
		
		Pizza pizza2 = new Pizza("Tuna and onion", "Natural tuna, red onions and mozzarella", "https://www.galbani.it/sites/default/files/styles/width_1920/public/se_tonno_buona_da_star_bene_980x357.jpg", 900);
		
		Pizza pizza3 = new Pizza("Capricious", "Tomato sauce, artichokes, mushrooms, anchovies, black olives, baked ham and mozzarella", "https://www.pizza.it/wp-content/uploads/import/body/1/8/9/4/pizza_capricciosa_-_by_pizza.it_.jpg", 900);
		
		pizzaService.savePizza(pizza1);
		pizzaService.savePizza(pizza2);
		pizzaService.savePizza(pizza3);
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		for(Pizza pizza : pizzas) {
			System.out.println(pizza);
		}
		
		Deal deal1 = new Deal(LocalDate.now(), LocalDate.parse("2023-12-31"), "Deal 1", pizza2);
		
		Deal deal2 = new Deal(LocalDate.now(), LocalDate.parse("2023-11-12"), "Deal 2", pizza1);
		
		dealService.saveDeal(deal1);
		dealService.saveDeal(deal2);
	}
}
