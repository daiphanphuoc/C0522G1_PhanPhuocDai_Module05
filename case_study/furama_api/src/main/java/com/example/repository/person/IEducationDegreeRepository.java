package com.example.repository.person;

import com.example.dto_interface.person.IEducationDegreeDto;
import com.example.model.person.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {

    @Modifying
    @Query(value = "update education_degree set is_delete = 1 where  id = :id and is_delete = 0 ", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);

    @Query(value = "select name, id from education_degree where is_delete = 0", nativeQuery = true)
    List<IEducationDegreeDto> findEducationDegreeDto();
}
