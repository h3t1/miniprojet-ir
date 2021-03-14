package com.iddl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iddl.beans.CatalogueProduit;
@Repository
public interface CProduitRepository extends JpaRepository<CatalogueProduit, Long> {

}
