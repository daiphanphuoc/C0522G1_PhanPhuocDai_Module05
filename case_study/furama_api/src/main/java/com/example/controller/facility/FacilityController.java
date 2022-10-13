package com.example.controller.facility;

import com.example.model.dto.FacilityDto;
import com.example.model.facility.Facility;
import com.example.model.facility.House;
import com.example.model.facility.Room;
import com.example.model.facility.Villa;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
import daiphan.casestudy.model.dto.FacilityDto;
import daiphan.casestudy.model.facility.*;
import daiphan.casestudy.service.facility.IFacilityService;
import daiphan.casestudy.service.facility.IFacilityTypeService;
import daiphan.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    private void useTotal(Model model,
                          @RequestParam(defaultValue = "") String searchName,
                          @RequestParam(defaultValue = "") String searchRentType,
                          @RequestParam(defaultValue = "") String searchFacilityType,
                          @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchRentType", searchRentType);
        model.addAttribute("searchFacilityType", searchFacilityType);
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("facilityList", facilityService.find(searchName, searchRentType, searchFacilityType, pageable));

    }

    @GetMapping
    public String showFacility(Model model,
                               @RequestParam(defaultValue = "") String searchName,
                               @RequestParam(defaultValue = "") String searchRentType,
                               @RequestParam(defaultValue = "") String searchFacilityType,
                               @PageableDefault(value = 3) Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/facility";
    }

    @GetMapping("/view/{id}")
    public String showInfo(@PathVariable int id, Model model,
                           @RequestParam(defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "") String searchRentType,
                           @RequestParam(defaultValue = "") String searchFacilityType,
                           @PageableDefault(value = 3) Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);

        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facility", facilityDto);
        model.addAttribute("facilityDto", new FacilityDto());

        model.addAttribute("action", "openInfo");
        return "facility/facility";
    }

    @GetMapping("/update/{id}")
    public String showModalUpdate(@PathVariable int id, Model model,
                                  @RequestParam(defaultValue = "") String searchName,
                                  @RequestParam(defaultValue = "") String searchRentType,
                                  @RequestParam(defaultValue = "") String searchFacilityType,
                                  @PageableDefault(value = 3) Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);

        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        if (facility != null) {
            BeanUtils.copyProperties(facility, facilityDto);
            model.addAttribute("action", "openUpdate");
        } else {
            model.addAttribute("action", "openFail");
            model.addAttribute("msg", "Cơ sở ko tồn tại");
        }
        model.addAttribute("facilityDto", facilityDto);
        return "facility/facility";
    }

    @PostMapping("/update/{id}")
    public String updateByModal(@PathVariable int id,
                                @ModelAttribute FacilityDto facilityDto,
                                BindingResult bindingResult, Model model,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchRentType,
                                @RequestParam(defaultValue = "") String searchFacilityType,
                                @PageableDefault(value = 3) Pageable pageable,
                                RedirectAttributes redirectAttributes) {

        Facility facility = facilityService.findById(id);

        if (facility != null) {
            useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
            if (bindingResult.hasFieldErrors()) {
                model.addAttribute("action", "openUpdate");
                return "facility/facility";
            }
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.update(facility);
            redirectAttributes.addFlashAttribute("action", "openMsg");
            redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
            return "redirect:/facility";
        }
        redirectAttributes.addFlashAttribute("action", "openFail");
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thất bại");
        return "redirect:/facility";
    }

    @PostMapping("/create")
    public String createByModal(@ModelAttribute @Validated FacilityDto facilityDto,
                                BindingResult bindingResult, Model model,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchRentType,
                                @RequestParam(defaultValue = "") String searchFacilityType,
                                @PageableDefault(value = 3) Pageable pageable,
                                RedirectAttributes redirectAttributes) {
       // useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
        if (bindingResult.hasFieldErrors()) {
            useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
            model.addAttribute("action", "openCreate");
            return "facility/facility";
        }
        Facility facility;
        if (facilityDto.getFacilityType().getId() == 1) {
            facility = new Villa();
        } else if (facilityDto.getFacilityType().getId() == 2) {
            facility = new House();
        } else {
            facility = new Room();
        }
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.insert(facility);
        redirectAttributes.addFlashAttribute("action", "openMsg");
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/facility";
    }


    @GetMapping("/delete")
    public String deleteByModal(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id);
        if (facility != null) {
            boolean rs = facilityService.delete(id);
            if (rs) {
                redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
                redirectAttributes.addFlashAttribute("action", "openMsg");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Xóa thất bại");
                redirectAttributes.addFlashAttribute("action", "openFail");
            }
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tồn tại");
            redirectAttributes.addFlashAttribute("action", "openFail");
        }
        return "redirect:/facility";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/create";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id);
        if (facility != null) {
            FacilityDto facilityDto = new FacilityDto();
            BeanUtils.copyProperties(facility, facilityDto);
            model.addAttribute("facilityDto", facilityDto);
            model.addAttribute("facilityTypeList", facilityTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "facility/update";
        }
        redirectAttributes.addFlashAttribute("msg", "Không tồn tại cơ sở dịch vụ");
        redirectAttributes.addFlashAttribute("action", "openFail");
        return "redirect:/facility";
    }

    @PostMapping("/edit/{id}")
    public String updateByForm(@PathVariable int id, @ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        Facility facility = facilityService.findById(id);

        if (facility != null) {
            if (bindingResult.hasFieldErrors()) {
                model.addAttribute("facilityTypeList", facilityTypeService.findAll());
                model.addAttribute("rentTypeList", rentTypeService.findAll());
                return "facility/update";
            }
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.update(facility);
            redirectAttributes.addFlashAttribute("action", "openMsg");
            redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
            return "redirect:/facility";
        }
        redirectAttributes.addFlashAttribute("action", "openFail");
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thất bại");
        return "redirect:/facility";


    }

    @PostMapping("/add")
    public String createNewByForm(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypeList", facilityTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "facility/create";
        }

        Facility facility;
        if (facilityDto.getFacilityType().getId() == 1) {
            facility = new Villa();
        } else if (facilityDto.getFacilityType().getId() == 2) {
            facility = new House();
        } else {
            facility = new Room();
        }
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.insert(facility);
        redirectAttributes.addFlashAttribute("action", "openMsg");
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");

        //redirectAttributes.addFlashAttribute("message", "Thêm mới  thành công!");
        return "redirect:/facility";


    }
}
