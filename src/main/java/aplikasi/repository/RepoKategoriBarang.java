/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.KategoriBarang;
import java.sql.SQLException;

/**
 *
 * @author dimmaryanto
 */
public interface RepoKategoriBarang extends BaseRepository<KategoriBarang, Integer> {

    public KategoriBarang findByKode(String kode) throws SQLException;

    public Boolean existsByKode(String kode) throws SQLException;

}
