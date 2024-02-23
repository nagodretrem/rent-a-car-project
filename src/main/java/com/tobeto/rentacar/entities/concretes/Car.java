package com.tobeto.rentacar.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {


    @Column(name = "plate", unique = true)
    private String plate;

    @Column(name = "kilometer")
    private long kilometer;

    @Column(name = "daily_price")
    private float dailyPrice;

    @Column(name = "model_year")
    private short modelYear;

    @Column(name = "min_findeks_rate")
    private short minFindeksRate;

    @Column (name = "image_path", length =  500)
    private String imagePath;

    @Column (name = "car_type")
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column (name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column (name = "available")
    @Enumerated(EnumType.STRING)
    private Available available;


    @Column (name = "transmission_type")
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;



}
