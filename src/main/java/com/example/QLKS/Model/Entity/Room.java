package com.example.QLKS.Model.Entity;

import java.math.BigDecimal;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Room {
    private Integer roomId;
    private Integer roomHotelId;
    private String roomName;
    private BigDecimal roomPrice;
    private String roomImageList;
    private String roomUtilities;
    private Integer roomSizeRoom;
    private Integer roomUser;
    private String roomHeading;
    private Integer roomFloor;
    private Boolean roomShower;
    private Boolean roomTV;
    private Boolean roomPhone;
    private Boolean roomWater;
    private Boolean roomIsDelete;
    private Long roomUpdatedAt;
}
