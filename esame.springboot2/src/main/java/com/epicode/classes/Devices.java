package com.epicode.classes;

import com.epicode.enums.DevicesEnum;
import com.epicode.enums.StatoEnum;

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
    private String Id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private DevicesEnum deviceEnum;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatoEnum statoEnum;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;
}

