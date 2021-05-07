/*
 * Autor: Ricardo Soares
 * Data: 07/05/2021
 */

package com.fuctura.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Hotel {

	@Id
	//Matrícula do hotel
	private long   matricula;
	
	//Nome do hotel
	private String nome; 
	
	//Valor da diária do hotel
	private float  valorDiaria;
	
	//Cidade onde o hotel fica
	private String cidade;
	
	//Classificação do hotel em estrelas
	private float  estrelas;
}
