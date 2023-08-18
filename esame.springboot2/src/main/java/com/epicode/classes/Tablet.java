package com.epicode.classes;

import com.epicode.enums.DevicesEnum;
import com.epicode.enums.StatoEnum;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tablet extends Devices {
	public Tablet(DevicesEnum deviceEnum, StatoEnum statoEnum, String model, String product) {
		super(deviceEnum, statoEnum, model, product);
		
	}
}
