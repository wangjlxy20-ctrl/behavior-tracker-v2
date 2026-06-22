package com.tracker.dao.imple;

import com.tracker.jdbc_util.*;
import com.tracker.pojo.Type;
import com.tracker.pojo.my_users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class b_Tracker_Dao_Imple implements b_Tracker_Dao{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int result = 0;
    @Override
    public int register(String account,String password) {
        int result = 0;
        try {
            connection = jdbc_util.getConn();
            String sql = "insert into my_users values(default,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            result = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                jdbc_util.close_all(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    @Override
    public boolean isUsernameExist(String username) {
        try {
            connection = jdbc_util.getConn();
            String sql = "select users_name from my_users where users_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();//have next --> username existed
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                jdbc_util.close_all(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean password_verification(String password, String password_verification) {
        return password.equals(password_verification);
    }

    @Override
    public boolean login(String username, String password) {
        try {
            connection = jdbc_util.getConn();
            String sql = "select * from my_users where users_name = ? and pass_word = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();//have next --> username existed --> valid
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                jdbc_util.close_all(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public my_users getUserByUsername(String username) {

        try {
            connection = jdbc_util.getConn();

            String sql =
                    "select * from my_users where users_name = ?";

            preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                my_users user = new my_users();

                user.setUser_id(resultSet.getInt("id"));
                user.setUsername(
                        resultSet.getString("users_name"));

                user.setPassword(
                        resultSet.getString("pass_word"));

                return user;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public int insertRecord(int userID, String type, int value) {
        try {
            connection = jdbc_util.getConn();
            String sql = "insert into user_record values(default,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userID);
            preparedStatement.setString(2,type);
            preparedStatement.setInt(3,value);
            preparedStatement.setTimestamp(4,new java.sql.Timestamp(new Date().getTime()));
            return result = preparedStatement.executeUpdate();//return the affected raws;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                jdbc_util.close_all(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public int showRecordByType(int user_id, String type) {
        try {
            connection = jdbc_util.getConn();
            String sql = "select sum(value) from user_record where user_id = ? and type = ? and date(create_time)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            preparedStatement.setString(2,type);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                jdbc_util.close_all(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return 0;
    }

    @Override
    public List<Type> getAllRecords(int userId) {
        List<Type> list = new ArrayList<>();
        try {

            connection = jdbc_util.getConn();
            String sql = "select * from user_record where user_id = ? order by create_time desc";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Type type = new Type();
                type.setId(resultSet.getInt("id"));
                type.setUser_id(resultSet.getInt("user_id"));
                type.setType(resultSet.getString("type"));
                type.setValue(resultSet.getInt("value"));
                type.setCreate_time(resultSet.getTimestamp("create_time"));
                list.add(type);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                jdbc_util.close_all(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    @Override
    public int deleteTypeById(int type_id) {
        try {
            connection = jdbc_util.getConn();
            String sql = "delete from user_record where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,type_id);
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException("Dao:delete failed!",e);
        }

    }

    @Override
    public int updateTypeIntensity(int id,String type, int value) {
        try {
            connection = jdbc_util.getConn();
            String sql = "update user_record set type = ?,value = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,type);
            preparedStatement.setInt(2,value);
            preparedStatement.setInt(3,id);
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException("dao:delete failed",e);
        }
    }


}
