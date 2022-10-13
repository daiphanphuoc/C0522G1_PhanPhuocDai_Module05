package com.example.model.person;

import daiphan.casestudy.model.business.Contract;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;


    public Customer() {
    }

    @Override
    public String getInfo() {
        Date date = getBirthday();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString  = df.format(date);
        return String.format("%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s", getName(), getIdCitizen(),dateString,
                isSex(), getPhone(), getEmail(), getAddress(), id, customerType.getName());
    }

    public Customer(String name, String iDCitizen, Date birthday, boolean sex, String phone,
                    String email, String address, int id, CustomerType customerType,
                    Set<Contract> contracts) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.id = id;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

}
