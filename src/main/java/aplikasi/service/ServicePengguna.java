/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Pengguna;
import aplikasi.repository.RepoPengguna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author dimmaryanto
 */
public class ServicePengguna implements RepoPengguna {

    private final DataSource ds;

    public ServicePengguna(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Pengguna findByUsernameAndPasswordAndIsStatusEnabled(String username, String Password) throws SQLException {
        String sql = "SELECT u.id, u.username, u.password, u.nama, u.jabatan, u.status\n"
                + "FROM user u\n"
                + "WHERE u.username = ? AND u.password = ? AND u.status = ?";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, Password);
        ps.setBoolean(3, true);
        ResultSet rs = ps.executeQuery();
        Pengguna p = null;
        while (rs.next()) {
            p = new Pengguna();
            p.setId(rs.getInt("id"));
            p.setUsername(rs.getString("username"));
            p.setPassword(rs.getString("password"));
            p.setNama(rs.getString("nama"));
            p.setJabatan(rs.getString("jabatan"));
            p.setStatus(rs.getBoolean("status"));
        }

        ps.close();
        rs.close();
        connect.close();
        return p;
    }

    @Override
    public Pengguna save(Pengguna value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pengguna update(Pengguna value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pengguna> findAll() throws SQLException {
        String sql = "SELECT u.id, u.username, u.password, u.nama, u.jabatan, u.status\n"
                + "FROM user u";
        List<Pengguna> list = new ArrayList<>();
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pengguna p = new Pengguna();
            p.setId(rs.getInt("id"));
            p.setUsername(rs.getString("username"));
            p.setPassword(rs.getString("password"));
            p.setNama(rs.getString("nama"));
            p.setJabatan(rs.getString("jabatan"));
            p.setStatus(rs.getBoolean("status"));
            list.add(p);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Pengguna findOne(Integer id) throws SQLException {
        String sql = "SELECT u.id, u.username, u.password, u.nama, u.jabatan, u.status\n"
                + "FROM user u\n"
                + "WHERE u.id = ?";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Pengguna p = null;
        while (rs.next()) {
            p = new Pengguna();
            p.setId(rs.getInt("id"));
            p.setUsername(rs.getString("username"));
            p.setPassword(rs.getString("password"));
            p.setNama(rs.getString("nama"));
            p.setJabatan(rs.getString("jabatan"));
            p.setStatus(rs.getBoolean("status"));
        }

        ps.close();
        rs.close();
        connect.close();
        return p;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        return findOne(id) != null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        connect.close();
    }

    @Override
    public void updatePasswordByUsername(String username, String password) throws SQLException {
        String sql = "UPDATE `user` SET password = ? WHERE username = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, password);
        ps.setString(2, username);
        ps.executeUpdate();
        ps.close();
        connect.close();
    }

}
