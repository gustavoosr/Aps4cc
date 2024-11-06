/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import javax.swing.JOptionPane;

public class DAO {
    private static Connection con;
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://127.0.0.1:3306/aps_4cc?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static String user ="root";
    private static String senha ="sucodeuva12";
    
    public static Connection conectar(){
            try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, senha);
            return con;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
        }
    }
    public static void fecharConexao(DAO con, PreparedStatement stmt, ResultSet rs){
        fecharConexao(con, stmt, rs);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
