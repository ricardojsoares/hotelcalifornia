package com.fuctura.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hotel {

	@Id
	private long   matricula;
	private String nome; 
	private float  valorDiaria;
	private String cidade;
	private float  estrelas;
}
