package com.epicode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epicode.classes.Devices;
import com.epicode.enums.DevicesEnum;
import com.epicode.enums.StatoEnum;

public interface IDevRepository extends CrudRepository<Devices, Long>{

	Optional<Devices> findById(Long id);
	Optional<Devices> findByStato(StatoEnum deviceEnum);
    Optional<Devices> findByDevice(DevicesEnum devicesEnum);
    List<Devices> findAllByStato (StatoEnum statoEnum);
    List<Devices> findAllByDevice (DevicesEnum devicesEnum);
	boolean existsById(Long id);

	void deleteById(Long id);

}
