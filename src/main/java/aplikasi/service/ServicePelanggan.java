/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Pelanggan;
import aplikasi.repository.RepoPelanggan;
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
public class ServicePelanggan implements RepoPelanggan {

    private DataSource ds;

    public ServicePelanggan(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Pelanggan save(Pelanggan p) throws SQLException {
        String sql = "INSERT INTO pelanggan (kode, nama, alamat, notlp, agen)\n"
                + "VALUES (?,?,?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, p.getKode());
        ps.setString(2, p.getNama());
        ps.setString(3, p.getAlamat());
        ps.setString(4, p.getTlp());
        ps.setBoolean(5, p.getAgen());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return p;
    }

    @Override
    public Pelanggan update(Pelanggan p) throws SQLException {
        String sql = "UPDATE pelanggan SET nama = ?, alamat = ?, notlp = ?, agen = ? WHERE kode = ?";
        
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, p.getNama());
        ps.setString(2, p.getAlamat());
        ps.setString(3, p.getTlp());
        ps.setBoolean(4, p.getAgen());
        ps.setString(5, p.getKode());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return p;
    }

    @Override
    public List<Pelanggan> findAll() throws SQLException {
        String sql = "\n"
                + "SELECT \n"
                + "    p.kode as kode_pelanggan, \n"
                + "    p.nama as nama_pelanggan, \n"
                + "    p.alamat as alamat_pelanggan, \n"
                + "    p.notlp as no_telepone, \n"
                + "    p.agen as sebagai_agen\n"
                + "FROM pelanggan p";
        List<Pelanggan> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pelanggan p = new Pelanggan();
            p.setKode(rs.getString("kode_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setAlamat(rs.getString("alamat_pelanggan"));
            p.setAgen(rs.getBoolean("sebagai_agen"));
            p.setTlp(rs.getString("no_telephone"));
            list.add(p);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Pelanggan findOne(String id) throws SQLException {
        String sql = "\n"
                + "SELECT \n"
                + "    p.kode as kode_pelanggan, \n"
                + "    p.nama as nama_pelanggan, \n"
                + "    p.alamat as alamat_pelanggan, \n"
                + "    p.notlp as no_telepone, \n"
                + "    p.agen as sebagai_agen\n"
                + "FROM pelanggan p\n"
                + "WHERE p.kode = ?";
        List<Pelanggan> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Pelanggan p = null;
        while (rs.next()) {
            p = new Pelanggan();
            p.setKode(rs.getString("kode_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setAlamat(rs.getString("alamat_pelanggan"));
            p.setAgen(rs.getBoolean("sebagai_agen"));
            p.setTlp(rs.getString("no_telephone"));
            list.add(p);
        }
        ps.close();
        rs.close();
        connect.close();
        return p;
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        return findOne(id) != null;
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM pelanggan WHERE kode = ?";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

}
