/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tagihan.dan.pulsa;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author ROG STRIX
 */
public class Koneksi {
    private MysqlDataSource dataSource = new MysqlDataSource();
    private String DB_URL = "jdbc:mysql://localhost:3306/pulsa_dan_tagihan";
    private String DB_USERNAME = "root";
    private String DB_PASSWORD = "";
    
    
        
    private Connection conn;
    
    public void connect(){
        try{
            dataSource.setUrl(DB_URL);
            dataSource.setUser(DB_USERNAME);
            dataSource.setPassword(DB_PASSWORD);
            conn = dataSource.getConnection();
            System.out.println("Koneksi Berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public Connection getConn(){
        return conn;
    }
}
