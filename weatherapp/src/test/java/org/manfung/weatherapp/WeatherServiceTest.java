package org.manfung.weatherapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.manfung.weatherapp.models.WeatherData;
import org.manfung.weatherapp.repositories.WeatherDataRepository;
import org.manfung.weatherapp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @BeforeEach
    public void setUp() {
        // Clear the database before each test
        weatherDataRepository.deleteAll();

        // Add some initial data for testing
        WeatherData weather1 = new WeatherData();
        weather1.setLocationName("New York");  // Use setLocationName()
        weather1.setTemperature("15°C");
        weather1.setDescription("Sunny");

        WeatherData weather2 = new WeatherData();
        weather2.setLocationName("London");  // Use setLocationName()
        weather2.setTemperature("10°C");
        weather2.setDescription("Cloudy");

        weatherDataRepository.save(weather1);
        weatherDataRepository.save(weather2);
    }

    @Test
    public void testGetWeatherData() {
        WeatherData weatherData = weatherService.getWeatherData("New York");
        assertNotNull(weatherData);
        assertEquals("New York", weatherData.getLocationName());  // Use getLocationName()
        assertEquals("15°C", weatherData.getTemperature());
        assertEquals("Sunny", weatherData.getDescription());
    }

    @Test
    public void testCreateWeatherData() {
        WeatherData newWeather = new WeatherData();
        newWeather.setLocationName("Tokyo");  // Use setLocationName()
        newWeather.setTemperature("20°C");
        newWeather.setDescription("Windy");

        WeatherData savedWeather = weatherService.createWeatherData(newWeather);
        assertNotNull(savedWeather);
        assertEquals("Tokyo", savedWeather.getLocationName());  // Use getLocationName()
        assertEquals("20°C", savedWeather.getTemperature());
    }

    @Test
    public void testUpdateWeatherData() {
        WeatherData updateDetails = new WeatherData();
        updateDetails.setTemperature("12°C");
        updateDetails.setDescription("Partly Cloudy");

        WeatherData updatedWeather = weatherService.updateWeatherData("London", updateDetails);

        assertNotNull(updatedWeather);
        assertEquals("12°C", updatedWeather.getTemperature());
        assertEquals("Partly Cloudy", updatedWeather.getDescription());
    }

    @Test
    public void testDeleteWeatherData() {
        weatherService.deleteWeatherData("New York");
        WeatherData deletedWeather = weatherDataRepository.findByCity("New York");
        assertNull(deletedWeather);
    }
}


