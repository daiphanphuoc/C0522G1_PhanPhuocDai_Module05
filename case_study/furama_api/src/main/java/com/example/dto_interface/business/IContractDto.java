package com.example.dto_interface.business;

import java.util.Date;

public interface IContractDto {
    int getId();

    Date getStart();

    Date getEnd();

    double getDeposit();

    double getTotalMoney();

    String getFacility();

    String getEmployee();

    String getCustomer();
}
