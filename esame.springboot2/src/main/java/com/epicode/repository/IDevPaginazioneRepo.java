package com.epicode.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.epicode.classes.Devices;

public interface IDevPaginazioneRepo {

	Page<Devices> findAll(Pageable page);

}
