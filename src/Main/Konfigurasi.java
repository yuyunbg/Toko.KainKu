/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;

public class Konfigurasi {
    private static Connection mysqlconfig;
    public static Connection konfigurasiDB()throws SQLDataException{
        try{
            String url="jdbc:mysql://localhost:3306/toko_kainku";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig=DriverManager.getConnection(url, user, pass);
         }
        catch (Exception e){
            System.err.println("koneksi gagal"+e.getMessage());
        }
        return mysqlconfig;
    }
    
}
