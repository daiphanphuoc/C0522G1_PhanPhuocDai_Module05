package com.example.model.person;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class Person {
    private String name;
    private String idCitizen;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private boolean sex;
    private String phone;
    private String email;
    private String address;
    private boolean isDelete;

    public Person() {
    }

    public Person(String name, String iDCitizen, Date birthday, boolean sex, String phone, String email, String address) {
        this.name = name;
        this.idCitizen = iDCitizen;
        this.birthday = birthday;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(String idCitizen) {
        this.idCitizen = idCitizen;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public abstract String getInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "name='" + name +
                "', iDCitizen='" + idCitizen +
                "', birthday='" + birthday +
                "', sex=" + (sex ? "'Nam'" : "'Nữ'") +
                "', phone='" + phone +
                "', email='" + email +
                "', address='" + address + '\'';
    }
}
