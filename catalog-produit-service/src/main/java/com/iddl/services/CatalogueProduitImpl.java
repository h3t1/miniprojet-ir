package com.iddl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iddl.beans.CatalogueProduit;
import com.iddl.dao.CProduitRepository;
import com.iddl.exceptions.CatalogueProduitNotFoundException;
@Service
@Transactional
public class CatalogueProduitImpl implements CatalogueProduitService{
	@Autowired
	private CProduitRepository clientRepository;
	@Override
	public CatalogueProduit createCProduit(CatalogueProduit cp) {
		return clientRepository.save(cp);
	}
	@Override
	public CatalogueProduit updateCProduit(CatalogueProduit cp) {
		Optional<CatalogueProduit> catalogueProduit = getCProduitById(cp.getRef());
		if(catalogueProduit.isPresent()) {
			CatalogueProduit cUpdate = catalogueProduit.get();
			cUpdate.setRef(cp.getRef());
			cUpdate.setNom(cp.getNom());
			cUpdate.setDesignation(cp.getDesignation());
			cUpdate.setPrix(cp.getPrix());
			cUpdate.setQte(cp.getQte());
			
			return clientRepository.save(cUpdate);
		}else
			throw new CatalogueProduitNotFoundException("Product not found!");
	}

	@Override
	public List<CatalogueProduit> getAllCProduits() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<CatalogueProduit> getCProduitById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public void deleteCProduit(Long id) {
		Optional<CatalogueProduit> catalogueProduit = getCProduitById(id);
		if(catalogueProduit.isPresent()) {
			clientRepository.delete(catalogueProduit.get());
		}	
	}

}
