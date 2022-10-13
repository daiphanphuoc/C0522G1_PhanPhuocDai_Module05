package com.example.service.facility;

import com.example.dto_interface.facility.IAttachFacilityDto;
import com.example.model.facility.AttachFacility;
import com.example.service.IFuramaService;

import java.util.List;

public interface IAttachFacilityService extends IFuramaService<AttachFacility> {
    List<IAttachFacilityDto> findAllDto();
}
