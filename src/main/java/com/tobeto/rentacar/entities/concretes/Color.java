package com.tobeto.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "colors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "color")
    @JsonIgnore
    private List<Car> cars;
}
