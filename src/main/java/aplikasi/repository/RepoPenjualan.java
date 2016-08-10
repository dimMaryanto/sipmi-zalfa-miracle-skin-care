/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Penjualan;
import aplikasi.entity.PenjualanDetail;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dimmaryanto
 */
public interface RepoPenjualan extends BaseRepository<Penjualan, String> {

    public Penjualan save(Penjualan p, List<PenjualanDetail> barangJual) throws SQLException;
    
    public List<Penjualan> findPenjualanByTglBetween(Date awal, Date akhir) throws SQLException;

    public List<PenjualanDetail> findPenjualanDetailByPenjualanKode(String kode) throws SQLException;

    public List<PenjualanDetail> findPenjualanDetailBetweenTanggal(Date tglAwal, Date tglAkhir) throws SQLException;
    
    public List<PenjualanDetail> findPenjualanDetailByTanggalLowerThen(Date tgl) throws SQLException;

    public Penjualan findByPelangganOrderByTanggalAscLastTransaction(String kode) throws SQLException;
    
    public List<PenjualanDetail> findPenjualanDetailByPelangganKode(String kode) throws SQLException;

}
