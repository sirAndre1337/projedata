package com.andre.projedata.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andre.projedata.entities.AmountFeedstock;
import com.andre.projedata.services.AmountFeedstockService;

@RestController
@RequestMapping(value = "/afs")
public class AmountFeedstockResource {

	@Autowired
	private AmountFeedstockService service;
	
	@GetMapping
	public ResponseEntity<Page<AmountFeedstock>> findAll(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage , Direction.valueOf(direction) ,orderBy);
		
		Page<AmountFeedstock> list = service.findAllPaged(pageRequest, name.trim());
		
		return ResponseEntity.ok().body(list);
	}
}
