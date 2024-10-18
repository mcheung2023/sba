package org.manfung.weatherapp.services;

import org.manfung.weatherapp.models.WeatherData;
import org.manfung.weatherapp.repositories.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    // Method to get weather data by city
    public WeatherData getWeatherData(String city) {
        return weatherDataRepository.findByCity(city);
    }

    // Method to create new weather data
    public WeatherData createWeatherData(WeatherData weatherData) {
        return weatherDataRepository.save(weatherData);
    }

    // Method to update weather data by city
    public WeatherData updateWeatherData(String city, WeatherData weatherDetails) {
        WeatherData existingWeatherData = weatherDataRepository.findByCity(city);
        if (existingWeatherData == null) {
            throw new ResourceNotFoundException("Weather data for city: " + city + " not found");
        }
        existingWeatherData.setLocationName(city);  // Use setLocationName() instead of setCity()
        existingWeatherData.setTemperature(weatherDetails.getTemperature());
        existingWeatherData.setDescription(weatherDetails.getDescription());
        return weatherDataRepository.save(existingWeatherData);
    }

    // Method to delete weather data by city
    public void deleteWeatherData(String city) {
        WeatherData weatherData = weatherDataRepository.findByCity(city);
        if (weatherData == null) {
            throw new ResourceNotFoundException("Weather data for city: " + city + " not found");
        }
        weatherDataRepository.delete(weatherData);
    }
}
