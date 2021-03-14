package com.iddl.services;

import java.util.List;
import java.util.Optional;

import com.iddl.beans.Commande;

public interface CommandeService {
	Commande createCommande(Commande c);
	Commande updateCommande(Commande c);
	List<Commande> getAllCommandes();
	Optional<Commande> getCommandeById(Long id);
	void deleteCommande(Long id);
}
