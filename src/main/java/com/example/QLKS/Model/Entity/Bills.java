package com.example.QLKS.Model.Entity;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Bills {
    private Integer billsId;
    private Integer billsUserId;
    private Integer billsHotelId;
    private String billsBillCode;
    private Integer billsRoomId;
    private BigDecimal billsPrice;
    private String billsName;
    private Date billsCheckInDate;
    private String billsPhoneNumber;
    private String billsCCCD;
    private String billsFullname;
    private Date billsCheckOutDate;
    private String billsPaymentMethod;
    private String billsPay;
    private Boolean billsIsDelete;
    private Date billsCreatedAt;
    private Date billsUpdatedAt;
}
