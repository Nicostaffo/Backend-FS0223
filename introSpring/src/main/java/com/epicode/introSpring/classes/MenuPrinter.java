package com.epicode.introSpring.classes;

public class MenuPrinter {
    private Menu menu;

    public MenuPrinter(Menu menu) {
        this.menu = menu;
    }

    public void printMenu() {
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
    }
}