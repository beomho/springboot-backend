package com.app.grocery.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.grocery.repository.GroceryRepository;
import com.app.grocery.exception.ResourceNotFoundException;
import com.app.grocery.model.Grocery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RestController
@RequestMapping("/api/v1/")
public class GroceryController {

	@Autowired
	private GroceryRepository groceryRepository;

	// get all grocery
	@GetMapping("/grocery")
	public List<Grocery> getAllGrocerys() {
		return groceryRepository.findAll();
	}

	// create grocery rest api
	@PostMapping("/grocery")
	public Grocery createGrocery(@RequestBody Grocery grocery) {
		return groceryRepository.save(grocery);
	}

	// get grocery by id rest api
	@GetMapping("/grocery/{id}")
	public ResponseEntity<Grocery> getGroceryById(@PathVariable String id) {
		Grocery grocery = groceryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grocery not exist with id :" + id));
		return ResponseEntity.ok(grocery);
	}

	// update grocery rest api

	@PutMapping("/grocery/{id}")
	public ResponseEntity<Grocery> updateGrocery(@PathVariable String id, @RequestBody Grocery groceryDetails) {
		Grocery grocery = groceryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grocery not exist with id :" + id));

		// grocery.setFirstName(groceryDetails.getFirstName());
		// grocery.setLastName(groceryDetails.getLastName());
		// grocery.setEmailId(groceryDetails.getEmailId());

		Grocery updatedGrocery = groceryRepository.save(grocery);
		return ResponseEntity.ok(updatedGrocery);
	}

	// delete grocery rest api
	@DeleteMapping("/grocery/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteGrocery(@PathVariable String id) {
		Grocery grocery = groceryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Grocery not exist with id :" + id));

		groceryRepository.delete(grocery);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
