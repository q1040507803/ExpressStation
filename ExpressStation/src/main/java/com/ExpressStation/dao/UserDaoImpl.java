package com.ExpressStation.dao;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;
import com.ExpressStation.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    @Override
    public ArrayList<User> getAllUser() {
            ArrayList<User> arr = new ArrayList<User>();

            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pre = null;
            ResultSet rs = null;

            String sql = "SELECT * FROM user WHERE role=1 ";
            try {
                pre = conn.prepareStatement(sql);
                rs = pre.executeQuery();

                while (rs.next()){
                    User user = new User();
                    user.setU_id(rs.getString("u_id"));
                    user.setName(rs.getString("name"));
                    user.setPwd(rs.getString("pwd"));
                    user.setPhone(rs.getString("phone"));
                    user.setRole(rs.getInt("role"));
                    arr.add(user);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return arr;


    }


    @Override
    public User getFileByNameOrId(String v) {                                          //根据用户名或id查询用户
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM user WHERE u_id='"+v+"' || name= '" + v+"'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()){
                User user = new User();
                user.setU_id(rs.getString("u_id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getInt("role"));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getAdmin(String id) {                                  //右上角信息
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
    public void delUser(String user) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql1 = "DELETE FROM user WHERE u_id="+user;
        try {
            pre = conn.prepareStatement(sql1);
            pre.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Express> getSelfExpress(User adminU) {
        ArrayList<Express> arr = new ArrayList<Express>();
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM express WHERE u_id='"+adminU.getU_id()+"'";
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
    public void upDateUser(String userId, String a, String b, String c) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE user SET name='"+a+"',pwd='"+b+"',phone='"+c+"' WHERE u_id='"+userId+"'";
            pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            System.out.println(sql);
        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }


}