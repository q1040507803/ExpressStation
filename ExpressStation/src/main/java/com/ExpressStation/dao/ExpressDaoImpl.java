package com.ExpressStation.dao;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;
import com.ExpressStation.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExpressDaoImpl implements ExpressDao{
    @Override
    public User getAdmin(String id) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM user WHERE u_id='"+id+"'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()){
                User user = new User();
                user.setU_id(rs.getString("u_id"));
                user.setName(rs.getString("name"));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Express> getAllExpress() {
        ArrayList<Express> arr = new ArrayList<Express>();

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM express";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()){
                Express express = new Express();
                express.setE_id(rs.getString("e_id"));
                express.setU_name(rs.getString("u_id"));
                express.setU_phone(rs.getString("u_phone"));
                express.setAddress(rs.getString("address"));
                express.setCode(rs.getString("code"));
                express.setStatus(rs.getString("status"));
                arr.add(express);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;

    }

    @Override
    public ArrayList<Express> getExpress(String v) {
        ArrayList<Express> arr = new ArrayList<Express>();
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM express WHERE e_id='"+v+"' || status='"+v+"'";
        System.out.println(sql);
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()){
                Express express = new Express();
                express.setE_id(rs.getString("e_id"));
                express.setU_name(rs.getString("u_id"));
                express.setU_phone(rs.getString("u_phone"));
                express.setAddress(rs.getString("address"));
                express.setCode(rs.getString("code"));
                express.setStatus(rs.getString("status"));
                arr.add(express);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;

    }

    @Override
    public void del(String express) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "DELETE FROM express WHERE e_id='"+express+"'";
        System.out.println(sql);
        try {
            pre = conn.prepareStatement(sql);
            pre.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void add(String a, String b, String c, String d, String e) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        //e_id u_id u_phone address code
        try {
            String sql = "INSERT INTO express VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','待取')";
            System.out.println(sql);
            pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            System.out.println(sql);
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void add2(String a, String admId, String b, String c) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO express VALUES('"+a+"','"+admId+"','"+b+"','"+c+"','0','待寄')";
            pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            System.out.println(sql);
        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }

    @Override
    public ArrayList<Express> getExpressByStatus(User adminU) {
        ArrayList<Express> arr = new ArrayList<Express>();
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM express WHERE u_id='"+adminU.getU_id()+"' AND status = '待寄'";//修改前查询
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()){
                Express express = new Express();
                express.setE_id(rs.getString("e_id"));
                express.setU_name(rs.getString("u_id"));
                express.setU_phone(rs.getString("u_phone"));
                express.setAddress(rs.getString("address"));
                express.setCode(rs.getString("code"));
                express.setStatus(rs.getString("status"));
                arr.add(express);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public void upDate(String a, String eId, String b, String c) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE express SET e_id='"+a+"',u_phone='"+b+"',address='"+c+"' WHERE e_id='"+eId+"'";
            pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            System.out.println(sql);
        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }
}
