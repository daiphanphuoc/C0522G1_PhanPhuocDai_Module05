package com.example.service.person;

import com.example.dto_interface.person.ICustomerDto;
import com.example.model.person.Customer;
import com.example.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IFuramaService<Customer> {
    Page<ICustomerDto> find(String searchName, String searchAddress, String searchType, Pageable pageable);

    List<ICustomerDto> findAllDto();

    ICustomerDto findByIdCitizen(String idCitizen);
}
