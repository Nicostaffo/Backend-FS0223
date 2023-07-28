package com.epicode.introSpring.classes;

import java.util.List;
import java.util.Map;

public class Pizze{
	private String nome;
	private double prezzo;
	private int kcal;
	private List<String> toppings;
    private Map<String, List<String>> specialCombinations;
    
	public Pizze(String nome, double prezzo, int kcal, List<String> toppings,
			Map<String, List<String>> specialCombinations) {
		super();
		this.setNome(nome);
		this.setPrezzo(prezzo);
		this.setKcal(kcal);
		this.setToppings(toppings);
		this.setSpecialCombinations(specialCombinations);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	public Map<String, List<String>> getSpecialCombinations() {
		return specialCombinations;
	}

	public void setSpecialCombinations(Map<String, List<String>> specialCombinations) {
		this.specialCombinations = specialCombinations;
	}

	@Override
	public String toString() {
		return "Pizze [nome=" + nome + ", prezzo=" + prezzo + ", kcal=" + kcal + ", toppings=" + toppings
				+ ", specialCombinations=" + specialCombinations + "]";
	}
}
