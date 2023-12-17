/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tagihan.dan.pulsa;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ROG STRIX
 */
public class Delete {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        String DB_URL = "jdbc:mysql://localhost:3306/pulsa_dan_tagihan";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";
        
        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        
        try{
            Connection conn =  dataSource.getConnection();
            String queryDelete = "DELETE FROM pulsa WHERE id_transaksi = ?";
            PreparedStatement ps2 = conn.prepareStatement(queryDelete);
            ps2.setInt(1, 1);
            int rowAffected1 = ps2.executeUpdate();
            if(rowAffected1>0) {
                System.out.println("Delete data berhasil");
            }
            ps2.close(); 
            conn.close();
        }catch (SQLException ex){
            System.out.println("Eksepsi Data : " + ex.getMessage());
        }
    }
}
