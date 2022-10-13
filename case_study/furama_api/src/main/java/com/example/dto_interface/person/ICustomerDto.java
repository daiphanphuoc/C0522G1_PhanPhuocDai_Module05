package com.example.dto_interface.person;

import java.util.Date;

public interface ICustomerDto {
    int getId();

    String getName();

    Date getBirthday();

    String getCustomerType();

    String getAddress();

    boolean isSex();

    String getIdCitizen();
}
