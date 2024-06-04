/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import connect.Connect;
import dao.*;
import dao.TaiKhoan_Dao;
import entity.*;
import entity.TaiKhoan;
import java.sql.SQLException;


public class App {

    public static void main(String[] args) {

        try {
            Connect.getInstance().connect();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        NhanVien_Dao nv_dao = new NhanVien_Dao();
        TaiKhoan_Dao tk_dao = new TaiKhoan_Dao();
        TaiKhoan tk = null;
        NhanVien nv = null;
       
    }
}
