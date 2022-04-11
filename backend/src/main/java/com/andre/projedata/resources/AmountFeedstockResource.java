package com.andre.projedata.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.projedata.dto.AmountFeedStockDTO;
import com.andre.projedata.services.AmountFeedstockService;

@CrossOrigin
@RestController
@RequestMapping(value = "/afs")
public class AmountFeedstockResource {

	@Autowired
	private AmountFeedstockService service;
	
	@GetMapping(value = "/{prodctId}")
	public ResponseEntity<List<AmountFeedStockDTO>> findById(@PathVariable Long prodctId) {
		  List<AmountFeedStockDTO> amountFeedstocks = service.findById(prodctId);
		return ResponseEntity.ok().body(amountFeedstocks);
	}
	
	@PostMapping
	public ResponseEntity<AmountFeedStockDTO> saveAmountFeedstock(@RequestBody AmountFeedStockDTO dto) {
		dto = service.saveAmountFeedstock(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AmountFeedStockDTO> updateAmountFeedstock(@PathVariable Long id, @RequestBody AmountFeedStockDTO dto) {
		dto = service.updateAmountFeedstock(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAmountFeedstock(@PathVariable Long id) {
		service.deleteAmountFeedstock(id);
		return ResponseEntity.noContent().build();
	}
}
