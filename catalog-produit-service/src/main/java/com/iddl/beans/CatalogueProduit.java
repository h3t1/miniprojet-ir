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
public class CatalogueProduit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ref;
	private String nom;
	private String designation;
	private int qte;
	private double prix;
}
