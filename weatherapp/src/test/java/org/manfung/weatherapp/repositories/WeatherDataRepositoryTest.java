package org.manfung.weatherapp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.manfung.weatherapp.models.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest  // This annotation focuses on JPA components only (like repositories)
@ActiveProfiles("test")  // Use a separate profile for testing
public class WeatherDataRepositoryTest {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @BeforeEach
    public void setUp() {
        // Clear the repository before each test
        weatherDataRepository.deleteAll();

        // Add some initial data for testing
        WeatherData weather1 = new WeatherData();
        weather1.setLocationName("New York");
        weather1.setTemperature("15°C");
        weather1.setDescription("Sunny");

        WeatherData weather2 = new WeatherData();
        weather2.setLocationName("London");
        weather2.setTemperature("10°C");
        weather2.setDescription("Cloudy");

        weatherDataRepository.save(weather1);
        weatherDataRepository.save(weather2);
    }

    @Test
    public void testFindByCity() {
        // Test if we can find weather data by city
        WeatherData weatherData = weatherDataRepository.findByCity("New York");
        assertNotNull(weatherData);
        assertEquals("New York", weatherData.getLocationName());
        assertEquals("15°C", weatherData.getTemperature());
        assertEquals("Sunny", weatherData.getDescription());
    }

    @Test
    public void testSaveWeatherData() {
        // Create new weather data and save it
        WeatherData newWeather = new WeatherData();
        newWeather.setLocationName("Tokyo");
        newWeather.setTemperature("20°C");
        newWeather.setDescription("Windy");

        WeatherData savedWeather = weatherDataRepository.save(newWeather);
        assertNotNull(savedWeather);
        assertEquals("Tokyo", savedWeather.getLocationName());
        assertEquals("20°C", savedWeather.getTemperature());
    }

    @Test
    public void testDeleteWeatherData() {
        // Delete weather data by city
        WeatherData weatherData = weatherDataRepository.findByCity("London");
        assertNotNull(weatherData);  // Ensure it exists before deletion
        weatherDataRepository.delete(weatherData);

        // Check if the data has been deleted
        WeatherData deletedWeather = weatherDataRepository.findByCity("London");
        assertNull(deletedWeather);
    }

    @Test
    public void testFindAllWeatherData() {
        // Test the findAll method
        Iterable<WeatherData> weatherList = weatherDataRepository.findAll();
        assertNotNull(weatherList);
        assertTrue(((List<WeatherData>) weatherList).size() > 0); // Ensure that data exists
    }
}

