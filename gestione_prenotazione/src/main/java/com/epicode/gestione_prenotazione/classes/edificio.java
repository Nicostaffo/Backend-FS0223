package com.epicode.gestione_prenotazione.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class edificio {
	@Id
	
private String name;
private String address;
private String city;

}
