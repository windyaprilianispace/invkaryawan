package com.view;
import java.util.Scanner;
import com.config.ConnectDB;

public class karyawan {
    public static Scanner input = new Scanner(System.in);

    public static void karyawanRead(){
        System.out.println("\n::: DATA :::");
        System.out.println(ConnectDB.getTableKaryawan());
    }
    public static void tambahDataKaryawan(){

        System.out.println("\n::: TAMBAH DATA KARYAWAN :::");
        System.out.print("Masukkan Nama Karyawan : ");
        String nama_karyawan = input.nextLine();
        System.out.print("Masukkan Jabatan : ");
        String jabatan = input.nextLine();
        System.out.print("Masukkan Email : ");
        String email = input.nextLine();
        System.out.print("Masukkan No. Tlp : ");
        int no_tlp = input.nextInt();
        input.nextLine();

        if ( ConnectDB.tambahDataKaryawan(nama_karyawan, jabatan, email, no_tlp ) ){
        System.out.println("Data Barang berhasil ditambahkan!!");
        karyawan.karyawanRead();
        }else{
        System.out.println("Data Barang gagal ditambahkan!!");
        }

    }
    public static void updateDataKaryawan(){
        System.out.println("\n::: UPDATE DATA KARYAWAN :::");
        System.out.print("Masukkan NIK : ");
        int id_karyawan = input.nextInt();
        System.out.println("\nGanti Data Karyawan\n");
        System.out.print("Nama Karyawan (Kosongkan jika tidak ingin mengganti datanya) : ");
        String nama_karyawan = input.nextLine();
        nama_karyawan = input.nextLine();
        System.out.print("Jabatan (Kosongkan jika tidak ingin mengganti datanya) : ");
        String jabatan = input.nextLine();
        System.out.print("Email (Kosongkan jika tidak ingin mengganti datanya) : ");
        String email = input.nextLine();
        
        System.out.print("No. Tlp (isi 0 jika tidak ingin merubah data) : ");
        int no_tlp = input.nextInt();

        if( ConnectDB.updateDataKaryawan(id_karyawan, nama_karyawan, jabatan, email, no_tlp) ){
        System.out.println("Data karyawan berhasil dirubah!!");
        karyawanRead();
        }else{
        System.out.println("Data karyawan gagal dirubah!!");
        }
    }
    public static void deleteDataKaryawan(){
        System.out.println("\n:::DELETE DATA KARYAWAN :::");
        System.out.print("Masukkan NIK : ");
        int id_karyawan = input.nextInt();

        if( ConnectDB.deleteDataKaryawan(id_karyawan) ){
        System.out.println("Data Karyawan Berhasil Dihapus!!");
        karyawanRead();
        }else{
        System.out.println("Data Karyawan Gagal Dihapus!!");
        }
    }
}
