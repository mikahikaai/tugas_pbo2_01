package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pengaturan.Koneksi;

public class Film {

    private String nama;
    private int tahun;
    private String director;
    private String genre;
    private String id;
    private final Connection conn = new Koneksi().getKoneksi();
    public static ArrayList<Integer> posId = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Film() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void insertData() {
        try {
            String insertSql = "insert into film (nama, tahun, directur, genre) values (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(insertSql);
            pst.setString(1, this.nama);
            pst.setInt(2, this.tahun);
            pst.setString(3, this.director);
            pst.setString(4, this.genre);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.toString());;
        }
        System.out.println("Tambah data berhasil");
        System.out.println("");
    }

    public void readData() {
        try {
            String sql = "select * from film order by tahun asc";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            System.out.println("-------------------------------------------------------------------");
            System.out.println("No.\t|Judul\t\t|Tahun\t|Direktur\t\t|Genre");
            System.out.println("-------------------------------------------------------------------");
            int no = 1;            
            while (rs.next()) {
                System.out.println(no+"\t|"+rs.getString(2) + "\t\t|" + rs.getString(3)
                        + "\t|" + rs.getString(4) + "\t\t|" + rs.getString(5));
                posId.add(Integer.parseInt(rs.getString(1)));
                no++;
            }
            System.out.println("-------------------------------------------------------------------");
            System.out.println("");

        } catch (SQLException ex) {
            System.out.println(ex.toString());;
        }
    }

    public void updateData() {
        try {
            String updateSql = "update film set nama=?, tahun=?, directur=?, genre=? where id=?";
            PreparedStatement pst = conn.prepareStatement(updateSql);
            pst.setString(1, this.nama);
            pst.setInt(2, this.tahun);
            pst.setString(3, this.director);
            pst.setString(4, this.genre);
            pst.setString(5, this.id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.toString());;
        }
        System.out.println("Ubah data berhasil");
        System.out.println("");
    }

    public void deleteData() {
        try {
            String deleteSql = "delete from film where id=?";
            PreparedStatement pst = conn.prepareStatement(deleteSql);
            pst.setString(1, this.id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.toString());;
        }
        System.out.println("Hapus data berhasil");
        System.out.println("");
    }
}
