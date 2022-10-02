package com.view;
import java.util.Scanner;
import com.config.ConnectDB;

public class barang {
    public static Scanner input = new Scanner(System.in);

    public static void barangRead(){
        System.out.println("\n::: DATA :::");
        System.out.println(ConnectDB.getTableBarang());
    }
    public static void tambahDataBarang(){

        System.out.println("\n::: TAMBAH DATA BARANG :::");
        System.out.print("Masukkan Nama Barang : ");
        String nama_barang = input.nextLine();
        System.out.print("Masukkan Stok : ");
        int stok = input.nextInt();
        input.nextLine();

        if ( ConnectDB.tambahDataBarang(nama_barang, stok ) ){
        System.out.println("Data Barang berhasil ditambahkan!!");
        barang.barangRead();
        }else{
        System.out.println("Data Barang gagal ditambahkan!!");
        }

    }
    public static void updateDataBarang(){
        System.out.println("\n::: UPDATE DATA BARANG :::");
        System.out.print("Masukkan Id Barang : ");
        int id_barang = input.nextInt();
        System.out.println("\nGanti Data Barang\n");
        System.out.print("Nama Barang (Kosongkan jika tidak ingin mengganti datanya) : ");
        String nama_barang = input.nextLine();
        nama_barang = input.nextLine();
        
        System.out.print("Stok (isi 0 jika tidak ingin merubah data) : ");
        int stok = input.nextInt();

        if( ConnectDB.updateDataBarang(id_barang, nama_barang, stok) ){
        System.out.println("Data barang berhasil dirubah!!");
        barangRead();
        }else{
        System.out.println("Data barang gagal dirubah!!");
        }
    }
    public static void deleteDataBarang(){
        System.out.println("\n:::DELETE DATA BARANG :::");
        System.out.print("Masukkan Id Barang : ");
        int id_barang = input.nextInt();

        if( ConnectDB.deleteDataBarang(id_barang) ){
        System.out.println("Data barang Berhasil Dihapus!!");
        barangRead();
        }else{
        System.out.println("Data barang Gagal Dihapus!!");
        }
    }
}
