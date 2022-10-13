package com.example.service.business;

import com.example.dto_interface.business.IContractDto;
import com.example.model.business.Contract;
import com.example.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService extends IFuramaService<Contract> {
    List<IContractDto> findAllDto();

    Page<IContractDto> findAllDto(Pageable pageable);

    IContractDto findDtoById(int id);

}
