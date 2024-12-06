package com.example.QLKS.Model.Entity;
import java.math.BigDecimal;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Hotel {
    private Integer hotelId;
    private String hotelName;
    private String hotelImage;
    private Integer hotelPriceOld;
    private Integer hotelPriceCurrent;
    private String hotelCity;
    private String hotelAddress;
    private BigDecimal hotelRate;
    private String hotelAddressDetail;
    private String hotelIntroduce;
    private String hotelUtilities;
    private String hotelNearTheArea;
    private String hotelImageList;
    private Boolean hotelIsDelete;
    private java.sql.Timestamp hotelUpdatedAt;
}
