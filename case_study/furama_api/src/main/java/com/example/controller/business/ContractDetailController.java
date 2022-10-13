package com.example.controller.business;

import daiphan.casestudy.dto_interface.business.IContractDetailDto;
import daiphan.casestudy.dto_interface.business.IContractDto;
import daiphan.casestudy.model.business.ContractDetail;
import daiphan.casestudy.model.dto.ContractDetailDto;
import daiphan.casestudy.service.business.IContractDetailService;
import daiphan.casestudy.service.business.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @PostMapping("/create")
    public String createNewContractDetail(@ModelAttribute ContractDetailDto contractDetailDto,
                                          RedirectAttributes redirectAttributes) {
        IContractDto iContractDto;
        if (contractDetailDto.getContract() != null) {
            iContractDto = contractService.findDtoById(contractDetailDto.getContract().getId());
            if (iContractDto != null) {
                ContractDetail contractDetail = new ContractDetail(contractDetailDto);
                contractDetailService.insert(contractDetail);
                redirectAttributes.addFlashAttribute("action", "openMsg");
                redirectAttributes.addFlashAttribute("msg", "Thêm mới hợp đồng chi tiết thành công");
                return "redirect:/contract";
            }
        }

        redirectAttributes.addFlashAttribute("action", "openCreateDetail");
        //redirectAttributes.addFlashAttribute("msg","Thêm mới hợp đồng chi tiết thành công");

        return "redirect:/contract";
    }
}
