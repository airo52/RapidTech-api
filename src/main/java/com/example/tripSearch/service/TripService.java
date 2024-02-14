package com.example.tripSearch.service;

import com.example.tripSearch.model.Trip;
import com.example.tripSearch.model.TripSubset;
import com.example.tripSearch.repository.trip.TripInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripInterface tripInterface;


    public List<Trip> getAllTrips(){
        return tripInterface.getAllTrips();
    }
    public Trip getTripById(Long tripId){
        return tripInterface.getTripById(tripId);
    }

    public  List<TripSubset> searchTrip(String keyword, boolean includeCanceled, int distanceRange, int timeRange){
        return tripInterface.searchTrips(keyword,includeCanceled,distanceRange,timeRange);
    }

}
