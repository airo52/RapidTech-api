package com.example.tripSearch.repository.trip;

import com.example.tripSearch.model.Trip;
import com.example.tripSearch.model.TripSubset;

import java.util.List;

public interface TripInterface {
    List<Trip> getAllTrips();
    Trip getTripById(Long tripId);

    List<TripSubset> searchTrips(String keyword, boolean includeCanceled, int distanceRange, int timeRange);
}
