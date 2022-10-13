package com.example.repository.person;

import com.example.dto_interface.person.IPositionDto;
import com.example.model.person.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IPositionRepository extends JpaRepository<Position, Integer> {

    @Modifying
    @Query(value = "update Position set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);

    @Query(value = "select name, id from `position` where is_delete = 0", nativeQuery = true)
    List<IPositionDto> findPositionDto();
}
