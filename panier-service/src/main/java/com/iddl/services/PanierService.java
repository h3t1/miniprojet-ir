package com.iddl.services;

import java.util.List;
import java.util.Optional;

import com.iddl.beans.Panier;

public interface PanierService {
	Panier createPanier(Panier c);
	Panier updatePanier(Panier c);
	List<Panier> getAllPaniers();
	Optional<Panier> getPanierById(Long id);
	void deletePanier(Long id);
}
