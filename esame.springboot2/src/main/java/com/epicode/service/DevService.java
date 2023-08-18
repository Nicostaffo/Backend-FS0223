package com.epicode.service;


import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.epicode.classes.Devices;
import com.epicode.classes.Laptop;
import com.epicode.classes.Smartphone;
import com.epicode.classes.Tablet;
import com.epicode.classes.User;
import com.epicode.enums.DevicesEnum;
import com.epicode.enums.StatoEnum;
import com.epicode.repository.IDevPaginazioneRepo;
import com.epicode.repository.IDevRepository;
import com.epicode.repository.IUserRepo;
import com.epicode.springboot2.security.exception.MyAPIException;

@Service
public class DevService {
@Autowired IUserRepo userRepo;
@Autowired UserService userSvc;
@Autowired IDevPaginazioneRepo pagRepo;
@Autowired IDevRepository devRepo;

@Autowired @Qualifier("smartphBean") private ObjectProvider<Smartphone> smartphoneProvider;
@Autowired @Qualifier("tabletBean") private ObjectProvider<Laptop> laptopProvider;
@Autowired @Qualifier("laptopBean") private ObjectProvider<Tablet> tabletProvider;

public Devices newDevice(DevicesEnum devicesEnum, StatoEnum statoEnum, String model, String product) {
	switch(devicesEnum) {
case SMARTPHONE:
//	Smartphone smartphone = smartphoneProvider.getObject().builder()
//     	.devicesEnum(DevicesEnum.SMARTPHONE)
//		.statoEnum(StatoEnum)
//		.model(model)
//		.product(product)
//		.build();
	Smartphone smartphone = smartphoneProvider.getObject();
	smartphone.setDeviceEnum(DevicesEnum.SMARTPHONE);
	smartphone.setStatoEnum(statoEnum);
	smartphone.setModel(model);
	smartphone.setProduct(product);
	
	devRepo.save(smartphone);
	System.out.println("Smartphone salvato con successo: " + smartphone.toString());
	return smartphone;
case TABLET:
//	Tablet tablet = smartphoneProvider.getObject().builder()
//     	.devicesEnum(DevicesEnum.SMARTPHONE)
//		.statoEnum(StatoEnum)
//		.model(model)
//		.product(product)
//		.build();
//	Tablet tablet = tabletProvider.getObject();
//	tablet.setDeviceEnum(DevicesEnum.TABLET);
//	tablet.setStatoEnum(statoEnum);
//	tablet.setModel(model);
//	tablet.setProduct(product);
	
//	devRepo.save(tablet);
//	System.out.println("Tablet succesfully saved: " + tablet.toString());
//	return tablet;
case LAPTOP:
//	Laptop s = smartphoneProvider.getObject().builder()
//     	.devicesEnum(DevicesEnum.LAPTOP)
//		.statoEnum(StatoEnum)
//		.model(model)
//		.product(product)
//		.build();
//	Laptop laptop = laptopProvider.getObject();
//	laptop.setDeviceEnum(DevicesEnum.LAPTOP);
//	laptop.setStatoEnum(statoEnum);
//	laptop.setModel(model);
//	laptop.setProduct(product);
	
//	devRepo.save(laptop);
//	System.out.println("Laptop successfully saved: " + laptop.toString());
//	return laptop;
	default:
		return null;
	}
}
public Devices getById(Long id) {
	if (devRepo.existsById(id)) {
		return devRepo.findById(id).get();			
	}
	else {
		throw new MyAPIException(HttpStatus.BAD_REQUEST, "Dispositivo non trovato");			
	}
}
public Page<Devices> getDevicesPaged(Pageable page){
	return pagRepo.findAll(page);
}

public void deleteById(Long id) {
	if (devRepo.existsById(id)) {
		devRepo.deleteById(id);
	} else {
		throw new MyAPIException(HttpStatus.BAD_REQUEST, "Dispositivo non trovato");
	}
}

public Devices dismissioneDevice(Long id) {
    Devices device = getById(id);

    if (!device.getStatoEnum().equals(StatoEnum.DISMESSO)) {
    	device.setStatoEnum(StatoEnum.DISMESSO);
        device.setUser(null);
        devRepo.save(device);
        System.out.println("Dispositivo è stato dismesso");
        return device;
    } else {
    	throw new MyAPIException(HttpStatus.BAD_REQUEST, "Dispositivo è stato dismesso");
    }
}

public Devices assegnoDevice(Long id, User us) {
//	User u = userSvc.getById(id);
	User u = us;
	Devices d = this.getById(id);
	if(d.getStatoEnum().equals(StatoEnum.DISPONIBILE)) {
		d.setUser(u);
		d.setStatoEnum(StatoEnum.DISPONIBILE);
		
		List<Devices> deviceListUser = u.getDeviceList();
		deviceListUser.add(d);
		u.setDeviceList(deviceListUser);
		
		userRepo.save(u);
		devRepo.save(d);
		System.out.println("Device assigned succesfully!");
		return d;
	} else if(d.getStatoEnum().equals(StatoEnum.ASSEGNATO)) {
		User u1 = d.getUser();

		d.setUser(null);
		d.setStatoEnum(StatoEnum.DISPONIBILE);
		
		List<Devices> deviceListUser = u1.getDeviceList();
		deviceListUser.remove(d);
		u1.setDeviceList(deviceListUser);
		
		userRepo.save(u1);
		devRepo.save(d);
		System.out.println("Dispositivo deassegnato correttamente!");
        d.setStatoEnum(StatoEnum.IN_MANUTENZIONE);
        System.out.println("Dispositivo in manutenzione!");
		return d;
	} else {
		throw new MyAPIException(HttpStatus.BAD_REQUEST, "Device not available :(");
	}
}

public Devices toggleMaintenance(Long id) {
    Devices d = getById(id);

    switch (d.getStatoEnum()) {
        case ASSEGNATO:
        	User u = d.getUser();

			d.setUser(null);
			d.setStatoEnum(StatoEnum.DISPONIBILE);
			
			List<Devices> deviceListUser = u.getDeviceList();
			deviceListUser.remove(d);
			u.setDeviceList(deviceListUser);
			
			userRepo.save(u);
			devRepo.save(d);
			System.out.println("Dispositivo deassegnato correttamente!");
            d.setStatoEnum(StatoEnum.IN_MANUTENZIONE);
            System.out.println("Dispositivo in manutenzione!");
            break;
        case DISPONIBILE:
        case IN_MANUTENZIONE:
            d.setStatoEnum(StatoEnum.IN_MANUTENZIONE);
            System.out.println("Dispositivo in manutenzione!");
            break;
        case DISMESSO:
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Dispositivo dismesso");
        default:
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Stato dispositivo sconosciuto");
    }

    return d;
}

}
