package com.example.QLKS.Model.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.QLKS.Model.Entity.User;

@Repository
public class Login {
    @Autowired
    public static User CheckLogin(String UserName, String Password) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM `user` WHERE `user_userName` = ? AND `user_passWord` = ?");
        ps.setString(1, UserName);
        ps.setString(2, Password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int user_id = rs.getInt("`user_id`");
            String user_fullName = rs.getString("`user_fullName`");
            String user_cccd = rs.getString("`user_cccd`");
            String user_phoneNumber = rs.getString("`user_phoneNumber`");
            String user_gmail = rs.getString("`user_gmail`");
            String user_idSocial = rs.getString("`user_idSocial`");
            String user_avatar = rs.getString("`user_avatar`");
            Long user_createdAt = rs.getLong("`user_createdAt`");
            Long user_updatedAt = rs.getLong("`user_updatedAt`");
            Boolean user_isDelete = rs.getBoolean("`user_isDelete`");
            String user_role = rs.getString("`user_role`");
            User user = new User(user_id, user_fullName, user_cccd, user_phoneNumber, user_gmail, user_idSocial,
                    user_avatar, user_createdAt, user_updatedAt, user_isDelete, user_role);
            con.close();
            ps.close();
            rs.close();
            return user;
        }
        return null;
    }

}
