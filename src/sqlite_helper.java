/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
/**
 *
 * @author Usuario
 */
public class sqlite_helper {
    
    File f = new File("src/RepasoRev.sqlite");
    String url = "jdbc:sqlite:";
    Connection connect;
    
    public boolean Connect(){
        try{
            connect = DriverManager.getConnection(url + f);
            if(connect != null){
                return true;                
            }return false;
        }catch(Exception x){
           JOptionPane.showMessageDialog(null, x.getMessage().toString());
           return false;
        }
    }
    
    public void Disconnect(){
        try{
            connect.close();
        }catch(Exception x){
           JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    public boolean ExQ(String sql){
        try{
            PreparedStatement st = connect.prepareStatement(sql);
            return st.execute();
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
            return false;
        }
    }
    
    public ResultSet Select(String sql, DefaultTableModel model){
        model.setRowCount(0);
        model.setRowCount(1);
        ResultSet result = null;
        
        try{
            PreparedStatement st = connect.prepareStatement(sql);
            result = st.executeQuery();
            return result;
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
            return result;
        }
    }
}
