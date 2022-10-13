package com.example.service.business;

import com.example.dto_interface.business.IContractDetailDto;
import com.example.model.business.ContractDetail;
import com.example.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService extends IFuramaService<ContractDetail> {
    List<IContractDetailDto> findByContractId(int idContract);

    Page<IContractDetailDto> findByContractId(int idContract, Pageable pageable);

    List<IContractDetailDto> findByAll();

    Page<IContractDetailDto> findByAll(Pageable pageable);
}
