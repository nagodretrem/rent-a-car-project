package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Invoice;
import com.tobeto.rentacar.repositories.InvoiceRepository;
import com.tobeto.rentacar.services.abstracts.InvoiceService;
import com.tobeto.rentacar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentacar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetInvoiceListResponse> getAll() {

        List<Invoice> invoices=this.invoiceRepository.findAll();
        List<GetInvoiceListResponse> response=invoices.stream()
                .map(invoice->this.modelMapperService.forResponse()
                        .map(invoice, GetInvoiceListResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public GetInvoiceResponse getByOwnerUser(int ownerUser) {
        Invoice invoice=this.invoiceRepository.findByOwnerUser(ownerUser).orElseThrow();
        GetInvoiceResponse response=this.modelMapperService.forResponse()
                .map(invoice,GetInvoiceResponse.class);

        return response;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice=this.invoiceRepository.findById(id).orElseThrow();
        GetInvoiceResponse response=this.modelMapperService.forResponse()
                .map(invoice,GetInvoiceResponse.class);
        return response;
    }

    @Override
    public void add(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice=this.modelMapperService.forRequest()
                .map(addInvoiceRequest,Invoice.class);
        this.invoiceRepository.save(invoice);

    }

    @Override
    public void update(UpdateInvoiceRequest updateInvoiceRequest) {
        Invoice invoice=this.modelMapperService.forRequest()
                .map(updateInvoiceRequest,Invoice.class);
        this.invoiceRepository.save(invoice);

    }

    @Override
    public void delete(int id) {
        this.invoiceRepository.deleteById(id);

    }
}
