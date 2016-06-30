/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.config;

/**
 *
 * @author Lani
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class Koneksi {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = getDataSource().getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("root");
        ds.setPassword("admin");
        ds.setUrl("jdbc:mysql://localhost:3306/sipmi");
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        return ds;
    }

}
