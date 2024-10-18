package org.manfung.weatherapp.services;

import org.manfung.weatherapp.models.Location;
import org.manfung.weatherapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to handle business logic for Location entities.
 * This class provides methods to retrieve location data.
 */
@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Create a new location
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    // Update an existing location
    public Location updateLocation(Long id, Location locationDetails) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found"));
        location.setCity(locationDetails.getCity());
        location.setCountry(locationDetails.getCountry());
        return locationRepository.save(location);
    }

    // Delete a location
    public void deleteLocation(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found"));
        locationRepository.delete(location);
    }
}