package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "invoices")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invoice extends BaseEntity
{

    @Column(name = "discount_rate")
    private short discountRate;

    @Column(name = "total_price")
    private float totalPrice;

    @Column(name = "owner_user")
    private int ownerUser;

    @ManyToOne()
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
