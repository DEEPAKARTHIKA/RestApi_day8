package com.skcet.day8.service;

import java.util.List;


import com.skcet.day8.model.Bike;

public interface ApiService {

	boolean addValues(Bike bike);
	
	 List<Bike> getQueryByYear(int year);
    List<Bike> getQueryByYearAndBikeName(int year,String bikeName);
    List<Bike> getQueryByBikeName(String bikeName);
    

}
