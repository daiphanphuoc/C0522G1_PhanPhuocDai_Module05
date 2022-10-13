package com.example.service.impl.business;

import com.example.dto_interface.business.IContractDto;
import com.example.model.business.Contract;
import com.example.repository.business.IContractRepository;
import com.example.service.business.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract insert(Contract element) {
        return contractRepository.save(element);
    }

    @Override
    public Contract update(Contract element) {
        return contractRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return contractRepository.deleteLogicById(id);
    }

    @Override
    public List<IContractDto> findAllDto() {
        return contractRepository.findAllDto();
    }

    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return contractRepository.findAllDto(pageable);
    }

    @Override
    public IContractDto findDtoById(int id) {
        return contractRepository.findDtoId(id);
    }


}
