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

import com.iddl.beans.Commande;
import com.iddl.services.CommandeService;

@RestController
public class CommandeController {

	@Autowired
	private CommandeService commandeService;

	@GetMapping("/commandes")
	public ResponseEntity<List<Commande>> getAllCommandes() {
		return ResponseEntity.ok().body(commandeService.getAllCommandes());
	}

	@GetMapping("/commandes/{id}")
	public ResponseEntity<Optional<Commande>> getCommandeByid(@PathVariable long id) {
		return ResponseEntity.ok().body(commandeService.getCommandeById(id));
	}

	@PostMapping("/commandes")
	public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
		return ResponseEntity.ok().body(commandeService.createCommande(commande));
	}

	@PutMapping("/commandes/{id}")
	public ResponseEntity<Commande> updateCommande(@PathVariable long id, @RequestBody Commande commande) {
		commande.setNumCom(id);
		return ResponseEntity.ok().body(this.commandeService.updateCommande(commande));
	}

	@DeleteMapping("/commandes/{id}")
	public HttpStatus deleteCommande(@PathVariable long id) {
		commandeService.deleteCommande(id);
		return HttpStatus.OK;
	}

}
