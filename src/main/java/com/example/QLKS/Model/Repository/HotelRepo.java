package com.example.QLKS.Model.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.QLKS.Model.Entity.Hotel;

@Repository
public class HotelRepo {
    @Autowired
    static Hotel hotel = new Hotel();

    // ADD
    public static void AddHotel(Hotel hotel) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO `hotel` (\" +\n" + //
                        "        \"`hotel_name`, `hotel_image`, `hotel_priceOld`, `hotel_priceCurrent`, `hotel_city`, \" +\n"
                        + //
                        "        \"`hotel_address`, `hotel_rate`, `hotel_addressDetail`, `hotel_introduce`, \" +\n" + //
                        "        \"`hotel_utilities`, `hotel_nearTheArea`, `hotel_imageList`, \" +\n" + //
                        "        \") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        ps.setString(1, hotel.getHotelName());
        ps.setString(2, hotel.getHotelImage());
        ps.setDouble(3, hotel.getHotelPriceOld());
        ps.setDouble(4, hotel.getHotelPriceCurrent());
        ps.setString(5, hotel.getHotelCity());
        ps.setString(6, hotel.getHotelAddress());
        ps.setBigDecimal(7, hotel.getHotelRate());
        ps.setString(8, hotel.getHotelAddressDetail());
        ps.setString(9, hotel.getHotelIntroduce());
        ps.setString(10, hotel.getHotelUtilities());
        ps.setString(11, hotel.getHotelNearTheArea());
        ps.setString(12, hotel.getHotelImageList());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    // DELETE
    public static void DeleteHotelByID(int ID) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM `hotel` WHERE `hotel_id` = ?;");
        ps.setInt(1, ID);
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    // UPDATE
    public static void UpdateHotel(int hotelID, String hotelName, String hotelImage, double hotelPriceOld,
            double hotelPriceCurrent, String hotelCity, String hotelAddress,
            BigDecimal hotelRate, String hotelAddressDetail, String hotelIntroduce,
            String hotelUtilities, String hotelNearTheArea, String hotelImageList)
            throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement(
                "UPDATE `hotel` " +
                        "SET `hotel_name` = ?, `hotel_image` = ?, `hotel_priceOld` = ?, `hotel_priceCurrent` = ?, " +
                        "`hotel_city` = ?, `hotel_address` = ?, `hotel_rate` = ?, `hotel_addressDetail` = ?, " +
                        "`hotel_introduce` = ?, `hotel_utilities` = ?, `hotel_nearTheArea` = ?, `hotel_imageList` = ? "
                        +
                        "WHERE `hotel_id` = ?");
        ps.setString(1, hotelName);
        ps.setString(2, hotelImage);
        ps.setDouble(3, hotelPriceOld);
        ps.setDouble(4, hotelPriceCurrent);
        ps.setString(5, hotelCity);
        ps.setString(6, hotelAddress);
        ps.setBigDecimal(7, hotelRate);
        ps.setString(8, hotelAddressDetail);
        ps.setString(9, hotelIntroduce);
        ps.setString(10, hotelUtilities);
        ps.setString(11, hotelNearTheArea);
        ps.setString(12, hotelImageList);
        ps.setInt(13, hotelID);
        ps.executeUpdate();
        con.close();
        ps.close();
    }

    // VIEW ALL
    public ArrayList<Hotel> getAllHotels() throws Exception {
        ArrayList<Hotel> allHotels = new ArrayList<>();
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM `hotel`");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int hotelId = rs.getInt("hotel_id");
            String hotelName = rs.getString("hotel_name");
            String hotelImage = rs.getString("hotel_image");
            int hotelPriceOld = rs.getInt("hotel_priceOld");
            int hotelPriceCurrent = rs.getInt("hotel_priceCurrent");
            String hotelCity = rs.getString("hotel_city");
            String hotelAddress = rs.getString("hotel_address");
            BigDecimal hotelRate = rs.getBigDecimal("hotel_rate");
            String hotelAddressDetail = rs.getString("hotel_addressDetail");
            String hotelIntroduce = rs.getString("hotel_introduce");
            String hotelUtilities = rs.getString("hotel_utilities");
            String hotelNearTheArea = rs.getString("hotel_nearTheArea");
            String hotelImageList = rs.getString("hotel_imageList");
            boolean hotelIsDelete = rs.getBoolean("hotel_isDelete");
            Timestamp hotelUpdatedAt = rs.getTimestamp("hotel_updatedAt");
            Hotel hotel = new Hotel(hotelId, hotelName, hotelImage, hotelPriceOld, hotelPriceCurrent, hotelCity,
                    hotelAddress, hotelRate, hotelAddressDetail, hotelIntroduce, hotelUtilities,
                    hotelNearTheArea, hotelImageList, hotelIsDelete, hotelUpdatedAt);

            allHotels.add(hotel);
        }
        rs.close();
        ps.close();
        con.close();

        return allHotels;
    }

    // SEARCH BY NAME
    public static Hotel getHotelByName(String nameGet) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM `hotel` WHERE `hotel_name` = ?;");
        ps.setString(1, nameGet);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("hotel_id");
            String name = rs.getString("hotel_name");
            String image = rs.getString("hotel_image");
            int priceOld = rs.getInt("hotel_priceOld");
            int priceCurrent = rs.getInt("hotel_priceCurrent");
            String city = rs.getString("hotel_city");
            String address = rs.getString("hotel_address");
            BigDecimal rate = rs.getBigDecimal("hotel_rate");
            String addressDetail = rs.getString("hotel_addressDetail");
            String introduce = rs.getString("hotel_introduce");
            String utilities = rs.getString("hotel_utilities");
            String nearTheArea = rs.getString("hotel_nearTheArea");
            String imageList = rs.getString("hotel_imageList");
            boolean isDeleted = rs.getBoolean("hotel_isDelete");
            Timestamp updatedAt = rs.getTimestamp("hotel_updatedAt");

            hotel = new Hotel(id, name, image, priceOld, priceCurrent, city, address, rate, addressDetail,
                    introduce, utilities, nearTheArea, imageList, isDeleted, updatedAt);

        }
        rs.close();
        ps.close();
        con.close();
        return hotel;

    }

    // GET BY IDID
    public static Hotel getHotelByID(int hotelID) throws Exception {
        Class.forName(BaseConnection.nameClass);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("SELECT * FROM `hotel` WHERE `hotel_id` = ?");
        ps.setInt(1, hotelID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("hotel_id");
            String name = rs.getString("hotel_name");
            String image = rs.getString("hotel_image");
            int priceOld = rs.getInt("hotel_priceOld");
            int priceCurrent = rs.getInt("hotel_priceCurrent");
            String city = rs.getString("hotel_city");
            String address = rs.getString("hotel_address");
            BigDecimal rate = rs.getBigDecimal("hotel_rate");
            String addressDetail = rs.getString("hotel_addressDetail");
            String introduce = rs.getString("hotel_introduce");
            String utilities = rs.getString("hotel_utilities");
            String nearTheArea = rs.getString("hotel_nearTheArea");
            String imageList = rs.getString("hotel_imageList");
            boolean isDeleted = rs.getBoolean("hotel_isDelete");
            Timestamp updatedAt = rs.getTimestamp("hotel_updatedAt");
            hotel = new Hotel(id, name, image, priceOld, priceCurrent, city, address, rate, addressDetail,
                    introduce, utilities, nearTheArea, imageList, isDeleted, updatedAt);
        }
        rs.close();
        ps.close();
        con.close();
        return hotel;
    }

}
