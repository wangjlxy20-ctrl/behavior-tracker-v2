package com.tracker.service;
import com.tracker.dao.imple.b_Tracker_Dao;
import com.tracker.dao.imple.b_Tracker_Dao_Imple;
import com.tracker.pojo.Type;
import com.tracker.pojo.my_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class b_Tracker_ServiceImple implements b_Tracker_Service{
    b_Tracker_Dao bTrackerDao = new b_Tracker_Dao_Imple();
    List<Type> list = new ArrayList<>();
    int result = 0;
    @Override
    public int register(String account, String password, String password_Verification) {
        if( !(bTrackerDao.password_verification(password,password_Verification)) ){
            result = -1;//The two entered passwords are inconsistent.---invalid.
        } else if (bTrackerDao.isUsernameExist(account)) {
            result = -2;//the username existed;
        }else if(bTrackerDao.register(account,password) > 0){
            return 1;
        }
        return result;
    }

    @Override
    public int login(String username, String password) {
        if(bTrackerDao.login(username,password)){
            result = 1;
        }else if( !(bTrackerDao.isUsernameExist(username)) ){
            result = -1;
        } else{
            result = -2;
        }
        return result;
    }

    @Override
    public int insertRecord(int userId, String type, int value) {
        if(bTrackerDao.insertRecord(userId,type,value) > 0){
            result = 1;
        }else {
            result = -1;
        }
        return result;
    }

    @Override
    public my_users getUserByUsername(String username) {
        return bTrackerDao.getUserByUsername(username);
    }

    @Override
    public void showRecordByType(int user_id, String type) {
        int count = bTrackerDao.showRecordByType(user_id,type);
        if(count >= 0){
            if(type.equals("study")){
                System.out.println("You have studied for a total of " + count + " min");
            } else if (type.equals("smoke")) {
                System.out.println("You have smoked a total of " + count + " cigarettes");
            } else if (type.equals("sleep")) {
                System.out.println("You have sleep a total of " + count + " min");
            } else {
                System.out.println("!!Type Error!!");
            }
        }else {
            System.out.println("404 NOT FOUND");
        }
    }

    @Override
    public List<Type> getAllRecords(int user_id) {
        list = bTrackerDao.getAllRecords(user_id);
        return list;
    }

    @Override
    public int deleteTypeByUserId(int id) {
        if(bTrackerDao.deleteTypeById(id) > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int updateTypeIntensity(int id, String type, int value) {
        if(bTrackerDao.updateTypeIntensity(id,type,value) > 0){
            return 1;
        }
        return 0;
    }
}
