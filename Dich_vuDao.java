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
public class Dich_vuDao {
    public static List<Dich_vu> findAll() throws ClassNotFoundException, SQLException {
        List<Dich_vu> dichvuList = new ArrayList<>();
        
        
        
          Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Dich_vu";
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                Dich_vu dv = new Dich_vu();
                dv.setMadv(resultSet.getString("ma_dv"));
                dv.setTendv(resultSet.getString("ten_dv"));
                dv.setGia(resultSet.getInt("gia"));
                
                dichvuList.add(dv);
                
            }
        
        return dichvuList;
    }
    public boolean insert(Dich_vu dv) throws ClassNotFoundException, SQLException{
         Connection conn= ketnoiSQL.getConnection();
            String query = "insert into Dich_vu(ma_dv, ten_dv, gia) values(?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, dv.getMadv());
                st.setString(2, dv.getTendv());
                st.setInt(3, dv.getGia());
                
                ketnoiSQL.closePreparedStatement(st);
                ketnoiSQL.closeConnection(conn);
                return st.executeUpdate() > 0;
    }
    
    public Dich_vu findID(String maDV) throws ClassNotFoundException, SQLException{
         Connection conn= ketnoiSQL.getConnection();
            String query = "select * from Dich_vu where ma_dv=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, maDV);
            ResultSet rs = st.executeQuery();
             
             if (rs.next()){
                Dich_vu dv = new Dich_vu();
                dv.setMadv(rs.getString("ma_dv"));
                dv.setTendv(rs.getString("ten_dv"));
                dv.setGia(rs.getInt("gia"));
                
                return dv;
             }
             
              ketnoiSQL.closePreparedStatement(st);
              ketnoiSQL.closeConnection(conn);
                
        return null;
    }
    
    public boolean update(Dich_vu dv) throws ClassNotFoundException, SQLException{
        Connection conn= ketnoiSQL.getConnection();
            String query = "update Dich_vu set ten_dv = ?, gia = ? " 
                            + " where ma_dv = ?";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(3, dv.getMadv());
                st.setString(1, dv.getTendv());
                st.setInt(2, dv.getGia());
                
                ketnoiSQL.closePreparedStatement(st);
                ketnoiSQL.closeConnection(conn);
                
                return st.executeUpdate() > 0;
                 
    }
    
    public boolean delete(String madv) throws ClassNotFoundException, SQLException{
         Connection conn= ketnoiSQL.getConnection();
            String query = "delete Dich_vu " 
                            + " where ma_dv = ?";
            PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, madv);
                
                 ketnoiSQL.closePreparedStatement(st);
                ketnoiSQL.closeConnection(conn);
                
                return st.executeUpdate() > 0;
    }
}
