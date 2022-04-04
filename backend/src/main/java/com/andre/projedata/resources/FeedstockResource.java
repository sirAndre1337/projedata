package com.andre.projedata.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.projedata.dto.FeedstockDTO;
import com.andre.projedata.services.FeedstockService;

@RestController
@RequestMapping(value = "/feedstocks")
public class FeedstockResource {
	
	@Autowired
	private FeedstockService service;

	@GetMapping
	public ResponseEntity<Page<FeedstockDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage , Direction.valueOf(direction) ,orderBy);
		
		Page<FeedstockDTO> list = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FeedstockDTO> findById(@PathVariable Long id) {
		FeedstockDTO feedstockDTO = service.findById(id);
		return ResponseEntity.ok().body(feedstockDTO);
	}
	
	@PostMapping
	public ResponseEntity<FeedstockDTO> saveFeedstock(@RequestBody FeedstockDTO dto) {
		dto = service.saveFeedstock(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FeedstockDTO> updateFeedstock(@PathVariable Long id, @RequestBody FeedstockDTO dto) {
		dto = service.updateFeedstock(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteFeedstock(@PathVariable Long id) {
		service.deleteFeedstock(id);
		return ResponseEntity.noContent().build();
	}
	
}














