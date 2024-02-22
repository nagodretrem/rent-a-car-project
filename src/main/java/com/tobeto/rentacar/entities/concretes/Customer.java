package com.tobeto.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "nationality_id")
    private String nationalityId;

    @Column(name = "gsm")
    private String gsm;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
