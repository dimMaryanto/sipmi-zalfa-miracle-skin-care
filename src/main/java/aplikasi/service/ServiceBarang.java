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
    public Barang save(Barang value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Barang update(Barang value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Barang> findAll() throws SQLException {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM v_barang";

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

        return brg;
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
