package com.elearning.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    private String BuildingNumber;
    private String streetName;
    private String streetAddress;
    private String city;
    private String country;
    private String zipcode;


}
