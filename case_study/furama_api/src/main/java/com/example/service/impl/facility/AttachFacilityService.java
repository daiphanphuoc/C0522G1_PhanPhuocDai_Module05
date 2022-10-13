package com.example.service.impl.facility;

import com.example.dto_interface.facility.IAttachFacilityDto;
import com.example.model.facility.AttachFacility;
import com.example.repository.facility.IAttachFacilityRepository;
import com.example.service.facility.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public AttachFacility insert(AttachFacility element) {
        return attachFacilityRepository.save(element);
    }

    @Override
    public AttachFacility update(AttachFacility element) {
        return attachFacilityRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return attachFacilityRepository.deleteLogicById(id);
    }

    @Override
    public List<IAttachFacilityDto> findAllDto() {
        return attachFacilityRepository.findAllDto();
    }
}
