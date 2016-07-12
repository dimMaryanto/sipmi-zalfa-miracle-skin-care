/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba;

import aplikasi.config.KoneksiDB;
import aplikasi.entity.Barang;
import aplikasi.repository.RepoBarang;
import aplikasi.repository.RepoKategoriBarang;
import aplikasi.service.ServiceBarang;
import aplikasi.service.ServiceKategoriBarang;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dimmaryanto
 */
@Ignore
public class BarangTest extends TestCase {

    private RepoBarang repoBarang;
    private RepoKategoriBarang repoKategori;

    @Override
    protected void setUp() throws Exception {
        DataSource ds = KoneksiDB.getDataSource();
        repoBarang = new ServiceBarang(ds);
        repoKategori = new ServiceKategoriBarang(ds);
        super.setUp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    public void testFindAll() throws SQLException {
        List<Barang> listBarang = repoBarang.findAll();
        assertEquals(listBarang.size(), 1);
    }

    @Test
    public void testFindById() throws SQLException {
        Barang brg = repoBarang.findOne("DW01");
        assertNotNull(brg);
        assertEquals(brg.getNama(), "Handbody");
        assertEquals(brg.getKategori().getKode(), "PW");
    }

    @Test
    public void testFindByKategoriKode() throws SQLException {
        List<Barang> listBrg = repoBarang.findByKategoriKode("PW");
        assertEquals(listBrg.size(), 1);
    }

    @Test
    public void testSave() throws SQLException {
        Barang brg = new Barang();
        brg.setNama("Serum");
        brg.setHargaBeli(50000D);
        brg.setHargaJual(55000D);
        brg.setKategori(repoKategori.findByKode("PT"));
        brg.setPaket(false);
        repoBarang.save(brg);
    }

}
