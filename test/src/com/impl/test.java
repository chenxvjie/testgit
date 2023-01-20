package com.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try {

            // 获取连接
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");

            Statement statement = connection.createStatement();

            // 建表
            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer , name text)");

            // 插入数据
            statement.executeUpdate("insert into person(id, name) values(1, '刘备')");
            statement.executeUpdate("insert into person(id, name) values(2, '关羽')");
            statement.executeUpdate("insert into person(id, name) values(3, '张飞')");

            // 更新数据
            statement.executeUpdate("update person set name='诸葛亮' where id = 2");

            // 删除数据
            statement.executeUpdate("delete from person where id = 3");


            // 批处理
            String  sql = "insert into person(id, name) values(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            // 查询数据
            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if( connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

