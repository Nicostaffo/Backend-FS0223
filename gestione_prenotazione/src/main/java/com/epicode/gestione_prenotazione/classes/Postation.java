package com.epicode.gestione_prenotazione.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Postation {
	@Id
private String codice;
private String description;
private type type;
private int occupant;
private edificio edificio;
}
