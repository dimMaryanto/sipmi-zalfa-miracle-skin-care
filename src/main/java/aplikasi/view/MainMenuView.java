/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view;

import aplikasi.view.menu.barang.DaftarBarangView;
import aplikasi.view.menu.pelanggan.DaftarPelangganView;
import aplikasi.view.menu.pelanggan.DataPelangganView;
import aplikasi.view.menu.pemasok.DaftarPemasokView;
import aplikasi.view.menu.pemasok.DataPemasokView;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author dimmaryanto
 */
public class MainMenuView extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private void showLoginScreen() {
        LoginView login = new LoginView(this, this, true);
        login.setTitle("SIPMI - Zalfa Miracle Skin Care");
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    private void setInnerLayout(JInternalFrame internal) throws PropertyVetoException {
        this.desktop.removeAll();
        this.desktop.add(internal);
        internal.setMaximum(true);
        internal.setVisible(true);
    }

    public MainMenuView() {
        initComponents();
        showLoginScreen();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnPelanggan = new javax.swing.JButton();
        btnPemasok = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAplikasi = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnuMasterData = new javax.swing.JMenu();
        mniPelanggan = new javax.swing.JMenuItem();
        mniPemasok = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniKategoriBarang = new javax.swing.JMenuItem();
        mniBarang = new javax.swing.JMenuItem();
        mnuTransaksi = new javax.swing.JMenu();
        mniPembelian = new javax.swing.JMenuItem();
        mniPenjualan = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mniPesanPembelian = new javax.swing.JMenuItem();
        mniAmbilPesanPembelian = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mniLapPenjualan = new javax.swing.JMenuItem();
        mniLapPembelian = new javax.swing.JMenuItem();
        mniLapBarang = new javax.swing.JMenuItem();
        mniLaporanSirkulasiBarang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 600));
        setSize(new java.awt.Dimension(1024, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Main Menu"));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 300));

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setAutoscrolls(true);
        jToolBar1.setFocusCycleRoot(true);

        btnPelanggan.setText("Pelanggan");
        btnPelanggan.setFocusable(false);
        btnPelanggan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPelanggan.setMaximumSize(new java.awt.Dimension(200, 35));
        btnPelanggan.setMinimumSize(new java.awt.Dimension(200, 35));
        btnPelanggan.setPreferredSize(new java.awt.Dimension(200, 35));
        btnPelanggan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelangganActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPelanggan);

        btnPemasok.setText("Pemasok");
        btnPemasok.setFocusable(false);
        btnPemasok.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPemasok.setMaximumSize(new java.awt.Dimension(200, 35));
        btnPemasok.setMinimumSize(new java.awt.Dimension(200, 35));
        btnPemasok.setPreferredSize(new java.awt.Dimension(200, 35));
        btnPemasok.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPemasokActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPemasok);
        jToolBar1.add(jSeparator1);

        jButton3.setText("Kategori Barang");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton3.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton9.setText("Barang");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton9.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton9.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton9);
        jToolBar1.add(jSeparator2);

        jButton4.setText("Penjualan");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton4.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton4.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setText("Pembelian");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton5.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton5.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator3);

        jButton8.setText("Pesanan Pembelian");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton8.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton8.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);

        jButton7.setText("Ambil Pesanan Pembelian");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMaximumSize(new java.awt.Dimension(200, 35));
        jButton7.setMinimumSize(new java.awt.Dimension(200, 35));
        jButton7.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setPreferredSize(new java.awt.Dimension(624, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setMinimumSize(new java.awt.Dimension(320, 35));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(320, 35));

        mnuAplikasi.setText("Aplikasi");

        mniLogin.setText("Login");
        mnuAplikasi.add(mniLogin);

        mniLogout.setText("Logout");
        mnuAplikasi.add(mniLogout);
        mnuAplikasi.add(jSeparator4);

        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuAplikasi.add(mniExit);

        jMenuBar1.add(mnuAplikasi);

        mnuMasterData.setText("Master Data");

        mniPelanggan.setText("Pelanggan");
        mniPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPelangganActionPerformed(evt);
            }
        });
        mnuMasterData.add(mniPelanggan);

        mniPemasok.setText("Pemasok");
        mniPemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPemasokActionPerformed(evt);
            }
        });
        mnuMasterData.add(mniPemasok);
        mnuMasterData.add(jSeparator5);

        mniKategoriBarang.setText("Kategori Barang");
        mnuMasterData.add(mniKategoriBarang);

        mniBarang.setText("Barang");
        mniBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBarangActionPerformed(evt);
            }
        });
        mnuMasterData.add(mniBarang);

        jMenuBar1.add(mnuMasterData);

        mnuTransaksi.setText("Transaksi");

        mniPembelian.setText("Pembelian");
        mnuTransaksi.add(mniPembelian);

        mniPenjualan.setText("Penjualan");
        mnuTransaksi.add(mniPenjualan);
        mnuTransaksi.add(jSeparator6);

        mniPesanPembelian.setText("Pesanan Pembelian");
        mnuTransaksi.add(mniPesanPembelian);

        mniAmbilPesanPembelian.setText("Bayar Pesanan");
        mnuTransaksi.add(mniAmbilPesanPembelian);

        jMenuBar1.add(mnuTransaksi);

        jMenu4.setText("Laporan");

        mniLapPenjualan.setText("Penjualan");
        jMenu4.add(mniLapPenjualan);

        mniLapPembelian.setText("Pembelian");
        jMenu4.add(mniLapPembelian);

        mniLapBarang.setText("Barang");
        jMenu4.add(mniLapBarang);

        mniLaporanSirkulasiBarang.setText("Sirkulasi Barang");
        jMenu4.add(mniLaporanSirkulasiBarang);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPemasokActionPerformed
        DataPemasokView view = new DataPemasokView(this, true);
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }//GEN-LAST:event_btnPemasokActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniExitActionPerformed

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
        DataPelangganView pelanggan = new DataPelangganView(this, true);
        pelanggan.setLocationRelativeTo(null);
        pelanggan.setResizable(false);
        pelanggan.setVisible(true);
    }//GEN-LAST:event_btnPelangganActionPerformed

    private void mniPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPelangganActionPerformed
        try {
            DaftarPelangganView view = new DaftarPelangganView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniPelangganActionPerformed

    private void mniPemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPemasokActionPerformed
        try {
            DaftarPemasokView view = new DaftarPemasokView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniPemasokActionPerformed

    private void mniBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBarangActionPerformed
        try {
            DaftarBarangView view = new DaftarBarangView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mniBarangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnPemasok;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mniAmbilPesanPembelian;
    private javax.swing.JMenuItem mniBarang;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniKategoriBarang;
    private javax.swing.JMenuItem mniLapBarang;
    private javax.swing.JMenuItem mniLapPembelian;
    private javax.swing.JMenuItem mniLapPenjualan;
    private javax.swing.JMenuItem mniLaporanSirkulasiBarang;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniPelanggan;
    private javax.swing.JMenuItem mniPemasok;
    private javax.swing.JMenuItem mniPembelian;
    private javax.swing.JMenuItem mniPenjualan;
    private javax.swing.JMenuItem mniPesanPembelian;
    private javax.swing.JMenu mnuAplikasi;
    private javax.swing.JMenu mnuMasterData;
    private javax.swing.JMenu mnuTransaksi;
    // End of variables declaration//GEN-END:variables
}
