package classi;

import java.time.LocalDate;

public class Prestiti {
private Utente utente;
private CatalogoBiblio elementoPrestato;
private LocalDate dataInizioPrestito;
private LocalDate dataRestituzionePrevista;
private LocalDate dataRestituzioneEffettiva;

public Prestiti(Utente utente, CatalogoBiblio elementoPrestato, LocalDate dataInizioPrestito,
		LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
	super();
	this.setUtente(utente);
	this.setElementoPrestato(elementoPrestato);
	this.setDataInizioPrestito(dataInizioPrestito);
	this.setDataRestituzionePrevista(dataRestituzionePrevista);
	this.setDataRestituzioneEffettiva(dataRestituzioneEffettiva);
}
public Utente getUtente() {
	return utente;
}
public void setUtente(Utente utente) {
	this.utente = utente;
}
public CatalogoBiblio getElementoPrestato() {
	return elementoPrestato;
}
public void setElementoPrestato(CatalogoBiblio elementoPrestato) {
	this.elementoPrestato = elementoPrestato;
}
public LocalDate getDataInizioPrestito() {
	return dataInizioPrestito;
}
public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
	this.dataInizioPrestito = dataInizioPrestito;
}
public LocalDate getDataRestituzionePrevista() {
	return dataRestituzionePrevista;
}
public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
	this.dataRestituzionePrevista = dataRestituzionePrevista;
}
public LocalDate getDataRestituzioneEffettiva() {
	return dataRestituzioneEffettiva;
}
public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
	this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
}
@Override
public String toString() {
	return "Prestiti [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", dataInizioPrestito="
			+ dataInizioPrestito + ", dataRestituzionePrevista=" + dataRestituzionePrevista
			+ ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
}
}
