package com.example.service.impl.facility;

import com.example.model.facility.FacilityType;
import com.example.repository.facility.IFacilityTypeRepository;
import com.example.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(int id) {
        return facilityTypeRepository.findById(id).orElse(null);
    }

    @Override
    public FacilityType insert(FacilityType element) {
        return facilityTypeRepository.save(element);
    }

    @Override
    public FacilityType update(FacilityType element) {
        return facilityTypeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return facilityTypeRepository.deleteLogicById(id);
    }
}
