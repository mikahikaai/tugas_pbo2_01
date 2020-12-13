package pengaturan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private final String USER = "root";
    private final String PASS = "";
    private final String URL = "jdbc:mysql://localhost/tugas_pbo2_1";

    public Connection getKoneksi() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return conn;
    }

}
