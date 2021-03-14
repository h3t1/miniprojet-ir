package com.iddl.services;

import java.util.List;
import java.util.Optional;

import com.iddl.beans.Client;

public interface ClientService {
	Client createClient(Client c);
	Client updateClient(Client c);
	List<Client> getAllClients();
	Optional<Client> getClientById(Long idC);
	void deleteClient(Long idC);
}
