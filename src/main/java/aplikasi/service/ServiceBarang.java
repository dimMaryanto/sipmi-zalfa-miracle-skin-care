/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Barang;
import aplikasi.entity.KategoriBarang;
import aplikasi.repository.RepoBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author dimmaryanto
 */
public class ServiceBarang implements RepoBarang {

    private DataSource ds;

    public ServiceBarang(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Barang save(Barang b) throws SQLException {
        String sql = "INSERT INTO barang (kode, id_kategori, nama, harga_jual, harga_beli, paket)\n"
                + "VALUES (?,?,?,?,?,?)";

        KategoriBarang kb = b.getKategori();
        List<Barang> listBarangByKategori = findByKategoriKode(kb.getKode());
        b.setKode(kb.getKode() + String.format("%02d", listBarangByKategori.size() + 1));

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, b.getKode());
        ps.setInt(2, kb.getId());
        ps.setString(3, b.getNama());
        ps.setDouble(4, b.getHargaJual());
        ps.setDouble(5, b.getHargaBeli());
        ps.setBoolean(6, b.getPaket());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return b;
    }

    @Override
    public Barang update(Barang b) throws SQLException {
        String sql = "UPDATE barang SET id_kategori = ?, nama = ?, harga_jual = ?, harga_beli = ?, paket = ? WHERE kode = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, b.getKategori().getId());
        ps.setString(2, b.getNama());
        ps.setDouble(3, b.getHargaJual());
        ps.setDouble(4, b.getHargaBeli());
        ps.setBoolean(5, b.getPaket());
        ps.setString(6, b.getKode());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return b;
    }

    @Override
    public List<Barang> findAll() throws SQLException {
        String sql = "SELECT * FROM v_barang";
        List<Barang> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Barang brg = new Barang();
            brg.setKode(rs.getString("kode_barang"));
            brg.setNama(rs.getString("nama_barang"));
            brg.setHargaJual(rs.getDouble("harga_jual_barang"));
            brg.setHargaBeli(rs.getDouble("harga_beli_barang"));
            brg.setJumlah(rs.getInt("stok_barang"));
            brg.setPaket(rs.getBoolean("barang_paketan"));

            KategoriBarang k = new KategoriBarang();
            k.setId(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama(rs.getString("nama_kategori_barang"));
            brg.setKategori(k);

            list.add(brg);
        }

        st.close();
        rs.close();
        connect.close();

        return list;
    }

    @Override
    public Barang findOne(String id) throws SQLException {
        String sql = "SELECT * FROM v_barang WHERE kode_barang = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Barang brg = null;
        if (rs.next()) {
            brg = new Barang();
            brg.setKode(rs.getString("kode_barang"));
            brg.setNama(rs.getString("nama_barang"));
            brg.setHargaJual(rs.getDouble("harga_jual_barang"));
            brg.setHargaBeli(rs.getDouble("harga_beli_barang"));
            brg.setJumlah(rs.getInt("stok_barang"));
            brg.setPaket(rs.getBoolean("barang_paketan"));

            KategoriBarang k = new KategoriBarang();
            k.setId(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama(rs.getString("nama_kategori_barang"));
            brg.setKategori(k);
        }

        ps.close();
        rs.close();
        connect.close();
        return brg;
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        return findOne(id) != null;
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM barang WHERE kode_barang = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<Barang> findByKategoriKode(String kode) throws SQLException {
        String sql = "SELECT * FROM v_barang WHERE kode_kategori = ?";
        List<Barang> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Barang brg = new Barang();
            brg.setKode(rs.getString("kode_barang"));
            brg.setNama(rs.getString("nama_barang"));
            brg.setHargaJual(rs.getDouble("harga_jual_barang"));
            brg.setHargaBeli(rs.getDouble("harga_beli_barang"));
            brg.setJumlah(rs.getInt("stok_barang"));
            brg.setPaket(rs.getBoolean("barang_paketan"));

            KategoriBarang k = new KategoriBarang();
            k.setId(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama(rs.getString("nama_kategori_barang"));
            brg.setKategori(k);

            list.add(brg);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
