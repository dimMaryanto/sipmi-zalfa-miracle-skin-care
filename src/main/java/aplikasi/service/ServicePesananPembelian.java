/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Barang;
import aplikasi.entity.KategoriBarang;
import aplikasi.entity.Pemasok;
import aplikasi.entity.PesananPembelian;
import aplikasi.entity.PesananPembelianDetail;
import aplikasi.repository.RepoPesananPembelian;
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
public class ServicePesananPembelian implements RepoPesananPembelian {

    private final DataSource ds;

    public ServicePesananPembelian(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public PesananPembelian save(PesananPembelian value) throws SQLException {
        String sql = "INSERT INTO pesanan_pembelian (kode, tgl, id_pemasok) VALUES (?,?,?)";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);

        ps.setString(1, value.getKode());
        ps.setDate(2, value.getTgl());
        ps.setInt(3, value.getPemasok().getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    @Deprecated
    public PesananPembelian update(PesananPembelian value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PesananPembelian> findAll() throws SQLException {
        List<PesananPembelian> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "    b.kode as kode_pesanan,\n"
                + "    b.tgl as tanggal_pesanan,\n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as telp_pemasok\n"
                + "FROM pesanan_pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PesananPembelian pp = new PesananPembelian();
            pp.setKode(rs.getString("kode_pesanan"));
            pp.setTgl(rs.getDate("tanggal_pesanan"));

            Pemasok p = new Pemasok();
            p.setId(rs.getInt("kode_pemasok"));
            p.setNama(rs.getString("nama_pemasok"));
            p.setAlamat(rs.getString("alamat_pemasok"));
            p.setTlp(rs.getString("telp_pemasok"));
            pp.setPemasok(p);

            list.add(pp);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public PesananPembelian findOne(String id) throws SQLException {
        String sql = "SELECT\n"
                + "    b.kode as kode_pesanan,\n"
                + "    b.tgl as tanggal_pesanan,\n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as telp_pemasok\n"
                + "FROM pesanan_pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        PesananPembelian pp = null;
        while (rs.next()) {
            pp = new PesananPembelian();
            pp.setKode(rs.getString("kode_pesanan"));
            pp.setTgl(rs.getDate("tanggal_pesanan"));

            Pemasok p = new Pemasok();
            p.setId(rs.getInt("kode_pemasok"));
            p.setNama(rs.getString("nama_pemasok"));
            p.setAlamat(rs.getString("alamat_pemasok"));
            p.setTlp(rs.getString("telp_pemasok"));
            pp.setPemasok(p);
        }

        ps.close();
        rs.close();
        connect.close();
        return pp;
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        return findOne(id) != null;
    }

    @Override
    public void delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PesananPembelianDetail> findPesananPembelianDetailByPesananKode(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    b.kode as kode_pemesanan,\n"
                + "    b.tgl as tanggal_pemesanan,\n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as telp_pemasok,\n"
                + "    bd.id as id_pemesanan_detail,\n"
                + "    bd.jumlah as jumlah_pemesanan,\n"
                + "    brg.kode as kode_barang,\n"
                + "    brg.nama as nama_barang,\n"
                + "    brg.harga_jual as harga_jual_barang,\n"
                + "    brg.harga_beli as harga_beli_barang,\n"
                + "    brg.jumlah as stok_barang,\n"
                + "    brg.paket as barang_paketan,\n"
                + "    kbrg.id as id_kategori_barang,\n"
                + "    kbrg.kode as kode_ketegori_barang,\n"
                + "    kbrg.nama as nama_kategori_barang\n"
                + "FROM pesanan_pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)\n"
                + "    JOIN pesanan_pembelian_detail bd ON (b.kode = bd.kode_pesanan)\n"
                + "    JOIN barang brg ON (bd.kode_barang = brg.kode)\n"
                + "    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori)\n"
                + "WHERE b.kode = ?";
        List<PesananPembelianDetail> list = new ArrayList<>();
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PesananPembelian pp = new PesananPembelian();
            pp.setKode(rs.getString("kode_pemesanan"));
            pp.setTgl(rs.getDate("tanggal_pemesanan"));

            Pemasok p = new Pemasok();
            p.setId(rs.getInt("kode_pemasok"));
            p.setNama(rs.getString("nama_pemasok"));
            p.setAlamat(rs.getString("alamat_pemasok"));
            p.setTlp(rs.getString("telp_pemasok"));
            pp.setPemasok(p);

            PesananPembelianDetail bd = new PesananPembelianDetail();
            bd.setId(rs.getInt("id_pemesanan_detail"));
            bd.setJumlah(rs.getInt("jumlah_pemesanan"));
            bd.setPesananPembelian(pp);

            Barang brg = new Barang();
            brg.setKode(rs.getString("kode_barang"));
            brg.setNama(rs.getString("nama_barang"));
            brg.setHargaJual(rs.getDouble("harga_jual_barang"));
            brg.setHargaBeli(rs.getDouble("harga_beli_barang"));
            brg.setJumlah(rs.getInt("stok_barang"));
            brg.setPaket(rs.getBoolean("barang_paketan"));
            bd.setBarang(brg);

            KategoriBarang k = new KategoriBarang();
            k.setId(rs.getInt("id_kategori_barang"));
            k.setKode(rs.getString("kode_ketegori_barang"));
            k.setNama(rs.getString("nama_kategori_barang"));
            brg.setKategori(k);

            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public PesananPembelian save(PesananPembelian pesan, List<PesananPembelianDetail> barangPesan) throws SQLException {
        save(pesan);
        String sql = "INSERT INTO pesanan_pembelian_detail (kode_pesanan, kode_barang, jumlah) VALUES (?,?,?)";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        for (PesananPembelianDetail pd : barangPesan) {
            ps.setString(1, pd.getPesananPembelian().getKode());
            ps.setString(2, pd.getBarang().getKode());
            ps.setInt(3, pd.getJumlah());
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
        connect.close();

        return pesan;
    }

}
