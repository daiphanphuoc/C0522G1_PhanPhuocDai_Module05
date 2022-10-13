package com.example.controller.person;

import daiphan.casestudy.dto_interface.person.IEmployeeDto;
import daiphan.casestudy.model.dto.EmployeeDto;
import daiphan.casestudy.model.person.Employee;
import daiphan.casestudy.service.person.IDivisionService;
import daiphan.casestudy.service.person.IEducationDegreeService;
import daiphan.casestudy.service.person.IEmployeeService;
import daiphan.casestudy.service.person.IPositionService;
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

import java.time.LocalDate;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService degreeService;

    @Autowired
    private IDivisionService divisionService;

    @GetMapping("/delete")
    public String deleteByModal(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            boolean rs = employeeService.delete(id);
            if (rs) {
                redirectAttributes.addFlashAttribute("mesDelete", "Xóa thành công");
            } else {
                redirectAttributes.addFlashAttribute("mesDelete", "Xóa thất bại");
            }
        } else {
            redirectAttributes.addFlashAttribute("mesDelete", "Không tồn tại");
        }
        return "redirect:/employee";
    }

    private void useTotal(@RequestParam(defaultValue = "") String searchName,
                          @RequestParam(defaultValue = "") String searchAddress,
                          @RequestParam(defaultValue = "") String searchPosition,
                          Model model,
                          @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("degreeList", degreeService.findAll());

        model.addAttribute("employee", new EmployeeDto());

        model.addAttribute("employeeDtoUpdate", new EmployeeDto());
        model.addAttribute("newEmployeeDto", new EmployeeDto());
        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchAddress", searchAddress);
        model.addAttribute("searchPosition", searchPosition);
        model.addAttribute("employees", employeeService.find(searchName, searchAddress, searchPosition, pageable));
    }

    @GetMapping()
    public String showEmployees(Model model,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchAddress,
                                @RequestParam(defaultValue = "") String searchPosition,
                                @PageableDefault(value = 3) Pageable pageable) {
        useTotal(searchName, searchAddress, searchPosition, model, pageable);
        return "employee/employee";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("degreeList", degreeService.findAll());
        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        return "employee/create";
    }

    @GetMapping("/update/{id}")
    public String showModalUpdate(@PathVariable int id, Model model,
                                 @RequestParam(defaultValue = "") String searchName,
                                 @RequestParam(defaultValue = "") String searchAddress,
                                 @RequestParam(defaultValue = "") String searchPosition,
                                 @PageableDefault(value = 3) Pageable pageable) {
        useTotal(searchName, searchAddress, searchPosition, model, pageable);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(id), employeeDto);
        model.addAttribute("employeeDtoUpdate", employeeDto);
        model.addAttribute("action", "openUpdate");
        return "employee/employee";
    }

    @PostMapping("/update/{id}")
    public String updateByModal(@PathVariable int id,
                                @ModelAttribute EmployeeDto employeeDtoUpdate,
                                Model model, BindingResult bindingResult,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchAddress,
                                @RequestParam(defaultValue = "") String searchPosition,
                                @PageableDefault(value = 3) Pageable pageable) {

        Employee employee = employeeService.findById(id);
        if (employee != null) {
            new EmployeeDto().validate(employeeDtoUpdate, bindingResult);
            useTotal(searchName, searchAddress, searchPosition, model, pageable);
            if (bindingResult.hasFieldErrors()) {
                model.addAttribute("action", "openUpdate");
                return "employee/employee";
            }

            BeanUtils.copyProperties(employeeDtoUpdate, employee);
            employeeService.update(employee);

            return "employee/employee";
        }
        return "/layout";
    }

    @GetMapping("/view/{id}")
    public String showInfo(@PathVariable int id, Model model,
                           @RequestParam(defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "") String searchAddress,
                           @RequestParam(defaultValue = "") String searchPosition,
                           @PageableDefault(value = 3) Pageable pageable) {
        useTotal(searchName, searchAddress, searchPosition, model, pageable);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(id), employeeDto);
        model.addAttribute("employee", employeeDto);
        model.addAttribute("action", "openInfo");
        return "employee/employee";
    }


    @PostMapping("/create")
    public String createNew(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);

        boolean isDuplicateIdCard = false;
        for (IEmployeeDto employee : employeeService.findAllDto()) {
            if (employeeDto.getIdCitizen().equals(employee.getIdCitizen())) {
                isDuplicateIdCard = true;
                break;
            }
        }

        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("degreeList", degreeService.findAll());

            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCard", "Số CMND/CCCD đã tồn tại, vui lòng kiểm tra lại.");
            }

            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);

            return "employee/create";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        Employee e = employeeService.insert(employee);
        if (e != null) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới nhân viên thành công!");
            return "redirect:/employee";
        }

        return "employee/create";

    }
}
