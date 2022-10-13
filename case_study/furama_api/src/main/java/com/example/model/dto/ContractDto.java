package com.example.model.dto;

import com.example.model.facility.Facility;
import com.example.model.person.Customer;
import com.example.model.person.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ContractDto {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;
    private double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;

    public ContractDto() {
    }

    public ContractDto(int id, Date start, Date end, double deposit, Customer customer, Employee employee, Facility facility) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.deposit = deposit;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
