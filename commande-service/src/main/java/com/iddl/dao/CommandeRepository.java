package com.iddl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iddl.beans.Commande;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
