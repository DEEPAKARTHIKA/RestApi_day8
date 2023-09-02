package com.skcet.day8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skcet.day8.model.Bike;
import com.skcet.day8.service.ApiService;

@RestController
@RequestMapping("api/v1/bike")
public class ApiController {
       @Autowired
       private ApiService apiservice;
       @PostMapping("/add")
       public ResponseEntity<String> addValues(@RequestBody Bike bike)
       {
     	  boolean dataSaved=apiservice.addValues(bike);
     	  if(dataSaved)
     	  {
     		  return ResponseEntity.status(200).body("added successfully");
     	  }
     	  else
     	  {
     		  return ResponseEntity.status(404).body("not added successfully");
     	  }
       }
       
       
       @GetMapping("/getQueryByYear/{year}")
       public ResponseEntity<List<Bike>> getQueryByYear(@PathVariable int year)
       {
     	  return ResponseEntity.status(200).body(apiservice.getQueryByYear(year));
       }
       
       @GetMapping("/getQueryByYearAndBikeName/{year}/{bikeName}")
       public ResponseEntity<List<Bike>> getQueryByOwners(@PathVariable int year,@PathVariable String  bikeName)
       {
     	  return ResponseEntity.status(200).body(apiservice.getQueryByYearAndBikeName(year,bikeName));
       }
       
       @GetMapping("/getQueryByBikeName/{bikeName}")
       public ResponseEntity<List<Bike>> getQueryByAddress(@PathVariable String bikeName)
       {
     	  return ResponseEntity.status(200).body(apiservice.getQueryByBikeName(bikeName));
       }
       
      
       
}
