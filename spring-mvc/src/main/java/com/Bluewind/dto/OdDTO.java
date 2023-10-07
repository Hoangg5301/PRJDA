package com.Bluewind.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OdDTO {
    private Integer id = 0;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date createdDate;
    private int status;
    private int accountId;
    private Integer discount;
}
