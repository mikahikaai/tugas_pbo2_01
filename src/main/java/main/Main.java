/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import model.Film;

public class Main {

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
                case 5 ->{
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
        film1.bacaData();
        System.out.println("Pilih nomor yang ingin diubah : ");
        film1.setId(sc.nextLine());
        System.out.println("Masukkan Judul Film Baru : ");
        film1.setNama(sc.nextLine());
        System.out.println("Masukkan Tahun Film Baru : ");
        film1.setTahun(sc.nextInt());
        sc.nextLine();
        System.out.println("Masukkan Direktur Film Baru : ");
        film1.setDirector(sc.nextLine());
        System.out.println("Masukkan Genre Film Baru : ");
        film1.setGenre(sc.nextLine());
        film1.updateData();
    }

    static void hapus() {
        film1.bacaData();
        System.out.println("Pilih nomor yang ingin dihapus : ");
        film1.setId(sc.nextLine());
        film1.deleteData();
    }
}
