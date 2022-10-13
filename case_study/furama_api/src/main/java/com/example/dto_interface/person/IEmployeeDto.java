package com.example.dto_interface.person;

import java.util.Date;

public interface IEmployeeDto {
    int getId();
    String getName();
    Date getBirthday();
    String getPosition();
    String getAddress();
    boolean isSex();
    String getIdCitizen();
}
