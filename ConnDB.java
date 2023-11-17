package com.ManajemenPegawai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnDB {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123";

    private static Connection connection;

    // Fungsi untuk membuka koneksi ke database
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Fungsi untuk menutup koneksi ke database
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
