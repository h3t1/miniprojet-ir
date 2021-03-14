package com.iddl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iddl.beans.Panier;
@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

}
