package com.example.repository.business;

import com.example.dto_interface.business.IContractDto;
import com.example.model.business.Contract;
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
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Modifying
    @Query(value = "update Contract set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);

    @Query(value = "select ct.id as id, c.`name` as customer, f.`name` as facility, em.`name` as employee," +
            " ct.`start` as `start`, ct.`end` as `end` , ct.deposit as deposit," +
            " (ifnull(f.rental_costs,0) + ifnull(cd.quantity,0)*ifnull(af.cost,0)) as totalMoney " +
            "from contract as ct inner join customer as c on c.id = ct.customer_id " +
            "   inner join employee as em on em.id = ct.employee_id " +
            "   inner join facility as f on f.id =  ct.facility_id " +
            "   left join contract_detail as cd on cd.contract_id =ct.id " +
            "   left join attach_facility as af on af.id=  cd.attach_facility_id " +
            "where ct.is_delete = 0 and c.is_delete = 0 and f.is_delete = 0 and em.is_delete = 0 " +
            "group by ct.id", nativeQuery = true)
    List<IContractDto> findAllDto();

    @Query(value = "select ct.id as id, c.`name` as customer, f.`name` as facility, em.`name` as employee," +
            " ct.`start` as `start`, ct.`end` as `end` , ct.deposit as deposit," +
            " (ifnull(f.rental_costs,0) + ifnull(cd.quantity,0)*ifnull(af.cost,0)) as totalMoney " +
            "from contract as ct inner join customer as c on c.id = ct.customer_id " +
            "   inner join employee as em on em.id = ct.employee_id " +
            "   inner join facility as f on f.id =  ct.facility_id " +
            "   left join contract_detail as cd on cd.contract_id =ct.id " +
            "   left join attach_facility as af on af.id=  cd.attach_facility_id " +
            "where ct.is_delete = 0 and c.is_delete = 0 and f.is_delete = 0 and em.is_delete = 0 " +
            "group by ct.id",
            countQuery = "select count(ct.id) " +
                    " from contract as ct inner join customer as c on c.id = ct.customer_id " +
                    "   inner join employee as em on em.id = ct.employee_id " +
                    "   inner join facility as f on f.id =  ct.facility_id " +
                    "   left join contract_detail as cd on cd.contract_id =ct.id " +
                    "   left join attach_facility as af on af.id=  cd.attach_facility_id " +
                    "where ct.is_delete = 0 and c.is_delete = 0 and f.is_delete = 0 and em.is_delete = 0 " +
                    "group by ct.id",
            nativeQuery = true)
    Page<IContractDto> findAllDto(Pageable pageable);


    @Query(value = "select ct.id as id, c.`name` as customer, f.`name` as facility, em.`name` as employee," +
            " ct.`start` as `start`, ct.`end` as `end` , ct.deposit as deposit," +
            " (ifnull(f.rental_costs,0) + ifnull(cd.quantity,0)*ifnull(af.cost,0)) as totalMoney " +
            "from contract as ct inner join customer as c on c.id = ct.customer_id " +
            "   inner join employee as em on em.id = ct.employee_id " +
            "   inner join facility as f on f.id =  ct.facility_id " +
            "   left join contract_detail as cd on cd.contract_id =ct.id " +
            "   left join attach_facility as af on af.id=  cd.attach_facility_id " +
            "where ct.is_delete = 0 and c.is_delete = 0 and f.is_delete = 0 and em.is_delete = 0 " +
            "   and cd.is_delete = 0 and af.is_delete = 0 and ct.id =:id " +
            "group by ct.id", nativeQuery = true)
    IContractDto findDtoId(@Param("id") int id);
}
