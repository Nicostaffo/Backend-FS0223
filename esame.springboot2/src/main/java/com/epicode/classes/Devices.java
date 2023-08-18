package com.epicode.classes;

import com.epicode.enums.DevicesEnum;
import com.epicode.enums.StatoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Devices")
public class Devices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private DevicesEnum deviceEnum;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatoEnum statoEnum;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(nullable = false)
	private User user;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private String product;

	public Devices(DevicesEnum deviceEnum, StatoEnum statoEnum) {
		super();
		this.deviceEnum = deviceEnum;
		this.statoEnum = statoEnum;
	}

	public Devices(DevicesEnum deviceEnum, StatoEnum statoEnum, String model, String product) {
		super();
		this.deviceEnum = deviceEnum;
		this.statoEnum = statoEnum;
		this.model = model;
		this.product = product;
	}
	
}

