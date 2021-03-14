package com.iddl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iddl.beans.Panier;
import com.iddl.dao.PanierRepository;
import com.iddl.exceptions.PanierNotFoundException;
@Service
@Transactional
public class PanierServiceImpl implements PanierService{
	@Autowired
	private PanierRepository panierRepository;
	@Override
	public Panier createPanier(Panier p) {
		return panierRepository.save(p);
	}
	@Override
	public Panier updatePanier(Panier c) {
		Optional<Panier> panier = getPanierById(c.getId());
		if(panier.isPresent()) {
			Panier pUpdate = panier.get();
			pUpdate.setId(c.getId());
			pUpdate.setRefProduit(c.getRefProduit());
			pUpdate.setClientId(c.getClientId());
			pUpdate.setTotal(c.getTotal());
			return panierRepository.save(pUpdate);
		}else
			throw new PanierNotFoundException("Panier not found!");
	}

	@Override
	public List<Panier> getAllPaniers() {
		return panierRepository.findAll();
	}

	@Override
	public Optional<Panier> getPanierById(Long id) {
		return panierRepository.findById(id);
	}

	@Override
	public void deletePanier(Long id) {
		Optional<Panier> panier = getPanierById(id);
		if(panier.isPresent()) {
			panierRepository.delete(panier.get());
		}	
	}

}
