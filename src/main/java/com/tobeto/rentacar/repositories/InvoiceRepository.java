package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
