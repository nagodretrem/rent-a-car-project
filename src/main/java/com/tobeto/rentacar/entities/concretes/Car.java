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

    @Column (name = "image_path")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Rental> rentals;



}
