/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perpus;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author KAHFI
 */
public class Buku {
    private int Kode,Harga;
    private String Judul,Penerbit,Status;

    public Buku(String Judul,String Penerbit, int Harga,String Status) {
        this.Harga = Harga;
        this.Judul = Judul;
        this.Penerbit = Penerbit;
        this.Status = Status;
    }

    public Buku() {
    }

    public int getKode() {
        return Kode;
    }

    public int getHarga() {
        return Harga;
    }

    public String getJudul() {
        return Judul;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public String getStatus() {
        return Status;
    }

    public void setKode(int Kode) {
        this.Kode = Kode;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public void insert(String Judul,String penerbit,int Harga){
        Connect c = new Connect();
        c.setQuery("insert into buku (Judul,Penerbit,Harga,Status) values('"+Judul+"','"+penerbit+"',"+Harga+",'Available');");
    }
    
    public void delete(String kode){
        Connect c = new Connect();
        c.setQuery("delete from buku where Kode='"+kode+"';");
    }
    
    public void update(String kode,String Judul,String penerbit,int Harga){
        Connect c = new Connect();
        c.setQuery("update buku set Judul='"+Judul+"',Penerbit='"+penerbit+"',Harga="+Harga+" where Kode='"+kode+"';");
    }
    
    public void pinjam(String kode){
        Connect c = new Connect();
        ResultSet rs = null;
        String stat="";
        try {
           rs=c.getData("select * from buku where Kode='"+kode+"';");
        while(rs.next()){
            stat=rs.getString("Status");
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if("Available".equals(stat)){
            stat="Dipinjam";
            c.setQuery("update buku set Status='"+stat+"';");
        }else{
            JOptionPane.showMessageDialog(null, "Buku tidak tersedia");
        }
    }
}
