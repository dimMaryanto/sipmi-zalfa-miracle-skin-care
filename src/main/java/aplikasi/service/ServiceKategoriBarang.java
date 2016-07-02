/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.KategoriBarang;
import aplikasi.repository.RepoKategoriBarang;
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
public class ServiceKategoriBarang implements RepoKategoriBarang {

    private DataSource ds;

    public ServiceKategoriBarang(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public KategoriBarang save(KategoriBarang value) throws SQLException {
        String sql = "INSERT INTO kategori_brg(kode, nama) VALUES (?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getKode());
        ps.setString(2, value.getNama());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public KategoriBarang update(KategoriBarang value) throws SQLException {
        String sql = "UPDATE kategori_brg SET kode = ?, nama = ? WHERE id = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getKode());
        ps.setString(2, value.getNama());
        ps.setInt(3, value.getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<KategoriBarang> findAll() throws SQLException {
        String sql = "SELECT * FROM kategori_brg";
        List<KategoriBarang> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            KategoriBarang kb = new KategoriBarang();
            kb.setId(rs.getInt("id"));
            kb.setKode(rs.getString("kode"));
            kb.setNama(rs.getString("nama"));
            list.add(kb);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public KategoriBarang findOne(Integer id) throws SQLException {
        String sql = "SELECT * FROM kategori_brg WHERE id = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        KategoriBarang kb = null;
        if (rs.next()) {
            kb = new KategoriBarang();
            kb.setId(rs.getInt("id"));
            kb.setKode(rs.getString("kode"));
            kb.setNama(rs.getString("nama"));
        }

        ps.close();
        rs.close();
        connect.close();
        return kb;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        return findOne(id) == null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM kategori_brg WHERE id = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public KategoriBarang findByKode(String kode) throws SQLException {
        String sql = "SELECT * FROM kategori_brg WHERE kode = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        KategoriBarang kb = null;
        if (rs.next()) {
            kb = new KategoriBarang();
            kb.setId(rs.getInt("id"));
            kb.setKode(rs.getString("kode"));
            kb.setNama(rs.getString("nama"));
        }

        ps.close();
        rs.close();
        connect.close();
        return kb;
    }

    @Override
    public Boolean existsByKode(String kode) throws SQLException {
        return findByKode(kode) != null;
    }

}
