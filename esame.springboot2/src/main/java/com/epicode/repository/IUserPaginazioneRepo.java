package com.epicode.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.classes.Devices;

public interface IUserPaginazioneRepo extends PagingAndSortingRepository <Devices, Long>{

}
