/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.crud;

import aplikasi.config.KoneksiDB;
import aplikasi.entity.KategoriBarang;
import aplikasi.repository.RepoKategoriBarang;
import aplikasi.service.ServiceKategoriBarang;
import java.sql.SQLException;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author dimmaryanto
 */
public class KategoriTest extends TestCase {

    private RepoKategoriBarang repo;

    @Override
    protected void setUp() throws Exception {
        this.repo = new ServiceKategoriBarang(KoneksiDB.getDataSource());
        super.setUp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    public void testFindAll() throws SQLException {
        List<KategoriBarang> listKategori = repo.findAll();
        assertNotNull(listKategori);
        assertEquals(listKategori.size(), 2);
    }

    @Test
    public void testFindByKode() throws SQLException {
        KategoriBarang kb = repo.findByKode("PW");
        assertNotNull(kb);
        assertEquals(kb.getNama(), "Perawantan Wajah");
    }

    @Test
    public void testAvailableByKode() throws SQLException {
        assertTrue(repo.existsByKode("PW"));
        assertFalse(repo.existsByKode("PJ"));
    }

}
