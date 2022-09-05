package com.ExpressStation.dao;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;

import java.util.ArrayList;

public interface UserDao {

    User getAdmin(String id);       //��ȡ����Ա�û�

    ArrayList<User> getAllUser();   //��ȡ�����û�

    User getFileByNameOrId(String v);   //�������ֻ�uid��ѯ�û�

    void delUser(String user);      //ɾ���û�

    ArrayList<Express> getSelfExpress(User adminU);    //�û���ѯ�Լ����

    void upDateUser(String userId, String a, String b, String c);   //�����û�
}
