package com.example.tripSearch.repository.trip;

import com.example.tripSearch.model.Trip;
import com.example.tripSearch.model.TripSubset;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TripImpl implements TripInterface {
    private List<Trip> getRemoteJsonData() {
    String jsonUrl = "https://rapidtechinsights.github.io/hr-assignment/recent.json";
    RestTemplate restTemplate = new RestTemplate();
    String jsonData = restTemplate.getForObject(jsonUrl, String.class);

    try {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonData);
        JsonNode tripsNode = jsonNode.get("trips");
        if (tripsNode != null && tripsNode.isArray()) {
            return objectMapper.readValue(tripsNode.toString(), new TypeReference<List<Trip>>() {});
        } else {
            throw new IllegalArgumentException("No 'trips' array found in the JSON data");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return null;
    }
}

    @Override
    public List<Trip> getAllTrips() {
        return this.getRemoteJsonData();
    }

    @Override
    public Trip getTripById(Long tripId) {
        List<Trip> trips = getRemoteJsonData();
        if (trips != null) {
            return trips.stream()
                    .filter(trip -> Objects.equals(trip.getId(), tripId))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    @Override
    public List<TripSubset> searchTrips(String keyword, boolean includeCanceled, int distanceRange, int timeRange){

        List<Trip> trips = getRemoteJsonData();
        if (trips != null) {
        return trips.stream()
                .filter(trip -> keyword.isEmpty() || containsKeyword(trip, keyword.toLowerCase()))
                .filter(trip -> includeCanceled || !trip.getStatus().equals("CANCELED"))
                .filter(trip -> isWithinDistanceRange(trip, distanceRange))
                .filter(trip -> isWithinTimeRange(trip, timeRange))
                .map(this::mapToTripSubset)
                .collect(Collectors.toList());
        }
        return null;
    }

    private TripSubset mapToTripSubset(Trip trip) {
        return new TripSubset(trip);
    }


        private boolean containsKeyword(Trip trip, String keyword) {
        return trip.getPickupLocation().toLowerCase().contains(keyword) ||
                trip.getDropoffLocation().toLowerCase().contains(keyword) ||
                trip.getDriverName().toLowerCase().contains(keyword) ||
                trip.getType().toLowerCase().contains(keyword) ||
                trip.getCarMake().toLowerCase().contains(keyword) ||
                trip.getCarModel().toLowerCase().contains(keyword) ||
                trip.getCarNumber().toLowerCase().contains(keyword);
        }

        private boolean isWithinDistanceRange(Trip trip, int distanceRange) {
            double distance = calculateDistance(trip);
            return switch (distanceRange) {
                case 1 -> distance <= 3.0;
                case 2 -> distance > 3.0 && distance <= 8.0;
                case 3 -> distance > 8.0 && distance <= 15.0;
                case 4 -> true; // Any distance
                case 5-> distance > 15;
                default -> false;
            };
        }

        private boolean isWithinTimeRange(Trip trip, int timeRange) {
            long duration = calculateDuration(trip);
            return switch (timeRange) {
                case 1 -> duration <= 5;
                case 2 -> duration > 5 && duration <= 10;
                case 3 -> duration > 10 && duration <= 20;
                case 4 -> duration > 20;
                case 5 -> true;
                default -> false;
            };
        }

        private double calculateDistance(Trip trip) {
            String unit = trip.getDistanceUnit();
            double distance = trip.getDistance();
            if(Objects.equals(unit.toLowerCase(), "km")){
                return distance;
            }
            return 0.0;
        }

        private long calculateDuration(Trip trip) {
            return trip.getDuration(); // Placeholder implementation
        }

}
