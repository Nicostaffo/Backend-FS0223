package com.epicode.introSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.introSpring.classes.Bevande;
import com.epicode.introSpring.classes.Franchise;
import com.epicode.introSpring.classes.Menu;
import com.epicode.introSpring.classes.Pizze;

@SpringBootApplication
public class IntroSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringApplication.class, args);
		@Configuration class ConfigurationTest {
		
			@Bean
			@Scope("singleton")
			public Menu test() {
				try {
					return printMenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return menu;
			}
			
			
		
	  private static Menu menu;
		// TODO Auto-generated method stub
		  public static Menu printMenu() {
		        System.out.println("----- Godfather's Pizza Menu -----");

		        System.out.println("Pizzas:");
		        for (Pizze pizza : menu.getPizzas()) {
		            System.out.println("Name: " + pizza.getNome());
		            System.out.println("Price: " + pizza.getPrezzo());
		            System.out.println("Toppings: " + pizza.getToppings());
		            System.out.println("Special Combinations: " + pizza.getSpecialCombinations());
		            System.out.println("Nutritional Info: " + pizza.getKcal());
		            System.out.println("------------------------");
		        }

		        System.out.println("Drinks:");
		        for (Bevande drinks : menu.getDrinks()) {
		            System.out.println("Name: " + drinks.getNome());
		            System.out.println("Price: " + drinks.getPrezzo());
		            System.out.println("Nutritional Info: " + drinks.getKcal());
		            System.out.println("------------------------");
		        }

		        System.out.println("Oggettistica:");
		        for (Franchise item : menu.getFranchise()) {
		            System.out.println("Name: " + item.getNome());
		            System.out.println("Price: " + item.getPrezzo());
		            System.out.println("------------------------");
		        }
				return menu;
		  }
		  }
		}
	}


