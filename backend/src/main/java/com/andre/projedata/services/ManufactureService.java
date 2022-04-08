package com.andre.projedata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.projedata.dto.ManufactureDTO;
import com.andre.projedata.entities.Manufacture;
import com.andre.projedata.repositories.ManufactureReposity;

@Service
public class ManufactureService {
	
	@Autowired
	private ManufactureReposity reposity;

	public ManufactureDTO saveProduct(ManufactureDTO dto) {
		Manufacture manufacture = new Manufacture(); 
//		manufacture.setId(null);
//		manufacture.setProduct(dto.getProduct());
//		manufacture.setAmountFeedstocks(dto.getAmountFeedstocks());
		manufacture = reposity.save(manufacture);
		return new ManufactureDTO(manufacture);
		
	}
	
}
