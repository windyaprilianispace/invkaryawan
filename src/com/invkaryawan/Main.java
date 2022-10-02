package com.invkaryawan;
import java.util.Scanner;
import com.view.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){

            System.out.print("\n=== MENU ===\n"
            + "1. Karyawan.Read\n"
            + "2. Karyawan.Create\n"
            + "3. Karyawan.Update\n"
            + "4. Karyawan.Delete\n"
            + "5. Barang.Read\n"
            + "6. Barang.Create\n"
            + "7. Barang.Update\n"
            + "8. Barang.Delete\n"
            + "9. Pinjaman.Read\n"
            + "10. Pinjaman.Create\n"
            + "11. Pinjaman.Update\n"
            + "12. Pinjaman.Delete\n"
            + "0. Exit\n"
            + "Pilih[1/2/3/4/5/0] : ");

            String pilihan = input.next();

            if( pilihan.equalsIgnoreCase("0") ){
                System.out.println("Terimakasih!!");
                break;
            }


            switch (pilihan) {
                case "1" :
                    karyawan.karyawanRead();
                    break;
                case "2" :
                    karyawan.tambahDataKaryawan();
                    break;
                case "3" :
                    karyawan.updateDataKaryawan();
                    break;
                case "4" :
                    karyawan.deleteDataKaryawan();
                    break;
                case "5" :
                    barang.barangRead();
                    break;
                case "6" :
                    barang.tambahDataBarang();
                    break;
                case "7" :
                    barang.updateDataBarang();
                    break;
                case "8" :
                    barang.deleteDataBarang();
                    break;
                case "9" :
                    peminjaman.peminjamanRead();
                    break;
                case "10" :
                    karyawan.tambahDataKaryawan();
                    break;
                case "11" :
                    karyawan.updateDataKaryawan();
                    break;
                case "12" :
                    karyawan.deleteDataKaryawan();
                    break;
                default:
                    System.out.println("Pilihan salah!!");
                    break;
            }


        }    

        input.close();  
        
    }
}
