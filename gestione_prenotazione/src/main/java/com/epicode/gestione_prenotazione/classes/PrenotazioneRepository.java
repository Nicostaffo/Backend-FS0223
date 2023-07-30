package com.epicode.gestione_prenotazione.classes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{

	static List<Prenotazione> findByPostazione(Postation postazione) {
		// TODO Auto-generated method stub
		return null;
	}

}
