package org.manfung.weatherapp.controllers;

import org.manfung.weatherapp.models.WeatherData;
import org.manfung.weatherapp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Get weather data by city (already exists)
    @GetMapping("/weather/{city}")
    public WeatherData getWeather(@PathVariable String city) {
        return weatherService.getWeatherData(city);
    }

    // Create new weather data
    @PostMapping("/weather")
    public WeatherData createWeatherData(@RequestBody WeatherData weatherData) {
        return weatherService.createWeatherData(weatherData);
    }

    // Update weather data by city
    @PutMapping("/weather/{city}")
    public WeatherData updateWeatherData(@PathVariable String city, @RequestBody WeatherData weatherDetails) {
        return weatherService.updateWeatherData(city, weatherDetails);
    }

    // Delete weather data by city
    @DeleteMapping("/weather/{city}")
    public void deleteWeatherData(@PathVariable String city) {
        weatherService.deleteWeatherData(city);
    }
}
