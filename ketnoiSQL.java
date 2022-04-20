/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ketnoiSQL {
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_SALON_TOC_NAM;user=sa;password=sa");
            return conn;
    }
    public static void closeConnection(Connection conn) throws SQLException
    {
        if(conn != null)
            conn.close();
    }
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException
    {
        if(preparedStatement !=null)
            preparedStatement.close();
    }
    public static void closeCallableStatement(CallableStatement callableStatement) throws SQLException
    {
        if(callableStatement !=null)
            callableStatement.close();
    }
}
