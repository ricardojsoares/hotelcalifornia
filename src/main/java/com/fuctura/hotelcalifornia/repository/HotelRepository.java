package com.fuctura.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fuctura.hotelcalifornia.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
