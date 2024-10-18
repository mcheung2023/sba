package org.manfung.weatherapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<WeatherData> weatherData; // Associate weather data with location


}
