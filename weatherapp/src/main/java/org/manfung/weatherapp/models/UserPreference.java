package org.manfung.weatherapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location; // Associate with Location

    private String unit; // Temperature unit (Celsius or Fahrenheit)

    // Getters and Setters

}
