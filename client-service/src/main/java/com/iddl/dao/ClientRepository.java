package com.iddl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iddl.beans.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
