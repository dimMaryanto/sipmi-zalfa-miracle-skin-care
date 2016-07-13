/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Pembelian;
import aplikasi.entity.PembelianDetail;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dimmaryanto
 */
public interface RepoPembelian extends BaseRepository<Pembelian, Integer> {

    public Pembelian save(Pembelian b, List<PembelianDetail> listPembelian) throws SQLException;

    public List<PembelianDetail> findPembelianDetailByPembelianId(Integer idPembelian) throws SQLException;

    public List<PembelianDetail> findPembelianDetailBetweenTanggal(Date awal, Date akhir) throws SQLException;

    public List<PembelianDetail> findPembelianDetailByTanggalLowerThen(Date tanggal) throws SQLException;

}
