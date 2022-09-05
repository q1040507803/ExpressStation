package com.ExpressStation.dao;

import com.ExpressStation.bean.User;
import com.ExpressStation.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao{
    @Override
    public User logindao(User u) {
        //Ð´Êý¾Ý¿â
        String id = u.getU_id();
        String pwd = u.getPwd();

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM user WHERE u_id='"+id+"' AND pwd= '"+pwd+"'";
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
                System.out.println(user);
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }
}
