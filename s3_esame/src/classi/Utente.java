package classi;

import java.time.LocalDate;

public class Utente {
String Nome;
String Cognome;
LocalDate DataNascita;
int NumeroTessera;

public Utente(String nome, String cognome, LocalDate dataNascita, int numeroTessera) {
	super();
	Nome = nome;
	Cognome = cognome;
	DataNascita = dataNascita;
	NumeroTessera = numeroTessera;
 }
}
