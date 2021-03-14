package com.iddl.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iddl.beans.Panier;
import com.iddl.services.PanierService;

@RestController
public class PanierController {

	@Autowired
	private PanierService panierService;

	@GetMapping("/paniers")
	public ResponseEntity<List<Panier>> getAllPaniers() {
		return ResponseEntity.ok().body(panierService.getAllPaniers());
	}

	@GetMapping("/paniers/{id}")
	public ResponseEntity<Optional<Panier>> getPanierById(@PathVariable long id) {
		return ResponseEntity.ok().body(panierService.getPanierById(id));
	}

	@PostMapping("/paniers")
	public ResponseEntity<Panier> createPanier(@RequestBody Panier panier) {
		return ResponseEntity.ok().body(panierService.createPanier(panier));
	}

	@PutMapping("/paniers/{id}")
	public ResponseEntity<Panier> updatePanier(@PathVariable long id, @RequestBody Panier panier) {
		panier.setId(id);
		return ResponseEntity.ok().body(this.panierService.updatePanier(panier));
	}

	@DeleteMapping("/paniers/{id}")
	public HttpStatus deletePanier(@PathVariable long id) {
		panierService.deletePanier(id);
		return HttpStatus.OK;
	}

}
