package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Employee;
import com.tobeto.rentacar.repositories.EmployeeRepository;
import com.tobeto.rentacar.services.abstracts.EmployeeService;
import com.tobeto.rentacar.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentacar.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentacar.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentacar.services.dtos.responses.employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetEmployeeListResponse> getAll() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<GetEmployeeListResponse> responses = employees.stream()
                .map(employee -> this.modelMapperService.forResponse()
                        .map(employee, GetEmployeeListResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow();
        GetEmployeeResponse response = this.modelMapperService.forResponse()
                .map(employee, GetEmployeeResponse.class);

        return response;
    }

    @Override
    public void add(AddEmployeeRequest addEmployeeRequest) {
        Employee employee=this.modelMapperService.forRequest().map(addEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee=this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        this.employeeRepository.deleteById(id);
    }

}
