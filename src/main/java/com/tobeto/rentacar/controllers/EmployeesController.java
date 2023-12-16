package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentacar.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentacar.services.dtos.responses.employee.GetEmployeeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeesController {
    private EmployeeService employeeService;

    @GetMapping()
    public List<GetEmployeeListResponse> getAll(){
        return employeeService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetEmployeeResponse getById(@PathVariable int id){
        return employeeService.getById(id);
    }
    @PostMapping()
    public void add(@RequestBody @Valid AddEmployeeRequest addEmployeeRequest){
        this.employeeService.add(addEmployeeRequest);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateEmployeeRequest updateEmployeeRequest){
        this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.employeeService.delete(id);
    }
}
