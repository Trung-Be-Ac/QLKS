package com.example.QLKS.Model.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    int user_id;
    String user_name;
    String user_password;
    String user_fullName;
    String user_cccd;
    String user_phoneNumber;
    String user_gmail;
    String user_idSocial;
    String user_avatar;
    Long user_createdAt;
    Long user_updatedAt;
    Boolean user_isDelete;
    String user_role;
    String user_userName;
    String user_passWord;
}
