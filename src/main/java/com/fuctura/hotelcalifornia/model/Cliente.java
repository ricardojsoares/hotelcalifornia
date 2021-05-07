package com.fuctura.hotelcalifornia.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cliente {

	@Id
	private String cpf;
	private String nome;
	private int    idade;
	private String fone;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="matricula", referencedColumnName = "matricula")
	private Hotel  hotel;
}
