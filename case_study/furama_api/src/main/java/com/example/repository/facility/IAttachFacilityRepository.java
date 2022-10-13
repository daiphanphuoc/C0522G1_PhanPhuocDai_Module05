package com.example.repository.facility;

import com.example.dto_interface.facility.IAttachFacilityDto;
import com.example.model.facility.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {

    @Modifying
    @Query(value = "update AttachFacility set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);

    @Query(value = "select af.id, `name`, unit, cost, `status` from attach_facility as af where af.is_delete = 0", nativeQuery = true)
    List<IAttachFacilityDto> findAllDto();

    @Query(value = "select af.id, `name`, unit, cost, `status`  " +
            "from attach_facility as af inner join contract_detail as cd on cd.attach_facility_id=af.id " +
            "   inner join contract as ct on ct.id = cd.contract_id " +
            "where af.is_delete = 0 and ct.is_delete = 0 and cd.is_delete = 0 " +
            "   and ct.id = :idContract", nativeQuery = true)
    List<IAttachFacilityDto> findAllDtoByContract(@Param("idContract") int idContract);

}
