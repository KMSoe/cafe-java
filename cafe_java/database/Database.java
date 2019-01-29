/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe_java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kaung Myat Soe
 */
public class Database {
    private String url="jdbc:mysql://localhost:3306/";
    private String user="root";
    private String pwd="";
    private Connection conn;
    private static Database db;
    
    private Database() throws SQLException{
        createConnection();
        createDatabase();
        createTables();
    }
    public static Database getInstance() throws SQLException{
        if(db==null){
            db=new Database();
        }
        return db;
    }
    private void createConnection() throws SQLException{
        conn=DriverManager.getConnection(url,user,pwd);
    }
    public Connection getConnection(){
        return conn;
    }
     public void createDatabase() throws SQLException{
        String sql="create database if not exists cafe";
        Statement stmt=conn.createStatement();
        stmt.executeUpdate(sql);
        String sql1="use cafe";
        stmt.executeUpdate(sql1);
    }
    public void createTables() throws SQLException{
        Statement stmt=conn.createStatement();
        String sql1="create table if not exists food(id int primary key auto_increment,name varchar(40),price double,numberRemain int)";
        String sql2="create table if not exists drink(id int primary key auto_increment,name varchar(40),price double,numberRemain int)";
        
        stmt.executeUpdate(sql1);
        stmt.executeUpdate(sql2);
    } 
}
