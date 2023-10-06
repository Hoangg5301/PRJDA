package com.Bluewind.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "od")
public class Od {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date createdDate;
    private int status;
    private int accountId;
    private Integer discount;

}
