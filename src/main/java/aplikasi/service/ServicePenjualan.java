/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Barang;
import aplikasi.entity.KategoriBarang;
import aplikasi.entity.Pelanggan;
import aplikasi.entity.Penjualan;
import aplikasi.entity.PenjualanDetail;
import aplikasi.repository.RepoPenjualan;
import java.sql.Connection;
import java.sql.Date;
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
public class ServicePenjualan implements RepoPenjualan {

    private final DataSource ds;

    public ServicePenjualan(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Penjualan save(Penjualan value) throws SQLException {
        String sql = "INSERT INTO penjualan (kode, tgl, kode_pelanggan) VALUES (?,?,?)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getKode());
        ps.setDate(2, value.getTgl());
        ps.setString(3, value.getPelanggan().getKode());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    @Deprecated
    public Penjualan update(Penjualan value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penjualan> findAll() throws SQLException {
        String sql = "SELECT \n"
                + "    j.kode as kode_penjualan,\n"
                + "    j.tgl as tanggal_penjualan,\n"
                + "    p.kode as kode_pelanggan,\n"
                + "    p.nama as nama_pelanggan,\n"
                + "    p.alamat as alamat_pelanggan,\n"
                + "    p.notlp as tlp_pelanggan,\n"
                + "    p.agen as pelanggan_agen\n"
                + "FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode)";
        Connection connect = ds.getConnection();
        List<Penjualan> list = new ArrayList<>();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Penjualan j = new Penjualan();
            j.setKode(rs.getString("kode_penjualan"));
            j.setTgl(rs.getDate("tanggal_penjualan"));

            Pelanggan p = new Pelanggan();
            p.setKode(rs.getString("kode_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setAlamat(rs.getString("alamat_pelanggan"));
            p.setTlp(rs.getString("tlp_pelanggan"));
            p.setAgen(rs.getBoolean("pelanggan_agen"));
            j.setPelanggan(p);
            list.add(j);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Penjualan findOne(String id) throws SQLException {
        String sql = "SELECT \n"
                + "    j.kode as kode_penjualan,\n"
                + "    j.tgl as tanggal_penjualan,\n"
                + "    p.kode as kode_pelanggan,\n"
                + "    p.nama as nama_pelanggan,\n"
                + "    p.alamat as alamat_pelanggan,\n"
                + "    p.notlp as tlp_pelanggan,\n"
                + "    p.agen as pelanggan_agen\n"
                + "FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode)\n"
                + "WHERE j.kode = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Penjualan j = null;
        if (rs.next()) {
            j = new Penjualan();
            j.setKode(rs.getString("kode_penjualan"));
            j.setTgl(rs.getDate("tanggal_penjualan"));

            Pelanggan p = new Pelanggan();
            p.setKode(rs.getString("kode_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setAlamat(rs.getString("alamat_pelanggan"));
            p.setTlp(rs.getString("tlp_pelanggan"));
            p.setAgen(rs.getBoolean("pelanggan_agen"));
            j.setPelanggan(p);
        }

        ps.close();
        rs.close();
        connect.close();
        return j;
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        return findOne(id) != null;
    }

    @Override
    public void delete(String id) throws SQLException {
        Connection connect = ds.getConnection();
        PreparedStatement ps;
        String sql;

        sql = "DELETE FROM penjualan_detail WHERE kode_penjualan = ?";
        ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
        ps.close();

        sql = "DELETE FROM penjualan WHERE kode = ?";
        ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
        ps.close();

        connect.close();
    }

    @Override
    public Penjualan save(Penjualan p, List<PenjualanDetail> barangJual) throws SQLException {
        save(p);

        String sql = "INSERT INTO penjualan_detail (kode_penjualan, kode_barang, harga, jumlah, diskon) VALUES (?,?,?,?,?)";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        for (PenjualanDetail pd : barangJual) {
            ps.setString(1, pd.getPenjualan().getKode());
            ps.setString(2, pd.getBarang().getKode());
            ps.setDouble(3, pd.getHarga());
            ps.setInt(4, pd.getJumlah());
            ps.setDouble(5, pd.getDiskon());
            ps.addBatch();
        }

        ps.executeBatch();
        ps.close();

        sql = "UPDATE barang SET jumlah = ? WHERE kode = ?";
        ps = connect.prepareStatement(sql);
        for (PenjualanDetail pd : barangJual) {
            Barang brg = pd.getBarang();
            Integer stokSekarang = brg.getJumlah() - pd.getJumlah();
            ps.setInt(1, stokSekarang);
            ps.setString(2, brg.getKode());
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
        connect.close();
        return p;
    }

    @Override
    public List<PenjualanDetail> findPenjualanDetailByPenjualanKode(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    j.kode as kode_penjualan,\n"
                + "    j.tgl as tanggal_penjualan,\n"
                + "    p.kode as kode_pelanggan,\n"
                + "    p.nama as nama_pelanggan,\n"
                + "    p.alamat as alamat_pelanggan,\n"
                + "    p.notlp as tlp_pelanggan,\n"
                + "    p.agen as pelanggan_agen,\n"
                + "    jd.id as kode_penjualan_detail,\n"
                + "    jd.harga as harga_penjualan,\n"
                + "    jd.jumlah as jumlah_penjualan,\n"
                + "    jd.diskon as diskon_penjualan,\n"
                + "    brg.kode as kode_barang,\n"
                + "    brg.nama as nama_barang,\n"
                + "    brg.harga_jual as harga_jual_barang,\n"
                + "    brg.harga_beli as harga_beli_barang,\n"
                + "    brg.jumlah as stok_barang,\n"
                + "    brg.paket as barang_paketan,\n"
                + "    kbrg.id as id_kategori_barang,\n"
                + "    kbrg.kode as kode_kategori_barang,\n"
                + "    kbrg.nama as nama_kategori_barang\n"
                + "FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode)\n"
                + "    JOIN penjualan_detail jd ON (j.kode = jd.kode_penjualan)\n"
                + "    JOIN barang brg ON (brg.kode = jd.kode_barang)\n"
                + "    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori)\n"
                + "WHERE j.kode = ?";
        List<PenjualanDetail> list = new ArrayList<>();
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Penjualan j = new Penjualan();
            j.setKode(rs.getString("kode_penjualan"));
            j.setTgl(rs.getDate("tanggal_penjualan"));

            Pelanggan p = new Pelanggan();
            p.setKode(rs.getString("kode_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setAlamat(rs.getString("alamat_pelanggan"));
            p.setTlp(rs.getString("tlp_pelanggan"));
            p.setAgen(rs.getBoolean("pelanggan_agen"));
            j.setPelanggan(p);

            Barang brg = new Barang();
            brg.setKode(rs.getString("kode_barang"));
            brg.setNama(rs.getString("nama_barang"));
            brg.setHargaBeli(rs.getDouble("harga_beli_barang"));
            brg.setHargaJual(rs.getDouble("harga_jual_barang"));
            brg.setJumlah(rs.getInt("stok_barang"));
            brg.setPaket(rs.getBoolean("barang_paketan"));

            KategoriBarang kb = new KategoriBarang();
            kb.setId(rs.getInt("id_kategori_barang"));
            kb.setKode(rs.getString("kode_kategori_barang"));
            kb.setNama(rs.getString("nama_kategori_barang"));

            brg.setKategori(kb);

            PenjualanDetail jd = new PenjualanDetail();
            jd.setId(rs.getInt("kode_penjualan_detail"));
            jd.setPenjualan(j);
            jd.setBarang(brg);
            jd.setHarga(rs.getDouble("harga_penjualan"));
            jd.setJumlah(rs.getInt("jumlah_penjualan"));
            jd.setDiskon(rs.getDouble("diskon_penjualan"));
            list.add(jd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<PenjualanDetail> findPenjualanDetailBetweenTanggal(Date tglAwal, Date tglAkhir) throws SQLException {
        String sql = "SELECT \n"
                + "    j.kode as kode_penjualan,\n"
                + "    j.tgl as tanggal_penjualan,\n"
                + "    p.kode as kode_pelanggan,\n"
                + "    p.nama as nama_pelanggan,\n"
                + "    p.alamat as alamat_pelanggan,\n"
                + "    p.notlp as tlp_pelanggan,\n"
                + "    p.agen as pelanggan_agen,\n"
                + "    jd.id as kode_penjualan_detail,\n"
                + "    jd.harga as harga_penjualan,\n"
                + "    jd.jumlah as jumlah_penjualan,\n"
                + "    jd.diskon as diskon_penjualan,\n"
                + "    brg.kode as kode_barang,\n"
                + "    brg.nama as nama_barang,\n"
                + "    brg.harga_jual as harga_jual_barang,\n"
                + "    brg.harga_beli as harga_beli_barang,\n"
                + "    brg.jumlah as stok_barang,\n"
                + "    brg.paket as barang_paketan,\n"
                + "    kbrg.id as id_kategori_barang,\n"
                + "    kbrg.kode as kode_kategori_barang,\n"
                + "    kbrg.nama as nama_kategori_barang\n"
                + "FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode)\n"
                + "    JOIN penjualan_detail jd ON (j.kode = jd.kode_penjualan)\n"
                + "    JOIN barang brg ON (brg.kode = jd.kode_barang)\n"
                + "    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori)\n"
                + "WHERE j.tgl between ? AND ?";
        List<PenjualanDetail> list = new ArrayList<>();
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, tglAwal);
        ps.setDate(2, tglAkhir);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Penjualan j = new Penjualan();
            j.setKode(rs.getString("kode_penjualan"));
            j.setTgl(rs.getDate("tanggal_penjualan"));

            Pelanggan p = new Pelanggan();
            p.setKode(rs.getString("kode_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setAlamat(rs.getString("alamat_pelanggan"));
            p.setTlp(rs.getString("tlp_pelanggan"));
            p.setAgen(rs.getBoolean("pelanggan_agen"));
            j.setPelanggan(p);

            Barang brg = new Barang();
            brg.setKode(rs.getString("kode_barang"));
            brg.setNama(rs.getString("nama_barang"));
            brg.setHargaBeli(rs.getDouble("harga_beli_barang"));
            brg.setHargaJual(rs.getDouble("harga_jual_barang"));
            brg.setJumlah(rs.getInt("stok_barang"));
            brg.setPaket(rs.getBoolean("barang_paketan"));

            KategoriBarang kb = new KategoriBarang();
            kb.setId(rs.getInt("id_kategori_barang"));
            kb.setKode(rs.getString("kode_kategori_barang"));
            kb.setNama(rs.getString("nama_kategori_barang"));

            brg.setKategori(kb);

            PenjualanDetail jd = new PenjualanDetail();
            jd.setId(rs.getInt("kode_penjualan_detail"));
            jd.setPenjualan(j);
            jd.setBarang(brg);
            jd.setHarga(rs.getDouble("harga_penjualan"));
            jd.setJumlah(rs.getInt("jumlah_penjualan"));
            jd.setDiskon(rs.getDouble("diskon_penjualan"));
            list.add(jd);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Penjualan findByPelangganOrderByTanggalAscLastTransaction(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    j.kode as kode_penjualan,\n"
                + "    j.tgl as tanggal_penjualan,\n"
                + "    p.kode as kode_pelanggan,\n"
                + "    p.nama as nama_pelanggan,\n"
                + "    p.alamat as alamat_pelanggan,\n"
                + "    p.notlp as tlp_pelanggan,\n"
                + "    p.agen as pelanggan_agen\n"
                + "FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode)\n"
                + "WHERE p.kode = ?\n"
                + "ORDER BY j.tgl ASC";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Penjualan j = null;
        if (rs.next()) {
            j = new Penjualan();
            j.setKode(rs.getString("kode_penjualan"));
            j.setTgl(rs.getDate("tanggal_penjualan"));

            Pelanggan p = new Pelanggan();
            p.setKode(rs.getString("kode_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setAlamat(rs.getString("alamat_pelanggan"));
            p.setTlp(rs.getString("tlp_pelanggan"));
            p.setAgen(rs.getBoolean("pelanggan_agen"));
            j.setPelanggan(p);
        }

        ps.close();
        rs.close();
        connect.close();
        return j;
    }

}
