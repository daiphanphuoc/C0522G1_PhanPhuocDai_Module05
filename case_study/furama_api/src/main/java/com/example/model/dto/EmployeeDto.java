package com.example.model.dto;

import com.example.model.permission.User;
import com.example.model.person.Division;
import com.example.model.person.EducationDegree;
import com.example.model.person.Position;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.util.Date;

public class EmployeeDto implements Validator {
    private int id;
    @NotBlank(message = "Tên không được để trống.")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5})| *$",
            message = "Tên Nhân viên không được chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;

    @NotBlank(message = "Số CMND/CCCD không được để trống.")
    @Pattern(regexp = "^(\\d{9}|\\d{12})| *$",
            message = "Số CMND/CCCD phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCitizen;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull(message = "Vui lòng chọn giới tính.")
    private boolean sex;

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^((0|[(]84[)][+])9[01]\\d{7})| *$", message =
            "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phone;
    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Địa chỉ email phải đúng định dạng.")
    private String email;

    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;
    private EducationDegree degree;
    private Position position;
    private Division division;
    private User user;

    @Min(3000000)
    private double salary;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String idCitizen, Date birthday, boolean sex,
                       String phone, String email, String address, EducationDegree degree,
                       Position position, Division division, User user, double salary) {
        this.id = id;
        this.name = name;
        this.idCitizen = idCitizen;
        this.birthday = birthday;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.degree = degree;
        this.position = position;
        this.division = division;
        this.user = user;
        this.salary = salary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(String idCitizen) {
        this.idCitizen = idCitizen;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EducationDegree getDegree() {
        return degree;
    }

    public void setDegree(EducationDegree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
    }
}
