package com.example.service.impl.business;

import com.example.dto_interface.business.IContractDetailDto;
import com.example.model.business.ContractDetail;
import com.example.repository.business.IContractDetailRepository;
import com.example.service.business.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public ContractDetail insert(ContractDetail element) {
        return contractDetailRepository.save(element);
    }

    @Override
    public ContractDetail update(ContractDetail element) {
        return contractDetailRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return contractDetailRepository.deleteLogicById(id);
    }

    @Override
    public List<IContractDetailDto> findByContractId(int idContract) {
        return contractDetailRepository.findByContractId(idContract);
    }

    @Override
    public Page<IContractDetailDto> findByContractId(int idContract, Pageable pageable) {
        return contractDetailRepository.findByContractId(idContract, pageable);
    }

    @Override
    public List<IContractDetailDto> findByAll() {
        return contractDetailRepository.findByAll();
    }

    @Override
    public Page<IContractDetailDto> findByAll(Pageable pageable) {
        return contractDetailRepository.findByAll(pageable);
    }
}
