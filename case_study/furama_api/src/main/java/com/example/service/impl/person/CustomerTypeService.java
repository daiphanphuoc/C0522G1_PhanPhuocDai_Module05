package com.example.service.impl.person;

import com.example.model.person.CustomerType;
import com.example.repository.person.ICustomerTypeRepository;
import com.example.service.person.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerType insert(CustomerType element) {
        return customerTypeRepository.save(element);
    }

    @Override
    public CustomerType update(CustomerType element) {
        return customerTypeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return customerTypeRepository.deleteLogicById(id);
    }
}
