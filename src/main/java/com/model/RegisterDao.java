package com.model;

import com.interfaces.IConnectionProvider;
import java.sql.*;
import java.util.Calendar;

public class RegisterDao implements IConnectionProvider {
    private static Connection con;

    public void loadDriver(String dbdriver){
        try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public int insert(UserInformation user){
        int status = 0;
        loadDriver(dbdriver);
        Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("insert into mysql.registerdata(NAME,EMAIL_ID,PASSWORD,RDATE) values(?,?,?,?) ");
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, String.valueOf(Calendar.getInstance().getTime()));
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return status;
    }
}