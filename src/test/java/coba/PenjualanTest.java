/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba;

import aplikasi.config.KoneksiDB;
import aplikasi.entity.Penjualan;
import aplikasi.repository.RepoPenjualan;
import aplikasi.service.ServicePenjualan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dimmaryanto
 */
@Ignore
public class PenjualanTest extends TestCase {

    private RepoPenjualan repo;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.repo = new ServicePenjualan(KoneksiDB.getDataSource());
    }

    @Test
    public void testPenjualan() {
        try {
            Penjualan jual = repo.findByPelangganOrderByTanggalAscLastTransaction("PEL001");
            assertNotNull(jual);
            assertEquals(jual.getKode(), "PNJ-160712-03");
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
