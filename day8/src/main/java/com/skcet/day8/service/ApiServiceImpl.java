package com.skcet.day8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.day8.model.Bike;
import com.skcet.day8.repository.BikeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApiServiceImpl implements ApiService {
    @Autowired
    private BikeRepo bikeRepo;
    
    @Override
	public boolean addValues(Bike bike) {
		// TODO Auto-generated method stub
		boolean dataExist=bikeRepo.existsByBikeId(bike.getBikeId());
		if(!dataExist)
		{
			bikeRepo.save(bike);
			return true;
		}
		else
		return false;
	}

	@Override
	public List<Bike> getQueryByYear(int year) {
		// TODO Auto-generated method stub
		return bikeRepo.findByYear(year) ;
	}

	@Override
	public List<Bike> getQueryByYearAndBikeName(int year, String bikeName) {
		// TODO Auto-generated method stub
		return bikeRepo.findByYearAndBikeName(year, bikeName);
	}

	@Override
	public List<Bike> getQueryByBikeName(String bikeName) {
		// TODO Auto-generated method stub
		return bikeRepo.findByBikeName(bikeName);
	}
}
