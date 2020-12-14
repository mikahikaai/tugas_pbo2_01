/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Film;
import pengaturan.Koneksi;

public class Main {
    
    static Connection conn = new Koneksi().getKoneksi();
    static Scanner sc = new Scanner(System.in);
    static Film film1 = new Film();
    
    public static void main(String[] args) {
        
        menu();
        
        int pos = sc.nextInt();
        sc.nextLine();
        while (pos >= 1 && pos <= 5) {
            switch (pos) {
                case 1 ->
                    tambah();
                case 2 ->
                    baca();
                case 3 ->
                    ubah();
                case 4 ->
                    hapus();
                case 5 -> {
                    System.out.println("Terima kasih");
                    System.exit(0);
                }
            }
            menu();
            pos = sc.nextInt();
            
        }
    }
    
    static void menu() {
        System.out.println("~~Menu Pilihan~~");
        System.out.println("-------------------");
        System.out.println("1. Tambah Data");
        System.out.println("2. Lihat Data");
        System.out.println("3. Ubah Data");
        System.out.println("4. Hapus Data");
        System.out.println("5. Keluar");
        System.out.println("");
        
        System.out.println("Masukkan pilihan anda : ");
    }
    
    static void tambah() {
        System.out.println("Masukkan Judul Film : ");
        film1.setNama(sc.nextLine());
        System.out.println("Masukkan Tahun Film : ");
        film1.setTahun(sc.nextInt());
        sc.nextLine();
        System.out.println("Masukkan Direktur Film : ");
        film1.setDirector(sc.nextLine());
        System.out.println("Masukkan Genre Film : ");
        film1.setGenre(sc.nextLine());
        film1.insertData();
    }
    
    static void baca() {
        film1.bacaData();
    }
    
    static void ubah() {
        try {
            film1.bacaData();
            System.out.println("Pilih nomor yang ingin diubah : ");
            film1.setId(String.valueOf(Film.posId.get(Integer.parseInt(sc.nextLine()) - 1)));
            String sql = "select * from film where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, film1.getId());
            ResultSet rs = pst.executeQuery();
            
            System.out.println("Masukkan Judul Film Baru : ");
            String judul = sc.nextLine();
            if (judul.equalsIgnoreCase("")) {
                film1.setNama(rs.getString(2));
            } else {
                film1.setNama(judul);
            }
            
            System.out.println("Masukkan Tahun Film Baru : ");
            String tahun = sc.nextLine();
            sc.nextLine();
            if (tahun.equalsIgnoreCase("")) {
                film1.setTahun(Integer.parseInt(rs.getString(3)));
            } else {
                film1.setTahun(Integer.parseInt(tahun));
            }
            
            System.out.println("Masukkan Direktur Film Baru : ");
            String director = sc.nextLine();
            if (director.equalsIgnoreCase("")) {
                film1.setDirector(rs.getString(4));
            } else {
                film1.setDirector(director);
            }
            
            System.out.println("Masukkan Genre Film Baru : ");
            String genre = sc.nextLine();
            if (genre.equalsIgnoreCase("")) {
                film1.setGenre(rs.getString(5));
            } else {
                film1.setGenre(genre);
            }
            film1.updateData();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    static void hapus() {
        film1.bacaData();
        System.out.println("Pilih nomor yang ingin dihapus : ");
        film1.setId(String.valueOf(Film.posId.get(Integer.parseInt(sc.nextLine()) - 1)));
        film1.deleteData();
    }
}
