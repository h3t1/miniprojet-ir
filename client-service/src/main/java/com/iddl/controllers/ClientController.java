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

import com.iddl.beans.Client;
import com.iddl.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClients() {
		return ResponseEntity.ok().body(clientService.getAllClients());
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Optional<Client>> getClientbyid(@PathVariable long id) {
		return ResponseEntity.ok().body(clientService.getClientById(id));
	}

	@PostMapping("/clients")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		return ResponseEntity.ok().body(clientService.createClient(client));
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client client) {
		client.setId(id);
		return ResponseEntity.ok().body(this.clientService.updateClient(client));
	}

	@DeleteMapping("/clients/{id}")
	public HttpStatus deleteClient(@PathVariable long id) {
		clientService.deleteClient(id);
		return HttpStatus.OK;
	}

}
