package com.example.service.impl.person;

import com.example.dto_interface.person.ICustomerDto;
import com.example.model.person.Customer;
import com.example.repository.person.ICustomerRepository;
import com.example.service.person.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer insert(Customer element) {
        return customerRepository.save(element);
    }

    @Override
    public Customer update(Customer element) {
        return customerRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.deleteLogicById(id) == 1;
    }

    @Override
    public Page<ICustomerDto> find(String searchName, String searchAddress, String searchType, Pageable pageable) {
        return customerRepository.find(searchName, searchAddress, searchType, pageable);
    }

    @Override
    public List<ICustomerDto> findAllDto() {
        return customerRepository.findAllDto();
    }

    public ICustomerDto findByIdCitizen(String idCitizen) {
        return customerRepository.findByIdCitizen(idCitizen);
    }
}
