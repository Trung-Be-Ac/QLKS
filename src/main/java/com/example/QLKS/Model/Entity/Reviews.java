package com.example.QLKS.Model.Entity;

import java.sql.Date;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Reviews {
    private Integer reviewsId;
    private Integer reviewsUserId;
    private Integer reviewsHotelId;
    private Integer reviewsRate;
    private String reviewsComment;
    private String reviewsImageReview;
    private Date reviewsCreatedAt;
    private Date reviewsUpdatedAt;
    private Boolean reviewsIsDelete;
}
