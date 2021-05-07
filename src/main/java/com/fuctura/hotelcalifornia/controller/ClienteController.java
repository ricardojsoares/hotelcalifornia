/*
 * Autor: Ricardo Soares
 * Data: 07/05/2021
 */

package com.fuctura.hotelcalifornia.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuctura.hotelcalifornia.model.Cliente;
import com.fuctura.hotelcalifornia.repository.ClienteRepository;

//Classe responsável por disponibilizar os serviços de CRUD da classe Cliente.
@RestController
@RequestMapping({"/hotelcalifornia/cliente"})
public class ClienteController {

	@Autowired
	ClienteRepository repository;
	
	@GetMapping
	//Método responsável por retornar todos os clientes cadastrados.
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(value = "{cpf}")
	//Método responsável por pegar um objeto do tipo cliente pelo CPF.
	public ResponseEntity findById(@PathVariable String cpf) {
		return repository.findById(cpf).map(record -> ResponseEntity.ok().body(record))
							.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	//Método responsável por inserir registros de cliente no banco de dados.
	public Cliente create(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@DeleteMapping(path = {"{cpf}"})
	//Método responsável por remover um objeto do tipo cliente pelo CPF do banco de dados.
	public ResponseEntity delete(@PathVariable String cpf) {
		return repository.findById(cpf)
				.map(record -> {
						repository.deleteById(cpf);
						return ResponseEntity.ok().body("Cliente excluído com sucesso!");
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "{cpf}")
	//Método responsável por realizar alteração no objeto cliente no banco de dados.
	public ResponseEntity update(@PathVariable String cpf, @RequestBody Cliente cliente) {
		return repository.findById(cpf)
				.map(record -> {
					record.setNome(cliente.getNome());
					record.setEmail(cliente.getEmail());
					record.setIdade(cliente.getIdade());
					record.setFone(cliente.getFone());
					Cliente clienteAux = repository.save(record);
					return ResponseEntity.ok().body(clienteAux);
				}).orElse(ResponseEntity.notFound().build());
	}
}