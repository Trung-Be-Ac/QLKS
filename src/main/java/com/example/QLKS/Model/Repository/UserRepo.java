package com.example.QLKS.Model.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.QLKS.Model.Entity.User;

public class UserRepo {
    // ADD USER
    public static void addUser(User user) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("INSERT INTO `user` \n" + //
                "(`user_fullName`, `user_cccd`, `user_phoneNumber`, `user_gmail`, `user_idSocial`, \n" + //
                " `user_avatar`, `user_createdAt`, `user_updatedAt`, `user_role`, `user_userName`, `user_passWord`) \n"
                + //
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        ps.setString(1, user.getUser_fullName());
        ps.setString(2, user.getUser_cccd());
        ps.setString(3, user.getUser_phoneNumber());
        ps.setString(4, user.getUser_gmail());
        ps.setString(5, user.getUser_idSocial());
        ps.setString(6, user.getUser_avatar());
        ps.setLong(7, user.getUser_createdAt());
        ps.setLong(8, user.getUser_updatedAt());
        ps.setString(9, user.getUser_role());
        ps.setString(10, user.getUser_userName());
        ps.setString(11, user.getUser_passWord());
        ps.executeUpdate();
        con.close();
        ps.close();
    }

    // UPDATE USER
    public static void updatUser(int user_id, String user_fullName, String user_cccd, String user_phoneNumber,
            String user_gmail, String user_idSocial, String user_avatar, Long user_createdAt, Long user_updatedAt,
            String user_role, String user_userName, String user_passWord) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("UPDATE `user` \n" +
                "SET \n" +
                "  `user_fullName` = ?, \n" +
                "  `user_cccd` = ?, \n" +
                "  `user_phoneNumber` = ?, \n" +
                "  `user_gmail` = ?, \n" +
                "  `user_idSocial` = ?, \n" +
                "  `user_avatar` = ?, \n" +
                "  `user_createdAt` = ?, \n" +
                "  `user_updatedAt` = ?, \n" +
                "  `user_role` = ?, \n" +
                "  `user_userName` = ?, \n" +
                "  `user_passWord` = ? \n" +
                "WHERE `user_id` = ?;");
        ps.setString(1, user_fullName);
        ps.setString(2, user_cccd);
        ps.setString(3, user_phoneNumber);
        ps.setString(4, user_gmail);
        ps.setString(5, user_idSocial);
        ps.setString(6, user_avatar);
        ps.setLong(7, user_createdAt);
        ps.setLong(8, user_updatedAt);
        ps.setString(9, user_role);
        ps.setString(10, user_userName);
        ps.setString(11, user_passWord);
        ps.setInt(12, user_id);
        ps.executeUpdate();
        con.close();
        ps.close();
    }
}
