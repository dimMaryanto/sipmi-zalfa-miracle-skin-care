/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.PesananPembelian;
import aplikasi.entity.PesananPembelianDetail;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dimmaryanto
 */
public interface RepoPesananPembelian extends BaseRepository<PesananPembelian, String> {

    public List<PesananPembelianDetail> findPesananPembelianDetailByPesananKode(String kode) throws SQLException;
    
    public PesananPembelian save(PesananPembelian pesan, List<PesananPembelianDetail> barangPesan)throws SQLException;

}
