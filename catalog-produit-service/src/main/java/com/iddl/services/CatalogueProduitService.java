package com.iddl.services;

import java.util.List;
import java.util.Optional;

import com.iddl.beans.CatalogueProduit;

public interface CatalogueProduitService {
	CatalogueProduit createCProduit(CatalogueProduit cp);
	CatalogueProduit updateCProduit(CatalogueProduit cp);
	List<CatalogueProduit> getAllCProduits();
	Optional<CatalogueProduit> getCProduitById(Long id);
	void deleteCProduit(Long id);
}
