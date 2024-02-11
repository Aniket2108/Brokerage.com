package com.brokerage.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "property_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "property_id")
    private Long id;

    @Column(length = 10,name = "property_type")
    private String propertyType;

    @Column(name = "number_of_bedrooms")
    private int bedroom;

    @Column(name = "number_of_bathrooms")
    private int bathroom;

    @Column(name = "surface_area")
    private int surface;

    @Column(name = "rent_per_month")
    private int rent;

    @Column(name = "brokerage")
    private int brokerage;

    @Column(length = 100,name = "property_address")
    private String address;

    @Column(length = 100,name = "property_description")
    private String description;

}
