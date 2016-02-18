/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perpus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author KAHFI
 */
public class Connect {
    private Statement st = null;
    private Connection con =null;
    private ResultSet rs=null;

    public Connect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("sukses");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            con = DriverManager.getConnection("JDBC:mysql://localhost/perpustakaan","root","");
            st = con.createStatement();
            System.out.println("sukses");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void setQuery(String query){
        try {
            st.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //System.out.println(e.getMessage());
        }
    }
    
    public ResultSet getData(String query){
    ResultSet rs=null;
        try {
            rs=st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //System.out.println(e.getMessage());
        }
    return rs;
    }
    
    
}
