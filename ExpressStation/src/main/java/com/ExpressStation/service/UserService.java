package com.ExpressStation.service;

import com.ExpressStation.bean.Express;
import com.ExpressStation.bean.User;

import java.util.ArrayList;

public interface UserService {

    User getAdmin(String id);       //��ȡ����Ա��Ϣ

    ArrayList<User> getAllUser();    //��ѯ�����û�

    User getFileByNameOrId(String v);   //ͨ�����ֻ�ID��ѯ�û�


    void delUser(String user);

    ArrayList<Express> getSelfExpress(User adminU);

    void upDateUser(String userId, String a, String b, String c);
}
