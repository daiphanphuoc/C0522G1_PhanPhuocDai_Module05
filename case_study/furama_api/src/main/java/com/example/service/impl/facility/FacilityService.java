package com.example.service.impl.facility;

import com.example.dto_interface.facility.IFacilityDto;
import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility findById(int id) {
        Optional<Facility> facility = facilityRepository.findById(id);
        return facility.orElse(null);
    }

    @Override
    public Facility insert(Facility element) {
        return facilityRepository.save(element);
    }

    @Override
    public Facility update(Facility element) {
        return facilityRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return facilityRepository.deleteLogicById(id) == 1;
    }

    @Override
    public Page<IFacilityDto> find(String searchName, String searchRentType, String searchFacilityType, Pageable pageable) {
        return facilityRepository.find(searchName, searchRentType, searchFacilityType, pageable);
    }

    @Override
    public List<IFacilityDto> findAllDto() {
        return facilityRepository.findAllDto();
    }
}
