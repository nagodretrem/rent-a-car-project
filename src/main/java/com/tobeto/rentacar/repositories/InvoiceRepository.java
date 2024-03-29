package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    List<Invoice> findByOwnerUser(int ownerUser);
}
