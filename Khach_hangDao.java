/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Khach_hangDao {

    public static List<Khach_hang> findAll() throws ClassNotFoundException, SQLException {
        List<Khach_hang> khachhangList = new ArrayList<>();
        
       
             Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Khach_hang";
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                Khach_hang kh = new Khach_hang();
                kh.setMakh(resultSet.getString("ma_kh"));
                kh.setHoten(resultSet.getString("ho_ten"));
                kh.setSdt(resultSet.getInt("sdt"));
                kh.setNgaysinh(resultSet.getString("ngay_sinh"));
                kh.setDiachi(resultSet.getString("dia_chi"));
                
                khachhangList.add(kh);
            }
        return khachhangList;
    }
    public boolean insert(Khach_hang kh) throws ClassNotFoundException, SQLException{
        
            Connection conn= ketnoiSQL.getConnection();
            String query = "insert into Khach_hang(ma_kh, ho_ten, sdt, ngay_sinh, dia_chi) values(?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, kh.getMakh());
                st.setString(2, kh.getHoten());
                st.setInt(3, kh.getSdt());
                st.setString(4, kh.getNgaysinh());
                st.setString(5, kh.getDiachi());
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
//                
                return st.executeUpdate() > 0;
    }
    
    public Khach_hang findID(String maKH) throws ClassNotFoundException, SQLException{
        
       
         Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Khach_hang where ma_kh=?";
            PreparedStatement  st = conn.prepareStatement(query);
            st.setString(1, maKH);
            ResultSet rs = st.executeQuery();
             
             if (rs.next()){
                Khach_hang kh = new Khach_hang();
                kh.setMakh(rs.getString("ma_kh"));
                kh.setHoten(rs.getString("ho_ten"));
                kh.setSdt(rs.getInt("sdt"));
                kh.setNgaysinh(rs.getString("ngay_sinh"));
                kh.setDiachi(rs.getString("dia_chi"));
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
                
                return kh;
             }
                
        return null;
    }
    public boolean update(Khach_hang kh) throws ClassNotFoundException, SQLException{
             Connection conn= ketnoiSQL.getConnection();
            String query = "update Khach_hang set ho_ten = ?, sdt = ?, ngay_sinh = ?, dia_chi = ? where ma_kh = ?";
             PreparedStatement st = conn.prepareStatement(query);
                st.setString(5, kh.getMakh());
                st.setString(1, kh.getHoten());
                st.setInt(2, kh.getSdt());
                st.setString(3, kh.getNgaysinh());
                st.setString(4, kh.getDiachi());
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
//                
                return st.executeUpdate() > 0;
    }
     public boolean delete(String makh) throws ClassNotFoundException, SQLException{
       Connection conn= ketnoiSQL.getConnection();
            String sql="delete Hoa_don where ma_kh=?";
            String query = "delete Khach_hang  where ma_kh = ?";
             PreparedStatement  st = conn.prepareStatement(query);
                st.setString(1, makh);
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
                
                return st.executeUpdate() > 0;
    }
}
