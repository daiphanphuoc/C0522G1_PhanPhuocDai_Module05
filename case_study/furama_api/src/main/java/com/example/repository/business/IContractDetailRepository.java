package com.example.repository.business;

import com.example.dto_interface.business.IContractDetailDto;
import com.example.model.business.ContractDetail;
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
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Modifying
    @Query(value = "update ContractDetail set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);

    @Query(value = "select af.name as attachFacility, af.cost as cost, " +
            " cd.contract_id as contract, cd.id as id," +
            " cd.quantity as quantity " +
            "from contract_detail as cd inner join attach_facility as af " +
            " on cd.attach_facility_id=af.id " +
            "where cd.is_delete = 0 and af.is_delete = 0 and cd.contract_id =:idContract ", nativeQuery = true)
    List<IContractDetailDto> findByContractId(@Param("idContract") int idContract);

    @Query(value = "select af.name as attachFacility, af.cost as cost, " +
            " cd.contract_id as contract, cd.id as id," +
            " cd.quantity as quantity " +
            "from   contract_detail as cd inner join attach_facility as af " +
            " on cd.attach_facility_id=af.id " +
            "where cd.is_delete = 0 and af.is_delete = 0 and cd.contract_id =:idContract",
            countQuery = "select count(*) " +
                    "from   contract_detail as cd inner join attach_facility as af " +
                    " on cd.attach_facility_id=af.id " +
                    "where cd.is_delete = 0 and af.is_delete = 0 and cd.contract_id =:idContract ",
            nativeQuery = true)
    Page<IContractDetailDto> findByContractId(@Param("idContract") int idContract, Pageable pageable);

    @Query(value = "select af.name as attachFacility, af.cost as cost" +
            " cd.contract_id as contract, cd.id as id," +
            " cd.quantity as quantity " +
            "from attach_facility as af inner join contract_detail as cd" +
            " on cd.attach_facility_id=af.id " +
            "where cd.is_delete = 0 and af.is_delete = 0", nativeQuery = true)
    List<IContractDetailDto> findByAll();

    @Query(value = "select af.name as attachFacility, af.cost as cost" +
            " cd.contract_id as contract, cd.id as id," +
            " cd.quantity as quantity " +
            "from attach_facility as af inner join contract_detail as cd" +
            " on cd.attach_facility_id=af.id " +
            "where cd.is_delete = 0 and af.is_delete = 0",
            countQuery = "select count(*) " +
                    "from attach_facility as af inner join contract_detail as cd" +
                    " on cd.attach_facility_id=af.id " +
                    "where cd.is_delete = 0 and af.is_delete = 0 ",
            nativeQuery = true)
    Page<IContractDetailDto> findByAll(Pageable pageable);
}

