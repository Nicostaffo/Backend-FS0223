package com.epicode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.classes.Laptop;
import com.epicode.classes.Smartphone;
import com.epicode.classes.Tablet;

@Configuration
public class DevicesConfiguration {

	@Bean("tabletBean")
	@Scope("prototype")
	public Tablet tablet() {
		return new Tablet();
	}
	@Bean("smartphBean")
	@Scope("prototype")
	public Smartphone Smartphone() {
		return new Smartphone();
	}
	@Bean("laptopBean")
	@Scope("prototype")
	public Laptop laptop() {
		return new Laptop();
	}
	
}
