package com.tracker.service;
import com.tracker.pojo.*;

import java.util.List;

public interface b_Tracker_Service {
    int register(String account,String password,String password_Verification);
    int login(String username,String password);
    int insertRecord(int userId,String type,int value);
    my_users getUserByUsername(String username);


    void showRecordByType(int user_id,String type);

    List<Type> getAllRecords(int user_id);
    int deleteTypeByUserId(int id);
    int updateTypeIntensity(int id,String type,int value);
}
