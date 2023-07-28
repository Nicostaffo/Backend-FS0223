package com.epicode.introSpring.classes;

public class Franchise {
private String nome;
private double prezzo;

public Franchise(String nome, double prezzo) {
	super();
	this.setNome(nome);
	this.setPrezzo(prezzo);
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
@Override
public String toString() {
	return "Franchise [nome=" + nome + ", prezzo=" + prezzo + "]";
}
}
