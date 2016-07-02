/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Barang;
import aplikasi.entity.KategoriBarang;
import aplikasi.entity.Pemasok;
import aplikasi.entity.Pembelian;
import aplikasi.entity.PembelianDetail;
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

    @Override
    public Pembelian save(Pembelian b, List<PembelianDetail> listPembelian) throws SQLException {
        save(b);

        String sql = "INSERT INTO pembelian_detail (id_pembelian, kode_barang, harga, jumlah) VALUES (?,?,?,?)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        for (PembelianDetail pd : listPembelian) {
            ps.setInt(1, pd.getPembelian().getId());
            ps.setString(2, pd.getBarang().getKode());
            ps.setDouble(3, pd.getHarga());
            ps.setInt(4, pd.getJumlah());
            ps.addBatch();
        }

        ps.executeBatch();
        ps.close();
        connect.close();
        return b;
    }

    @Override
    public List<PembelianDetail> findPembelianDetailByPembelianId(Integer beli) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id as id_pembelian, \n"
                + "    b.kode as kode_pembelian,\n"
                + "    b.tgl as tanggal_pembelian,\n"
                + "    p.id as kode_pemasok,\n"
                + "    p.nama as nama_pemasok,\n"
                + "    p.alamat as alamat_pemasok,\n"
                + "    p.tlp as telp_pemasok,\n"
                + "    bd.id as id_pembelian_detail,\n"
                + "    bd.harga as harga_pembelian,\n"
                + "    bd.jumlah as jumlah_pembelian,\n"
                + "    brg.kode as kode_barang,\n"
                + "    brg.nama as nama_barang,\n"
                + "    brg.harga_jual as harga_jual_barang,\n"
                + "    brg.harga_beli as harga_beli_barang,\n"
                + "    brg.jumlah as stok_barang,\n"
                + "    brg.paket as barang_paketan,\n"
                + "    kbrg.id as id_kategori_barang,\n"
                + "    kbrg.kode as kode_ketegori_barang,\n"
                + "    kbrg.nama as nama_kategori_barang\n"
                + "FROM pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)\n"
                + "    JOIN pembelian_detail bd ON (b.id = bd.id_pembelian)\n"
                + "    JOIN barang brg ON (bd.kode_barang = brg.kode)\n"
                + "    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori)\n"
                + "WHERE b.id = ?";
        List<PembelianDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, beli);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PembelianDetail bd = new PembelianDetail();

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

            Barang brg = new Barang();
            brg.setKode(rs.getString("kode_barang"));
            brg.setNama(rs.getString("nama_barang"));
            brg.setHargaBeli(rs.getDouble("harga_beli_barang"));
            brg.setHargaJual(rs.getDouble("harga_jual_barang"));
            brg.setJumlah(rs.getInt("stok_barang"));
            brg.setPaket(rs.getBoolean("barang_paketan"));

            KategoriBarang kb = new KategoriBarang();
            kb.setId(rs.getInt("id_kategori_barang"));
            kb.setKode(rs.getString("kode_ketegori_barang"));
            kb.setNama(rs.getString("nama_kategori_barang"));

            brg.setKategori(kb);

            bd.setPembelian(b);
            bd.setBarang(brg);
            bd.setHarga(rs.getDouble("harga_pembelian"));
            bd.setJumlah(rs.getInt("jumlah_pembelian"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
