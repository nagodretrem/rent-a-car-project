package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
    private UserService userService;


    public void checkIfUserIdNotExists(int id) {
        if (!userService.existsById(id)) {
            throw new BusinessException(Messages.UID_NOT_FOUND);
        }
    }

    public void checkIfCustomerNationalityIdExists(String nationality) {
        if (customerRepository.existsByNationalityId(nationality)) {
            throw new BusinessException(Messages.UNID_NOT_FOUND);
        }
    }
}
