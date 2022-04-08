package com.andre.projedata.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.projedata.dto.ManufactureDTO;
import com.andre.projedata.dto.ProductDTO;
import com.andre.projedata.services.ManufactureService;

@RestController
@RequestMapping(value = "/manafactures")
public class ManufactureResource {
//	
//	@Autowired
//	private ManufactureService service;
	
//	@PostMapping
//	public ResponseEntity<ManufactureDTO> saveManufacture(@RequestBody  ProductDTO productDTO) {
//		dto = service.saveProduct(dto);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
//		return ResponseEntity.created(uri).body(dto);
//	}
}
