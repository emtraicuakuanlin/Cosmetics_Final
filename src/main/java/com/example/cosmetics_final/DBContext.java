package com.example.cosmetics_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public Connection getConnection() {
        // --- THÔNG TIN ĐĂNG NHẬP (BẠN CHỈ CẦN SỬA Ở ĐÂY) ---
        String user = "sa";
        String password = "123456";  // <--- SỬA MẬT KHẨU CỦA BẠN VÀO ĐÂY
        String serverName = "localhost";
        String dbName = "CosmeticDB_Final";  // <--- Tên Database SQL của bạn
        String port = "1433";
        // ----------------------------------------------------

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + serverName + ":" + port +
                    ";databaseName=" + dbName +
                    ";encrypt=true;trustServerCertificate=true";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Lỗi: Thiếu thư viện SQL! (Xem lại pom.xml)");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Lỗi: Sai mật khẩu hoặc tên Database!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Hàm này để chạy thử xem kết nối được chưa
    public static void main(String[] args) {
        System.out.println("Đang kết nối thử...");
        if(new DBContext().getConnection() != null) {
            System.out.println("✅ CHÚC MỪNG! KẾT NỐI THÀNH CÔNG!");
        } else {
            System.out.println("❌ KẾT NỐI THẤT BẠI.");
        }
    }
}