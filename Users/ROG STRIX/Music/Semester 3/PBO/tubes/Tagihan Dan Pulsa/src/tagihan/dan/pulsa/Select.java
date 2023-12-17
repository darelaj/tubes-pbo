/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tagihan.dan.pulsa;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ROG STRIX
 */
public class Select {
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
            String querySelect = "SELECT id_pulsa, id_transaksi, nominal_pulsa, jumlah_pembayaran from pulsa";
            PreparedStatement ps1 = conn.prepareStatement(querySelect);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                int id_pulsa = rs.getInt("id_pulsa");
                int id_transaksi = rs.getInt("id_transaksi");
                int nominal = rs.getInt("nominal_pulsa");
                String jumlah = rs.getString("jumlah_pembayaran");
                System.out.println("Id : " + id_pulsa);
                System.out.println("Id Transaksi : " + id_transaksi);
                System.out.println("Nominal Pulsa : " + nominal);
                System.out.println("Jumlah Pembayaran : " + jumlah);
            }
            ps1.close(); 
            conn.close();
        }catch (SQLException ex){
            System.out.println("Eksepsi Data : " + ex.getMessage());
        }
    }
}
