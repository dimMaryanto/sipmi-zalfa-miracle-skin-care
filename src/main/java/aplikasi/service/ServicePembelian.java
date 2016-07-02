/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Pemasok;
import aplikasi.entity.Pembelian;
import aplikasi.repository.RepoPembelian;
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
public class ServicePembelian implements RepoPembelian {

    private final DataSource ds;

    public ServicePembelian(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Pembelian save(Pembelian b) throws SQLException {
        String sql = "INSERT INTO pembelian (kode, tgl, id_pemasok) VALUES (?, ?, ?)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, b.getKode());
        ps.setDate(2, b.getTgl());
        ps.setInt(3, b.getPemasok().getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return b;
    }

    @Override
    public Pembelian update(Pembelian b) throws SQLException {
        String sql = "UPDATE pembelian SET tgl = ?, id_pemasok = ? WHERE id = ?";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, b.getTgl());
        ps.setInt(2, b.getPemasok().getId());
        ps.setInt(3, b.getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return b;
    }

    @Override
    public List<Pembelian> findAll() throws SQLException {
        String sql = "SELECT \n"
                + "    b.id as id_pembelian, \n"
                + "    b.kode as kode_pembelian,\n"
                + "    b.tgl as tanggal_pembelian,\n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as telp_pemasok\n"
                + "FROM pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)";

        List<Pembelian> daftarPembelian = new ArrayList<>();
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pembelian b = new Pembelian();
            b.setId(rs.getInt("id_pembelian"));
            b.setKode(rs.getString("kode_pembelian"));
            b.setTgl(rs.getDate("tanggal_pembelian"));

            Pemasok p = new Pemasok();
            p.setId(rs.getInt("kode_pemasok"));
            p.setNama(rs.getString("nama_pemasok"));
            p.setAlamat(rs.getString("alamat_pemasok"));
            p.setTlp(rs.getString("telp_pemasok"));
            b.setPemasok(p);
            daftarPembelian.add(b);
        }

        ps.close();
        rs.close();
        connect.close();
        return daftarPembelian;
    }

    @Override
    public Pembelian findOne(Integer id) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id as id_pembelian, \n"
                + "    b.kode as kode_pembelian,\n"
                + "    b.tgl as tanggal_pembelian,\n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as telp_pemasok\n"
                + "FROM pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)\n"
                + "WHERE b.id = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Pembelian b = null;
        while (rs.next()) {
            b = new Pembelian();
            b.setId(rs.getInt("id_pembelian"));
            b.setKode(rs.getString("kode_pembelian"));
            b.setTgl(rs.getDate("tanggal_pembelian"));

            Pemasok p = new Pemasok();
            p.setId(rs.getInt("kode_pemasok"));
            p.setNama(rs.getString("nama_pemasok"));
            p.setAlamat(rs.getString("alamat_pemasok"));
            p.setTlp(rs.getString("telp_pemasok"));
            b.setPemasok(p);
        }

        ps.close();
        rs.close();
        connect.close();
        return b;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        return findOne(id) != null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM pembelian WHERE id = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

}
