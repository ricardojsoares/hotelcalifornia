package com.fuctura.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fuctura.hotelcalifornia.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
