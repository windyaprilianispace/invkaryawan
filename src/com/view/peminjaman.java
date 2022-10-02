package com.view;
import java.util.Scanner;
import com.config.ConnectDB;

public class peminjaman {
    public static Scanner input = new Scanner(System.in);
    public static void peminjamanRead(){
        System.out.println("\n::: DATA :::");
        System.out.println(ConnectDB.getTablePeminjaman());
    }
}
