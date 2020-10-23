package com.sda.blackStorck.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class LoanDto {

    private BigInteger amount;
    private int length;
    private final int interest = 10;
    private Date date;
}
