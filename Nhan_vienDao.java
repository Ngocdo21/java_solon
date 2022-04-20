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
public class Nhan_vienDao {
    public static List<Nhan_vien> findAll() throws ClassNotFoundException, SQLException {
        List<Nhan_vien> nhanvienList = new ArrayList<>();
            Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Nhan_vien";
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                Nhan_vien nv = new Nhan_vien();
                nv.setManv(resultSet.getString("ma_nv"));
                nv.setHoten(resultSet.getString("ho_ten"));
                nv.setNgaysinh(resultSet.getString("ngay_sinh"));
                nv.setQuequan(resultSet.getString("que_quan"));
                nv.setGioitinh(resultSet.getString("gioi_tinh"));
                nv.setSocmt(resultSet.getInt("so_cmt"));
                nv.setSdt(resultSet.getInt("sdt"));
                nv.setChucvu(resultSet.getString("chuc_vu"));
                nv.setCalam(resultSet.getString("ca_lam"));
                nv.setLuong(resultSet.getInt("luong"));
                
                nhanvienList.add(nv);
            }
        
        return nhanvienList;
    }
    public boolean insert(Nhan_vien nv) throws ClassNotFoundException, SQLException{
        Connection conn= ketnoiSQL.getConnection();
            String query = "insert into Nhan_vien(ma_nv, ho_ten, ngay_sinh, que_quan, gioi_tinh, so_cmt, sdt, chuc_vu, ca_lam, luong) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, nv.getManv());
                st.setString(2, nv.getHoten());
                st.setString(3, nv.getNgaysinh());
                st.setString(4, nv.getQuequan());
                st.setString(5, nv.getGioitinh());
                st.setInt(6, nv.getSocmt());
                st.setInt(7, nv.getSdt());
                st.setString(8, nv.getChucvu());
                st.setString(9, nv.getCalam());
                st.setInt(10, nv.getLuong());
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
//                
                return st.executeUpdate() > 0;
    }
    
    public Nhan_vien findID(String maNV) throws ClassNotFoundException, SQLException{
       Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Nhan_vien where ma_nv=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, maNV);
            ResultSet rs = st.executeQuery();
             
             if (rs.next()){
                Nhan_vien nv = new Nhan_vien();
                nv.setManv(rs.getString("ma_nv"));
                nv.setHoten(rs.getString("ho_ten"));
                nv.setNgaysinh(rs.getString("ngay_sinh"));
                nv.setQuequan(rs.getString("que_quan"));
                nv.setGioitinh(rs.getString("gioi_tinh"));
                nv.setSocmt(rs.getInt("so_cmt"));
                nv.setSdt(rs.getInt("sdt"));
                nv.setChucvu(rs.getString("chuc_vu"));
                nv.setCalam(rs.getString("ca_lam"));
                nv.setLuong(rs.getInt("luong"));
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
                
                return nv;
             }
                
        return null;
    }
    public boolean update(Nhan_vien nv) throws ClassNotFoundException, SQLException{
        Connection conn= ketnoiSQL.getConnection();
            String query = "update Nhan_vien set ho_ten = ?, ngay_sinh = ?, que_quan = ?, gioi_tinh = ?, so_cmt = ?, sdt = ?, chuc_vu = ?, ca_lam = ?, luong = ?  " 
                            + " where ma_nv = ?";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(10, nv.getManv());
                st.setString(1, nv.getHoten());
                st.setString(2, nv.getNgaysinh());
                st.setString(3, nv.getQuequan());
                st.setString(4, nv.getGioitinh());
                st.setInt(5, nv.getSocmt());
                st.setInt(6, nv.getSdt());
                st.setString(7, nv.getChucvu());
                st.setString(8, nv.getCalam());
                st.setInt(9, nv.getLuong());
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
                
                return st.executeUpdate() > 0;
    }
     public boolean delete(String maNV) throws ClassNotFoundException, SQLException{
       Connection conn= ketnoiSQL.getConnection();
            String query = "delete Nhan_vien " 
                            + " where ma_nv = ?";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, maNV);
                
//                 ketnoiSQL.closePreparedStatement(st);
//                ketnoiSQL.closeConnection(conn);
                
                return st.executeUpdate() > 0;
    }
}
