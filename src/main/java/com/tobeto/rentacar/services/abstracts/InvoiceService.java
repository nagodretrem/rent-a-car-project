package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentacar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetInvoiceListResponse> getAll();
    GetInvoiceResponse getById(int id);

    GetInvoiceResponse getByOwnerUser(int ownerUser);
    void add(AddInvoiceRequest addInvoiceRequest);
    void update(UpdateInvoiceRequest updateInvoiceRequest);

    void delete(int id);

}
