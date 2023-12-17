/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tagihan.dan.pulsa;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ROG STRIX
 */
public class Insert {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        String DB_URL = "jdbc:mysql://localhost:3306/pulsa_dan_tagihan";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";
        
        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        
        try{
            Connection conn =  dataSource.getConnection();
            String queryInsert = "INSERT into pulsa (id_transaksi, nominal_pulsa, jumlah_pembayaran) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(queryInsert);
            ps.setInt(1, 1);
            ps.setInt(2, 10000);
            ps.setString(3, "12.500");
            int rowAffected = ps.executeUpdate();
            if(rowAffected>0) {
                System.out.println("Insert data berhasil");
            }
            ps.close(); 
            conn.close();
        }catch (SQLException ex){
            System.out.println("Eksepsi Data : " + ex.getMessage());
        }
    }
}
