package com.example.service.person;

import com.example.dto_interface.person.IEmployeeDto;
import com.example.model.person.Employee;
import com.example.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService extends IFuramaService<Employee> {
    Page<IEmployeeDto> find(String searchName, String searchAddress, String searchPosition, Pageable pageable);

    List<IEmployeeDto> findAllDto();
}
