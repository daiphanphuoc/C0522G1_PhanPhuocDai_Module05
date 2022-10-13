package com.example.service.facility;

import com.example.dto_interface.facility.IFacilityDto;
import com.example.model.facility.Facility;
import com.example.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService extends IFuramaService<Facility> {
    Page<IFacilityDto> find(@Param("searchName") String searchName,
                            @Param("searchRentType") String searchRentType,
                            @Param("searchFacilityType") String searchFacilityType,
                            Pageable pageable);

    List<IFacilityDto> findAllDto();
}
