package com.example.repository.facility;

import com.example.dto_interface.facility.IRentTypeDto;
import com.example.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {

    @Modifying
    @Query(value = "update RentType set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);

    @Query(value = "select name, id from rent_type where is_delete = 0", nativeQuery = true)
    List<IRentTypeDto> findRentType();
}
