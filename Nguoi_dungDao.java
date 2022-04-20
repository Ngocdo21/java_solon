/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class Nguoi_dungDao {
    public static List<Nguoi_dung> getAllND() throws ClassNotFoundException, SQLException
    {
        List<Nguoi_dung> lstNguoidung= new ArrayList<>();
        
            Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Nguoi_dung";
            Statement st = conn.createStatement();
            
            ResultSet resultSet = st.executeQuery(query);
            
            while(resultSet.next()){
                Nguoi_dung nd = new Nguoi_dung();
                nd.setId(resultSet.getInt("id"));
                nd.setTaikhoan(resultSet.getString("tai_khoan"));
                nd.setMatkhau(resultSet.getString("mat_khau"));
                
                lstNguoidung.add(nd);
            }
        
        return lstNguoidung;
    }
    public static List<Nguoi_dung> getOneND(String tk, String mk) throws ClassNotFoundException, SQLException
    {
        List<Nguoi_dung> lstNguoidung= new ArrayList<>();
        
            Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Nguoi_dung where tai_khoan = '"+tk+"' and mat_khau='"+mk+"'";
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                Nguoi_dung nd = new Nguoi_dung();
                nd.setId(resultSet.getInt("id"));
                nd.setTaikhoan(resultSet.getString("tai_khoan"));
                nd.setMatkhau(resultSet.getString("mat_khau"));
                
                lstNguoidung.add(nd);
            }
             
        return lstNguoidung;
    }
}
