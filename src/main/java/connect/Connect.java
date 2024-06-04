/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection con = null;
    private static Connect instance = new Connect();

    public static Connect getInstance() {
        return instance;
    }

    public void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:56062;dataBaseName=QLBanHang3";
        String user = "sa";
        String password = "sapassword";
        con = DriverManager.getConnection(url, user, password);
    }

    public void disconnect() {
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
    }

    public static Connection getConnection() {
        return con;
    }
}
