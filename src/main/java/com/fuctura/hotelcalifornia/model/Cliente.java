/*
 * Autor: Ricardo Soares
 * Data: 07/05/2021
 */

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

//Realiza a criação dos contrutores padrão
@AllArgsConstructor

//Cria o construtor sem argumentos
@NoArgsConstructor

//Cria os métodos gets e sets, assim como o equals, toString, hashCode, etc...
@Data

//Define a classe como uma entidade do banco de dados
@Entity
public class Cliente {

	@Id
	//CPF do cliente
	private String cpf;
	
	//Nome do cliente
	private String nome;
	
	//Idade do cliente
	private int    idade;
	
	//Número do telefone do cliente
	private String fone;
	
	//E-mail do cliente
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="matricula", referencedColumnName = "matricula")
	//Objeto que referencia o hotel do cliente pela matrícula.
	private Hotel  hotel;
}
