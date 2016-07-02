/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Pemasok;
import aplikasi.repository.RepoPemasok;
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
public class ServicePemasok implements RepoPemasok {

    private DataSource ds;

    public ServicePemasok(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Pemasok save(Pemasok p) throws SQLException {
        String sql = "INSERT INTO pemasok (nama, alamat, tlp) VALUES (?, ?, ?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, p.getNama());
        ps.setString(2, p.getAlamat());
        ps.setString(3, p.getTlp());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return p;
    }

    @Override
    public Pemasok update(Pemasok p) throws SQLException {
        String sql = "UPDATE pemasok SET nama = ?, alamat = ?, tlp = ? WHERE id = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, p.getNama());
        ps.setString(2, p.getAlamat());
        ps.setString(3, p.getTlp());
        ps.setInt(4, p.getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return p;
    }

    @Override
    public List<Pemasok> findAll() throws SQLException {
        String sql = "SELECT \n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as tlp_pemasok\n"
                + "FROM pemasok p";
        List<Pemasok> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pemasok p = new Pemasok();
            p.setId(rs.getInt("kode_pemasok"));
            p.setNama(rs.getString("nama_pemasok"));
            p.setAlamat(rs.getString("alamat_pemasok"));
            p.setTlp(rs.getString("tlp_pemasok"));
            list.add(p);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Pemasok findOne(Integer id) throws SQLException {
        String sql = "SELECT \n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as tlp_pemasok\n"
                + "FROM pemasok p\n"
                + "p.id = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Pemasok p = null;
        if (rs.next()) {
            p = new Pemasok();
            p.setId(rs.getInt("kode_pemasok"));
            p.setNama(rs.getString("nama_pemasok"));
            p.setAlamat(rs.getString("alamat_pemasok"));
            p.setTlp(rs.getString("tlp_pemasok"));
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
        String sql = "DELETE FROM pemasok WHERE id = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

}
