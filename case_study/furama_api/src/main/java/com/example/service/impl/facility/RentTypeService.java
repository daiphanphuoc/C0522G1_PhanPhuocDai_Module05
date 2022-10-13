package com.example.service.impl.facility;

import com.example.model.facility.RentType;
import com.example.repository.facility.IRentTypeRepository;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public RentType insert(RentType element) {
        return rentTypeRepository.save(element);
    }

    @Override
    public RentType update(RentType element) {
        return rentTypeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return rentTypeRepository.deleteLogicById(id);
    }
}
