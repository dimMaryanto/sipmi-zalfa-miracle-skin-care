/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.laporan;

import aplikasi.config.KoneksiDB;
import aplikasi.config.ValueFormatterFactory;
import aplikasi.controller.TableViewController;
import aplikasi.entity.Barang;
import aplikasi.entity.PembelianDetail;
import aplikasi.entity.PenjualanDetail;
import aplikasi.entity.other.SirkulasiBarang;
import aplikasi.repository.RepoBarang;
import aplikasi.repository.RepoPembelian;
import aplikasi.repository.RepoPenjualan;
import aplikasi.service.ServiceBarang;
import aplikasi.service.ServicePembelian;
import aplikasi.service.ServicePenjualan;
import aplikasi.view.MainMenuView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author dimmaryanto
 */
public class LaporanSirkulasiBarangView extends javax.swing.JInternalFrame {

    private final RepoBarang repoBarang;
    private final RepoPenjualan repoPenjualan;
    private final RepoPembelian repoPembelian;
    private final MainMenuView menuController;
    private final TableViewController tableController;
    private final List<SirkulasiBarang> daftarSirkulasiBarang = new ArrayList<>();
    private List<Barang> daftarBarang = new ArrayList<>();

    private class JumlahBarang {

        private Barang barang;
        private Integer jumlah;

        public JumlahBarang() {
        }

        public JumlahBarang(Barang barang, Integer jumlah) {
            this.barang = barang;
            this.jumlah = jumlah;
        }

        public Barang getBarang() {
            return barang;
        }

        public void setBarang(Barang barang) {
            this.barang = barang;
        }

        public Integer getJumlah() {
            return jumlah;
        }

        public void setJumlah(Integer jumlah) {
            this.jumlah = jumlah;
        }

    }

