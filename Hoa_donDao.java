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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Hoa_donDao {
    public static List<Hoa_don> findAll() throws ClassNotFoundException, SQLException {
        List<Hoa_don> hoadonList = new ArrayList<>();
        
       
             Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Hoa_don";
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                Hoa_don hd = new Hoa_don();
                hd.setMahd(resultSet.getString("ma_hd"));
                hd.setMakh(resultSet.getString("ma_kh"));
                hd.setManv(resultSet.getString("ma_nv"));
                hd.setMadv(resultSet.getString("ma_dv"));
                hd.setTongtien(resultSet.getFloat("tong_tien"));
                hd.setNgaythanhtoan(resultSet.getString("ngay_thanh_toan"));
                hd.setHinhthucthanhtoan(resultSet.getString("hinh_thuc_thanh_toan"));
               
                
                hoadonList.add(hd);
            }
        return hoadonList;
    }
    public boolean insert(Hoa_don hd) throws ClassNotFoundException, SQLException{
        
            Connection conn= ketnoiSQL.getConnection();
            String query = "insert into Hoa_don(ma_hd, ma_kh, ma_nv, ma_dv, tong_tien, ngay_thanh_toan, hinh_thuc_thanh_toan) values(?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, hd.getMahd());
                st.setString(2, hd.getMakh());
                st.setString(3, hd.getManv());
                st.setString(4, hd.getMadv());
                st.setFloat(5, hd.getTongtien());
                st.setString(6, hd.getNgaythanhtoan());
                st.setString(7, hd.getHinhthucthanhtoan());
//                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
                
                return st.executeUpdate() > 0;
    }
    
    public Hoa_don findID(String maHD) throws ClassNotFoundException, SQLException{
        
       
         Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Hoa_don where ma_hd=?";
            PreparedStatement  st = conn.prepareStatement(query);
            st.setString(1, maHD);
            ResultSet rs = st.executeQuery();
             
             if (rs.next()){
                Hoa_don hd = new Hoa_don();
                hd.setMahd(rs.getString("ma_hd"));
                hd.setMakh(rs.getString("ma_kh"));
                hd.setManv(rs.getString("ma_nv"));
                hd.setMadv(rs.getString("ma_dv"));
                hd.setTongtien(rs.getFloat("tong_tien"));
                hd.setNgaythanhtoan(rs.getString("ngay_thanh_toan"));
                hd.setHinhthucthanhtoan(rs.getString("hinh_thuc_thanh_toan"));
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
                
                return (hd);
             }
                
        return null;
    }
    public boolean update(Hoa_don hd) throws ClassNotFoundException, SQLException{
             Connection conn= ketnoiSQL.getConnection();
            String query = "update Hoa_don set ma_kh = ?, ma_nv = ?, ma_dv = ?, tong_tien = ?, ngay_thanh_toan=?, hinh_thuc_thanh_toan=? where ma_hd = ?";
             PreparedStatement st = conn.prepareStatement(query);
                st.setString(7, hd.getMahd());
                st.setString(1, hd.getMakh());
                st.setString(2, hd.getManv());
                st.setString(3, hd.getMadv());
                st.setFloat(4, hd.getTongtien());
                st.setString(5, hd.getNgaythanhtoan());
                st.setString(6, hd.getHinhthucthanhtoan());
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
//                
                return st.executeUpdate() > 0;
    }
     public boolean delete(String maHD) throws ClassNotFoundException, SQLException{
       Connection conn= ketnoiSQL.getConnection();
            String query = "delete Hoa_don  where ma_hd = ?";
             PreparedStatement  st = conn.prepareStatement(query);
                st.setString(1, maHD);
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
//                
                return st.executeUpdate() > 0;
    }
}
