package com.example.QLKS.Model.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Listofbookedrooms {
    private Integer listId;
    private Integer listUserId;
    private Integer listHotelId;
    private Integer roomId;
}
