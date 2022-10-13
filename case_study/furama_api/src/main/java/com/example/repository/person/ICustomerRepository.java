package com.example.repository.person;

import com.example.dto_interface.person.ICustomerDto;
import com.example.model.person.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Query(value = "update customer set is_delete = 1 where id = :id and is_delete = 0", nativeQuery = true)
    int deleteLogicById(@Param("id") Integer id);

    @Query(value = "select customer.name as name, birthday, address, customer.id as id," +
            " customer_type.name as customerType, sex " +
            "from customer " +
            "join customer_type on customer_type.id = customer.customer_type_id" +
            " where customer.name like %:searchName% " +
            "and customer.address like %:searchAddress% " +
            "and customer_type.name like %:searchType%  " +
            "and customer.is_delete = 0",
            countQuery = "select count(*) " +
                    "from customer " +
                    "join customer_type on customer_type.id = customer.customer_type_id" +
                    " where customer.name like %:searchName% " +
                    "and customer.address like %:searchAddress% " +
                    "and customer_type.name like %:searchType%  " +
                    "and customer.is_delete = 0"
            , nativeQuery = true)
    Page<ICustomerDto> find(@Param("searchName") String searchName,
                            @Param("searchAddress") String searchAddress,
                            @Param("searchType") String searchType, Pageable pageable);


    @Query(value = "select customer.name as name, birthday, address, customer.id as id," +
            " customer_type.name as customerType, sex,id_citizen " +
            "from customer " +
            "join customer_type on customer_type.id = customer.customer_type_id" +
            " where customer.is_delete = 0", nativeQuery = true)
    List<ICustomerDto> findAllDto();

    @Query(value = "select customer.name as name, birthday, address, customer.id as id," +
            " customer_type.name as customerType, sex,id_citizen " +
            "from customer " +
            "join customer_type on customer_type.id = customer.customer_type_id" +
            " where customer.is_delete = 0 and id_citizen like :idCitizen ", nativeQuery = true)
    ICustomerDto findByIdCitizen(@Param("idCitizen") String idCitizen);
}
