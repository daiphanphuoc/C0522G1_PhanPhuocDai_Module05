package com.example.controller.business;

import daiphan.casestudy.dto_interface.business.IContractDto;
import daiphan.casestudy.model.business.Contract;
import daiphan.casestudy.model.dto.ContractDto;
import daiphan.casestudy.service.business.IContractDetailService;
import daiphan.casestudy.service.business.IContractService;
import daiphan.casestudy.service.facility.IFacilityService;
import daiphan.casestudy.service.person.ICustomerService;
import daiphan.casestudy.service.person.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/contract/api")
public class RestContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractDetailService contractDetailService;



    @GetMapping("")
    public ResponseEntity<List<IContractDto>> getContractList(){
        List<IContractDto> contractDtoList =contractService.findAllDto();
        if(contractDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDtoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IContractDto> getContract(@PathVariable int id){
        IContractDto contractDto =contractService.findDtoById(id);
        if(contractDto==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDto,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createContract(@RequestBody ContractDto contractDto){
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.insert(contract);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractDto> updateContract(@PathVariable int id, @RequestBody ContractDto contractDto){
        IContractDto  iContractDto =contractService.findDtoById(id);
        if(iContractDto!=null && iContractDto.getId()==contractDto.getId()){
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            contractService.update(contract);
            return new ResponseEntity<>(contractDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContract(@PathVariable int id){
        IContractDto  iContractDto =contractService.findDtoById(id);
        if(iContractDto!=null){
            contractService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
