package com.example.controller.business;

import com.example.service.business.IContractService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/list")
    public ResponseEntity showList() {
        model.addAttribute("contractDto", new ContractDto());
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(new Contract());
        model.addAttribute("contractDetailDto", contractDetailDto);
        model.addAttribute("attachFacilities", attachFacilityService.findAllDto());
        model.addAttribute("customers", customerService.findAllDto());
        model.addAttribute("employees", employeeService.findAllDto());
        model.addAttribute("facilities", facilityService.findAllDto());
        return new ModelAndView("contract/contract", "contractList", contractService.findAllDto(pageable));
    }


    @PostMapping("/create")
    public String createContractByModal(@ModelAttribute ContractDto contractDto,
                                        RedirectAttributes redirectAttributes) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.insert(contract);
        redirectAttributes.addFlashAttribute("action", "openMsg");
        redirectAttributes.addFlashAttribute("action", "Thêm mới thành công");
        return "redirect:/contract/list";
    }

    @GetMapping("/attachFacility/{id}")
    public String showAttachFacility(@PathVariable Integer id, Model model,
                                     @PageableDefault(value = 10) Pageable pageable) {
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(new Contract());
        model.addAttribute("contractDetailDto", contractDetailDto);
        model.addAttribute("attachFacilities", attachFacilityService.findAllDto());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customers", customerService.findAllDto());
        model.addAttribute("employees", employeeService.findAllDto());
        model.addAttribute("facilities", facilityService.findAllDto());
        model.addAttribute("contractList", contractService.findAllDto(pageable));
        model.addAttribute("contractDetails", contractDetailService.findByContractId(id));
        model.addAttribute("action", "openAttach");
        return "contract/contract";
    }

    @GetMapping("/contractDetail/{id}")
    public String createContractDetail(@PathVariable Integer id, Model model,
                                       @PageableDefault(value = 10) Pageable pageable) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customers", customerService.findAllDto());
        model.addAttribute("employees", employeeService.findAllDto());
        model.addAttribute("facilities", facilityService.findAllDto());
        model.addAttribute("contractList", contractService.findAllDto(pageable));
        model.addAttribute("contractDetails", contractDetailService.findByContractId(id));
        IContractDto contractDto = contractService.findDtoById(id);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        Contract contract = new Contract();
        contract.setId(contractDto.getId());
        contractDetailDto.setContract(contract);
        model.addAttribute("contractDetailDto", contractDetailDto);
        model.addAttribute("attachFacilities", attachFacilityService.findAllDto());
        model.addAttribute("action", "openDetail");
        return "contract/contract";
    }
}
