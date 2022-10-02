package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectDB {
  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost/invkaryawan";
  private static final String USER = "root";
  private static final String PASS = "";
  private static Connection connect;
  private static Statement statement;
  private static ResultSet resultData;

  public static void connection()
  {
    // method untuk melakukan koneksi ke database
    try {
      // registrasi driver yang akan dipakai
      Class.forName(JDBC_DRIVER);

      // buat koneksi ke database
      connect = DriverManager.getConnection(DB_URL, USER, PASS);

      System.out.println("Koneksi berhasil");

    } catch (Exception e) {
      // kalo ada error saat koneksi
      // maka tampilkan errornya
      e.printStackTrace();
    }

  }

  public static String getTableKaryawan()
  {
    ConnectDB.connection();
    String data = "Maaf data tidak ada";

    try {
      statement = connect.createStatement();
      String query = "SELECT id_karyawan, nama_karyawan, jabatan, no_tlp, email FROM karyawan";
      resultData = statement.executeQuery(query);

      data = "";

      while( resultData.next() ){
        data += "NIK : " + resultData.getInt("id_karyawan") 
        + ", Nama : " + resultData.getString("nama_karyawan") 
        + ", Jabatan : " + resultData.getString("jabatan") 
        + ", No. Tlp : " + resultData.getInt("no_tlp") 
        + ", Email : " + resultData.getString("email") 
        + "\n";
      }
      
      statement.close();
      connect.close();


    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;

  }

  public static boolean tambahDataKaryawan( String nama_karyawan, String jabatan, String email, int no_tlp )
  {
    ConnectDB.connection();
    boolean data = false;

    try {

      statement = connect.createStatement();

      // String query = "INSERT INTO karyawan VALUES ("+ null + ",'" + nama_karyawan + "','" + jabatan + "'," + no_tlp  + ",'" + email + "')";
      String query = "INSERT INTO karyawan VALUES (" + null + ", '" + nama_karyawan + "', '" + jabatan + "', '" + email + "', " + no_tlp + ")";

      if( !statement.execute(query) ){
        data = true;
      }
      statement.close();
      connect.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean updateDataKaryawan( int id_karyawan, String nama_karyawan, String jabatan, String email, int no_tlp )
  {
    connection();
    boolean data = false;

    try {
      
      statement = connect.createStatement();

      String queryCek = "SELECT * FROM karyawan WHERE id_karyawan = " + id_karyawan;

      resultData = statement.executeQuery(queryCek);
      String namaCek = "", jabatanCek="", emailCek="";
      int notlpCek = 0;

      while( resultData.next() ){
        namaCek = resultData.getString("nama_karyawan");
        jabatanCek = resultData.getString("jabatan");
        emailCek = resultData.getString("email");
        notlpCek = resultData.getInt("no_tlp");
      }

      if( !nama_karyawan.equalsIgnoreCase("") ){
        namaCek = nama_karyawan;
      }
      if( !jabatan.equalsIgnoreCase("") ){
        jabatanCek = jabatan;
      }
      if( !email.equalsIgnoreCase("") ){
        emailCek = email;
      }
      if( no_tlp != 0 ){
        notlpCek = no_tlp;
      }

      String queryUpdate = "UPDATE karyawan SET nama_karyawan = '" + namaCek + "', jabatan = '" + jabatanCek +  "', email = '" + emailCek +"', no_tlp = " + notlpCek + " WHERE id_karyawan = " + id_karyawan ;
      
      if( !statement.execute(queryUpdate) ){
        data = true;
      }
      statement.close();
      connect.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean deleteDataKaryawan( int id_karyawan )
  {
    connection();
    boolean data = false;

    try {
      
      statement = connect.createStatement();

      String query = "DELETE FROM karyawan WHERE id_karyawan = " + id_karyawan;

      if( !statement.execute(query) ){
        data = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static String getTableBarang()
  {
    ConnectDB.connection();
    String data = "Maaf data tidak ada";

    try {
      statement = connect.createStatement();
      String query = "SELECT id_barang, nama_barang, stok FROM barang";
      resultData = statement.executeQuery(query);

      data = "";

      while( resultData.next() ){
        data += "ID Barang : " + resultData.getInt("id_barang") 
        + ", Nama Barang : " + resultData.getString("nama_barang") 
        + ", Stok : " + resultData.getInt("stok")
        + "\n";
      }
      
      statement.close();
      connect.close();


    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;

}

  public static boolean tambahDataBarang( String nama_barang, int stok )
  {
    ConnectDB.connection();
    boolean data = false;

    try {

      statement = connect.createStatement();

      String query = "INSERT INTO barang VALUES (" + null + ", '" + nama_barang + "', " + stok + ")";

      if( !statement.execute(query) ){
        data = true;
      }
      statement.close();
      connect.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean updateDataBarang( int id_barang, String nama_barang, int stok )
  {
    connection();
    boolean data = false;

    try {
      
      statement = connect.createStatement();

      String queryCek = "SELECT * FROM barang WHERE id_barang = " + id_barang;

      resultData = statement.executeQuery(queryCek);
      String namabarangCek = "";
      int stokCek = 0;

      while( resultData.next() ){
        namabarangCek = resultData.getString("nama_barang");
        stokCek = resultData.getInt("stok");
      }

      if( !nama_barang.equalsIgnoreCase("") ){
        namabarangCek = nama_barang;
      }
      if( stok != 0 ){
        stokCek = stok;
      }

      String queryUpdate = "UPDATE barang SET nama_barang = '" + namabarangCek + "', stok = " + stokCek + " WHERE id_barang = " + id_barang ;
      
      if( !statement.execute(queryUpdate) ){
        data = true;
      }
      statement.close();
      connect.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static boolean deleteDataBarang( int id_barang )
  {
    connection();
    boolean data = false;

    try {
      
      statement = connect.createStatement();

      String query = "DELETE FROM barang WHERE id_barang = " + id_barang;

      if( !statement.execute(query) ){
        data = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;
  }

  public static String getTablePeminjaman()
  {
    ConnectDB.connection();
    String data = "Maaf data tidak ada";

    try {
      statement = connect.createStatement();
      String query = "SELECT peminjaman.id_peminjaman, karyawan.nama_karyawan, barang.nama_barang FROM ((peminjaman INNER JOIN karyawan ON peminjaman.id_karyawan=karyawan.id_karyawan) INNER JOIN barang ON peminjaman.id_barang=barang.id_barang);";
      resultData = statement.executeQuery(query);

      data = "";

      while( resultData.next() ){
        data += "Id Peminjaman : " + resultData.getInt("id_peminjaman") 
        + ", Nama Karyawan : " + resultData.getString("nama_karyawan") 
        + ", Nama Barang : " + resultData.getString("nama_barang") 
        + "\n";
      }
      
      statement.close();
      connect.close();


    } catch (Exception e) {
      e.printStackTrace();
    }

    return data;

  }

}