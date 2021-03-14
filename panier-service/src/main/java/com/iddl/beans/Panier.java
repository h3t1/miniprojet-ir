package com.iddl.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long clientId;
	private long refProduit;
	private double total;
}
