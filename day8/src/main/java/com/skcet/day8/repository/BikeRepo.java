package com.skcet.day8.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skcet.day8.model.Bike;



public interface BikeRepo extends JpaRepository<Bike,Integer>{
   boolean existsByBikeId(int bikeId);
   
   @Query(value = "select * from Bike where year=:y",nativeQuery = true)
   List<Bike>findByYear(@Param("y") int year);
   
   @Query(value = "select * from Bike where year=:y or bikeName=:s",nativeQuery = true)
   List<Bike> findByYearAndBikeName(@Param("y") int year,@Param("s") String bikeName);
   
   @Query(value = "select * from Bike where year=:y or bikeName=:s",nativeQuery = true)
   List<Bike> findByBikeName(@Param("s") String bikeName);
	
}
