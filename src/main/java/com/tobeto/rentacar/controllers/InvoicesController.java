package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.InvoiceService;
import com.tobeto.rentacar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentacar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentacar.services.dtos.responses.invoice.GetInvoiceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
@AllArgsConstructor
public class InvoicesController {
    private InvoiceService invoiceService;

    @GetMapping
    public List<GetInvoiceListResponse> getAll(){
            return invoiceService.getAll();
        }
    @GetMapping({"/{id}"})
    public GetInvoiceResponse getById(@PathVariable int id){
        return invoiceService.getById(id);
    }

    @GetMapping({"/profile/{ownerUser}"})
    public GetInvoiceResponse getByUserId(@PathVariable int ownerUser){
        return invoiceService.getByOwnerUser(ownerUser);
    }

    @PostMapping()
    public void add(@RequestBody @Valid AddInvoiceRequest addInvoiceRequest){
        this.invoiceService.add(addInvoiceRequest);
    }
    @PutMapping()
    public void update(@RequestBody @Valid UpdateInvoiceRequest updateInvoiceRequest){
        this.invoiceService.update(updateInvoiceRequest);
    }
    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.invoiceService.delete(id);
    }
}
