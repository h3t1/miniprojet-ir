package com.iddl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iddl.beans.Client;
import com.iddl.dao.ClientRepository;
import com.iddl.exceptions.ClientNotFoundException;
@Service
@Transactional
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public Client createClient(Client c) {
		return clientRepository.save(c);
	}
	@Override
	public Client updateClient(Client c) {
		Optional<Client> client = getClientById(c.getId());
		if(client.isPresent()) {
			Client cUpdate = client.get();
			cUpdate.setId(c.getId());
			cUpdate.setNom(c.getNom());
			cUpdate.setPrenom(c.getPrenom());
			cUpdate.setAdresse(c.getAdresse());
			cUpdate.setTel(c.getTel());
			cUpdate.setEmail(c.getEmail());
			return clientRepository.save(cUpdate);
		}else
			throw new ClientNotFoundException("Client not found!");
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> getClientById(Long idC) {
		return clientRepository.findById(idC);
	}

	@Override
	public void deleteClient(Long idC) {
		Optional<Client> client = getClientById(idC);
		if(client.isPresent()) {
			clientRepository.delete(client.get());
		}	
	}

}
