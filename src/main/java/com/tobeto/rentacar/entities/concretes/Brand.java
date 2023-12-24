package com.tobeto.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand  extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "logo_path")
    private String logoPath;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Model> models;
}
