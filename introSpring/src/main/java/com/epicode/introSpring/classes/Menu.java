package com.epicode.introSpring.classes;

import java.util.List;

public class Menu {
	    private List<Pizze> pizzas;
	    private List<Bevande> drinks;
	    private List<Franchise> oggettistica;
		public Menu(List<Pizze> pizzas, List<Bevande> drinks, List<Franchise> oggettistica) {
			super();
			this.setPizzas(pizzas);
			this.setDrinks(drinks);
			this.setFranchise(oggettistica);
		}
		public List<Pizze> getPizzas() {
			return pizzas;
		}
		public void setPizzas(List<Pizze> pizzas) {
			this.pizzas = pizzas;
		}
		public List<Bevande> getDrinks() {
			return drinks;
		}
		public void setDrinks(List<Bevande> drinks) {
			this.drinks = drinks;
		}
		public List<Franchise> getFranchise() {
			return oggettistica;
		}
		public void setFranchise(List<Franchise> franchise) {
			this.oggettistica = franchise;
		}
		@Override
		public String toString() {
			return "Menu [pizzas=" + pizzas + ", drinks=" + drinks + ", oggettistica=" + oggettistica + "]";
		}
}
