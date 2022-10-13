package com.example.repository.person;

import com.example.model.person.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

    @Modifying
    @Query(value = "update  customer_type set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);
}
