package com.example.repository.person;

import com.example.dto_interface.person.IEmployeeDto;
import com.example.model.person.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "update  employee set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    int deleteLogicById(@Param("id") int id);

    @Query(value = "select employee.name as name, birthday, address, employee.id as id," +
            " `position`.name as `position`, sex " +
            "from `position` " +
            "join employee on employee.position_id = `position`.id" +
            " where employee.name like %:searchName% " +
            "and employee.address like %:searchAddress% " +
            "and `position`.name like %:searchPosition%  " +
            "and employee.is_delete = 0",
            countQuery = "select count(*) " +
                    "from `position` " +
                    "join employee on employee.position_id = `position`.id" +
                    " where employee.name like %:searchName% " +
                    "and employee.address like %:searchAddress% " +
                    "and `position`.name like %:searchPosition%  " +
                    "and employee.is_delete = 0", nativeQuery = true)
    Page<IEmployeeDto> find(@Param("searchName") String searchName, @Param("searchAddress") String searchAddress, @Param("searchPosition") String searchPosition, Pageable pageable);

    @Query(value = "select employee.name as name, birthday, address, employee.id as id," +
            " `position`.name as `position`, sex " +
            "from `position` " +
            "join employee on employee.position_id = `position`.id" +
            " where employee.is_delete =0", nativeQuery = true)
    List<IEmployeeDto> findAllDto();
}
