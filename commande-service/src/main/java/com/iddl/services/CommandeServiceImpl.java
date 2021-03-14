package com.iddl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iddl.beans.Commande;
import com.iddl.dao.CommandeRepository;
import com.iddl.exceptions.CommandeNotFoundException;
@Service
@Transactional
public class CommandeServiceImpl implements CommandeService{
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Override
	public Commande createCommande(Commande c) {
		return commandeRepository.save(c);
	}
	
	@Override
	public Commande updateCommande(Commande c) {
		Optional<Commande> commande = getCommandeById(c.getNumCom());
		if(commande.isPresent()) {
			Commande cUpdate = commande.get();
			cUpdate.setNumCom(c.getNumCom());
			cUpdate.setClientId(c.getClientId());
			cUpdate.setDatecom(c.getDatecom());
			cUpdate.setMontant(c.getMontant());
			return commandeRepository.save(cUpdate);
		}else
			throw new CommandeNotFoundException("Order not found!");
	}

	@Override
	public List<Commande> getAllCommandes() {
		return commandeRepository.findAll();
	}

	@Override
	public Optional<Commande> getCommandeById(Long id) {
		return commandeRepository.findById(id);
	}

	@Override
	public void deleteCommande(Long id) {
		Optional<Commande> commande = getCommandeById(id);
		if(commande.isPresent()) {
			commandeRepository.delete(commande.get());
		}	
	}

}
