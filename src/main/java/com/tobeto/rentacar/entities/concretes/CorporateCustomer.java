package com.tobeto.rentacar.entities.concretes;


import com.tobeto.rentacar.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "corporate_customers")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CorporateCustomer extends BaseEntity {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tax_no")
    private String taxNo;

    @Column(name = "corporate_number")
    private String corporateNumber;

    @Column(name = "gsm")
    private String gsm;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
