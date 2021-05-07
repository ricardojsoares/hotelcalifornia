/*
 * Autor: Ricardo Soares
 * Data: 07/05/2021
 */

package com.fuctura.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fuctura.hotelcalifornia.model.Hotel;

//Interface responsável por disponibilizar os métodos para iteragir com o banco de dados
//com as informações da classe Hotel
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
