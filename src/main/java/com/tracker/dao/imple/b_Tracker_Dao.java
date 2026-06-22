package com.tracker.dao.imple;
import com.tracker.pojo.Type;
import com.tracker.pojo.my_users;

import java.util.List;

public interface b_Tracker_Dao {
    int register(String account,String password);
    boolean isUsernameExist(String username);
    boolean password_verification(String password,String password_verification);
    boolean login(String username,String password);
    my_users getUserByUsername(String username);
    //Function model
    int insertRecord(int userID,String type,int value);
    int showRecordByType(int user_id,String type);
    List<Type> getAllRecords(int userId);
    int deleteTypeById(int type_id);
    int updateTypeIntensity(int id,String type,int value);
}
