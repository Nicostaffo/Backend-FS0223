package com.epicode.introSpring.classes;

public class Bevande {
	private String nome;
	private double prezzo;
	private int kcal;
	public Bevande(String nome, double prezzo, int kcal) {
		super();
		this.setNome(nome);
		this.setPrezzo(prezzo);
		this.setKcal(kcal);
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Bevande [nome=" + nome + ", prezzo=" + prezzo + ", kcal=" + kcal + "]";
	}
	
}
