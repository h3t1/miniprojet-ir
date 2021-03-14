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

import com.iddl.beans.CatalogueProduit;
import com.iddl.services.CatalogueProduitService;

@RestController
public class CProduitController {

	@Autowired
	private CatalogueProduitService catalogueProduitService;

	@GetMapping("/cproduits")
	public ResponseEntity<List<CatalogueProduit>> getCProduits() {
		return ResponseEntity.ok().body(catalogueProduitService.getAllCProduits());
	}

	@GetMapping("/cproduits/{id}")
	public ResponseEntity<Optional<CatalogueProduit>> getCProduitById(@PathVariable long id) {
		return ResponseEntity.ok().body(catalogueProduitService.getCProduitById(id));
	}

	@PostMapping("/cproduits")
	public ResponseEntity<CatalogueProduit> createCProduit(@RequestBody CatalogueProduit catalogueProduit) {
		return ResponseEntity.ok().body(catalogueProduitService.createCProduit(catalogueProduit));
	}

	@PutMapping("/cproduits/{id}")
	public ResponseEntity<CatalogueProduit> updateCProduit(@PathVariable long id, @RequestBody CatalogueProduit catalogueProduit) {
		catalogueProduit.setRef(id);
		return ResponseEntity.ok().body(this.catalogueProduitService.updateCProduit(catalogueProduit));
	}

	@DeleteMapping("/cproduits/{id}")
	public HttpStatus deleteCProduit(@PathVariable long id) {
		catalogueProduitService.deleteCProduit(id);
		return HttpStatus.OK;
	}

}
