package com.example.tripSearch.api;
import com.example.tripSearch.model.Trip;
import com.example.tripSearch.model.TripSubset;
import com.example.tripSearch.repository.trip.TripInterface;
import com.example.tripSearch.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/trip")
public class TripController {
   private final TripService tripService;
   public TripController (TripService tripService){
       this.tripService = tripService;
   }
    @GetMapping("/all")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/findById/{tripId}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long tripId){
        Trip trip = tripService.getTripById(tripId);
        if (trip != null) {
            return ResponseEntity.ok(trip);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/searchTrip")
    public ResponseEntity<List<TripSubset>> searchTrips(
            @RequestParam(required = true) String keyword,
            @RequestParam(required = true) int distanceRange,
            @RequestParam(required = true) Integer timeRange,
            @RequestParam(defaultValue = "false") boolean includeCanceled) {
        List<TripSubset> trip = tripService.searchTrip(keyword,includeCanceled,distanceRange,timeRange);
        if (trip != null) {
            return ResponseEntity.ok(trip);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

}
