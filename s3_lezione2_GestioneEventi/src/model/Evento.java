package model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Evento {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false)
   private String titolo;
   @Column(nullable = false)
   private LocalDate dataEvento;
   @Column(nullable = false)
   private String descrizione;

   @Enumerated(EnumType.STRING)
   private TipoEvento tipoEvento;

   private int numeroMassimoPartecipanti;

public String getDescrizione() {
	return descrizione;
}

public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}

public LocalDate getDataEvento() {
	return dataEvento;
}

public void setDataEvento(LocalDate dataEvento) {
	this.dataEvento = dataEvento;
}

public String getTitolo() {
	return titolo;
}

public int getNumeroMassimoPartecipanti() {
	return numeroMassimoPartecipanti;
}

public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
	this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
}

@Override
public String toString() {
	return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
			+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
}
public Evento() {
}

public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
   this.titolo = titolo;
   this.dataEvento = dataEvento;
   this.descrizione = descrizione;
   this.tipoEvento = tipoEvento;
   this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
}

public TipoEvento getTipoEvento() {
	return tipoEvento;
}

public void setTipoEvento(TipoEvento tipoEvento) {
	this.tipoEvento = tipoEvento;
}

public Long getId() {
	return id;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

}