    public LaporanSirkulasiBarangView(MainMenuView menuController) {
        this.menuController = menuController;
        this.repoBarang = new ServiceBarang(KoneksiDB.getDataSource());
        this.repoPembelian = new ServicePembelian(KoneksiDB.getDataSource());
        this.repoPenjualan = new ServicePenjualan(KoneksiDB.getDataSource());
        initComponents();

        txtTanggalAkhir.setDate(new Date());
        txtTanggalAwal.setDate(new Date());
        this.tableController = new TableViewController(tableView);

        try {
            daftarBarang = repoBarang.findAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Tidak dapat mendapatkan data barang", getTitle(), JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(LaporanSirkulasiBarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshDataTable() {
        tableController.clearData();
        for (SirkulasiBarang sirkulasi : daftarSirkulasiBarang) {
            Barang brg = sirkulasi.getBarang();
            Object[] row = {
                brg.getKode(),
                brg.getNama(),
                sirkulasi.getStokBarangAwal(),
                sirkulasi.getStokBarangMasuk(),
                sirkulasi.getStokBarangKeluar(),
                sirkulasi.getStokBarangSekarang()
            };
            tableController.getModel().addRow(row);
        }
    }

    private List<JumlahBarang> getBarangMasuk(List<PembelianDetail> daftarBeli) {
        List<JumlahBarang> list = new ArrayList<>();
        for (Barang barang : daftarBarang) {
            Integer jumlah = 0;
            for (PembelianDetail beli : daftarBeli) {
                Barang b = beli.getBarang();
                if (barang.getKode().equalsIgnoreCase(b.getKode())) {
                    jumlah += beli.getJumlah();
                }
            }
            list.add(new JumlahBarang(barang, jumlah));
        }
        return list;
    }

    private List<JumlahBarang> getBarangKeluar(List<PenjualanDetail> daftarJual) {
        List<JumlahBarang> list = new ArrayList<>();
        for (Barang barang : daftarBarang) {
            Integer jumlah = 0;
            for (PenjualanDetail jual : daftarJual) {
                Barang b = jual.getBarang();
                if (barang.getKode().equalsIgnoreCase(b.getKode())) {
                    jumlah += jual.getJumlah();
                }
            }
            list.add(new JumlahBarang(barang, jumlah));
        }
        return list;
    }

    @Deprecated
    private void prosesMergeBarang(List<PenjualanDetail> daftarJualBarang, List<PembelianDetail> daftarBeliBarang) {
        this.daftarSirkulasiBarang.clear();
        for (Barang brg : daftarBarang) {
            Integer jumlahJual = 0;
            Integer jumlahBeli = 0;
            for (PenjualanDetail jual : daftarJualBarang) {
                Barang b = jual.getBarang();
                if (brg.getKode().equalsIgnoreCase(b.getKode())) {
                    jumlahJual += jual.getJumlah();
                }
                System.out.println("Barang " + b.getNama() + " ke " + jumlahJual);
            }

            for (PembelianDetail beli : daftarBeliBarang) {
                Barang b = beli.getBarang();
                if (brg.getKode().equalsIgnoreCase(b.getKode())) {
                    jumlahBeli += beli.getJumlah();
                }
                System.out.println("Barang " + b.getNama() + " ke " + jumlahBeli);
            }

            SirkulasiBarang sirkulasiBarang = new SirkulasiBarang();
            sirkulasiBarang.setBarang(brg);
            sirkulasiBarang.setStokBarangAwal((jumlahJual - jumlahBeli) + brg.getJumlah());
            sirkulasiBarang.setStokBarangKeluar(jumlahJual);
            sirkulasiBarang.setStokBarangMasuk(jumlahBeli);
            sirkulasiBarang.setStokBarangSekarang(brg.getJumlah());
            daftarSirkulasiBarang.add(sirkulasiBarang);

            // TODO add to list
            System.out.println("Penjualan Kode barang :" + brg.getKode() + " jumlah " + jumlahJual);
            System.out.println("Pembelian Kode barang :" + brg.getKode() + " jumlah " + jumlahBeli);
            System.out.println("------------------------------------------------------------------");
        }
    }

    public Integer jumlah(Barang barang, List<JumlahBarang> daftar) {
        Integer hasil = 0;
        for (JumlahBarang data : daftar) {
            if (data.getBarang().getKode().equalsIgnoreCase(barang.getKode())) {
                hasil += data.getJumlah();
            }
        }
        return hasil;
    }

    private void mergeList(
            List<JumlahBarang> beliSebelum,
            List<JumlahBarang> beli,
            List<JumlahBarang> jualSebelum,
            List<JumlahBarang> jual) {

        daftarSirkulasiBarang.clear();
        for (Barang barang : daftarBarang) {
            SirkulasiBarang sirkulasi = new SirkulasiBarang();
            sirkulasi.setBarang(barang);
            Integer jmlSebelumMasuk = jumlah(barang, beliSebelum);
            Integer jmlSebelumKeluar = jumlah(barang, jualSebelum);
            
            sirkulasi.setStokBarangKeluar(jumlah(barang, jual));
            sirkulasi.setStokBarangMasuk(jumlah(barang, beli));
            sirkulasi.setStokBarangSekarang(barang.getJumlah());
            sirkulasi.setStokBarangAwal(jmlSebelumMasuk - jmlSebelumKeluar);
            daftarSirkulasiBarang.add(sirkulasi);
        }
        refreshDataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTanggalAwal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTanggalAkhir = new com.toedter.calendar.JDateChooser();
        btnProses = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();

        setTitle("Laporan Sirkulasi Barang");

        jLabel1.setText("Tanggal:");

        jLabel2.setText("s/d");

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTanggalAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTanggalAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProses, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Barang"));

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Sebelum", "Masuk", "Keluar", "Sekarang"
            }
        ));
        jScrollPane1.setViewportView(tableView);
        if (tableView.getColumnModel().getColumnCount() > 0) {
            tableView.getColumnModel().getColumn(0).setMinWidth(120);
            tableView.getColumnModel().getColumn(0).setPreferredWidth(120);
            tableView.getColumnModel().getColumn(0).setMaxWidth(120);
            tableView.getColumnModel().getColumn(1).setMinWidth(150);
            tableView.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableView.getColumnModel().getColumn(2).setMinWidth(80);
            tableView.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableView.getColumnModel().getColumn(2).setMaxWidth(80);
            tableView.getColumnModel().getColumn(3).setMinWidth(80);
            tableView.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableView.getColumnModel().getColumn(3).setMaxWidth(80);
            tableView.getColumnModel().getColumn(4).setMinWidth(80);
            tableView.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableView.getColumnModel().getColumn(4).setMaxWidth(80);
            tableView.getColumnModel().getColumn(5).setMinWidth(80);
            tableView.getColumnModel().getColumn(5).setPreferredWidth(80);
            tableView.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        try {
            java.sql.Date tglAwal = java.sql.Date.valueOf(ValueFormatterFactory.getDateSQL(txtTanggalAwal.getDate()));
            java.sql.Date tglAkhir = java.sql.Date.valueOf(ValueFormatterFactory.getDateSQL(txtTanggalAkhir.getDate()));
            List<PenjualanDetail> daftarJual = repoPenjualan.findPenjualanDetailBetweenTanggal(tglAwal, tglAkhir);
            List<PembelianDetail> daftarBeli = repoPembelian.findPembelianDetailBetweenTanggal(tglAwal, tglAkhir);
            List<PenjualanDetail> daftarJualSebelum = repoPenjualan.findPenjualanDetailByTanggalLowerThen(tglAwal);
            List<PembelianDetail> daftarBeliSebelum = repoPembelian.findPembelianDetailByTanggalLowerThen(tglAwal);

            mergeList(
                    getBarangMasuk(daftarBeliSebelum),
                    getBarangMasuk(daftarBeli),
                    getBarangKeluar(daftarJualSebelum),
                    getBarangKeluar(daftarJual));
        } catch (SQLException ex) {
            Logger.getLogger(LaporanSirkulasiBarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (daftarSirkulasiBarang.size() > 0) {
            try {
                String url = "/laporan/SirkulasiBarang.jasper";
                Map<String, Object> map = new HashMap<>();
                map.put("tglAwal", txtTanggalAwal.getDate());
                map.put("tglAkhir", txtTanggalAkhir.getDate());
                JasperPrint print = JasperFillManager.fillReport(
                        getClass().getResourceAsStream(url),
                        map,
                        new JRBeanCollectionDataSource(daftarSirkulasiBarang));
                JasperViewer view = new JasperViewer(print, false);
                view.setLocationRelativeTo(null);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(LaporanSirkulasiBarangView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data belum diproses", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnProses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableView;
    private com.toedter.calendar.JDateChooser txtTanggalAkhir;
    private com.toedter.calendar.JDateChooser txtTanggalAwal;
    // End of variables declaration//GEN-END:variables
}
