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

import com.fuctura.hotelcalifornia.model.Hotel;
import com.fuctura.hotelcalifornia.repository.HotelRepository;

//Classe responsável por disponibilizar os serviços de CRUD da classe Hotel.
@RestController
@RequestMapping({"/hotelcalifornia/hotel"})
public class HotelController {

	@Autowired
	HotelRepository repository;
	
	//Classe responsável por retornar um número aleatório para gravar a matrícula do hotel.
	Random random = new Random();
	
	@GetMapping
	//Método responsável por retornar todos os hoteis cadastrados.
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(value = "{matricula}")
	//Método responsável por pegar um objeto do tipo hotel pela matricula.
	public ResponseEntity findById(@PathVariable long matricula) {
		return repository.findById(matricula).map(record -> ResponseEntity.ok().body(record))
							.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	//Método responsável por inserir registros de hotel no banco de dados.
	public Hotel create(@RequestBody Hotel hotel) {
		long matricula = 0;
		
		while (matricula < 1) {
			matricula = random.nextInt();
		}
		
		hotel.setMatricula(matricula);
		return repository.save(hotel);
	}
	
	@DeleteMapping(path = {"{matricula}"})
	//Método responsável por remover um objeto do tipo hotel pela matricula do banco de dados.
	public ResponseEntity delete(@PathVariable long matricula) {
		return repository.findById(matricula)
				.map(record -> {
						repository.deleteById(matricula);
						return ResponseEntity.ok().body("Hotel excluído com sucesso!");
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "{matricula}")
	//Método responsável por realizar alteração no objeto hotel no banco de dados.
	public ResponseEntity update(@PathVariable long matricula, @RequestBody Hotel hotel) {
		return repository.findById(matricula)
				.map(record -> {
					record.setCidade(hotel.getCidade());
					record.setNome(hotel.getNome());
					record.setValorDiaria(hotel.getValorDiaria());
					record.setEstrelas(hotel.getEstrelas());
					Hotel hotelAux = repository.save(record);
					return ResponseEntity.ok().body(hotelAux);
				}).orElse(ResponseEntity.notFound().build());
	}
}
