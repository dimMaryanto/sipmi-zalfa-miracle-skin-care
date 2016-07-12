/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view;

import aplikasi.view.menu.barang.DaftarBarangView;
import aplikasi.view.menu.barang.DataBarangView;
import aplikasi.view.menu.kategori.barang.DaftarKategoriBarangView;
import aplikasi.view.menu.kategori.barang.DataKategoriBarangView;
import aplikasi.view.menu.laporan.LaporanSirkulasiBarang;
import aplikasi.view.menu.pelanggan.DaftarPelangganView;
import aplikasi.view.menu.pelanggan.DataPelangganView;
import aplikasi.view.menu.pemasok.DaftarPemasokView;
import aplikasi.view.menu.pemasok.DataPemasokView;
import aplikasi.view.menu.pembelian.DataPembelianView;
import aplikasi.view.menu.pemesanan.pembelian.DataPembelianDariPemesananView;
import aplikasi.view.menu.pemesanan.pembelian.DataPemesananPembelianView;
import aplikasi.view.menu.penjualan.DataPenjualanView;
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

    public void setInnerLayout(JInternalFrame internal) throws PropertyVetoException {
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
        btnKategoriBarang = new javax.swing.JButton();
        btnBarang = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnPenjualan = new javax.swing.JButton();
        btnPembelian = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnPesananPembelian = new javax.swing.JButton();
        btnBayarPesananPembelian = new javax.swing.JButton();
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

        btnKategoriBarang.setText("Kategori Barang");
        btnKategoriBarang.setFocusable(false);
        btnKategoriBarang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKategoriBarang.setMaximumSize(new java.awt.Dimension(200, 35));
        btnKategoriBarang.setMinimumSize(new java.awt.Dimension(200, 35));
        btnKategoriBarang.setPreferredSize(new java.awt.Dimension(200, 35));
        btnKategoriBarang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriBarangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKategoriBarang);

        btnBarang.setText("Barang");
        btnBarang.setFocusable(false);
        btnBarang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBarang.setMaximumSize(new java.awt.Dimension(200, 35));
        btnBarang.setMinimumSize(new java.awt.Dimension(200, 35));
        btnBarang.setPreferredSize(new java.awt.Dimension(200, 35));
        btnBarang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBarang);
        jToolBar1.add(jSeparator2);

        btnPenjualan.setText("Penjualan");
        btnPenjualan.setFocusable(false);
        btnPenjualan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPenjualan.setMaximumSize(new java.awt.Dimension(200, 35));
        btnPenjualan.setMinimumSize(new java.awt.Dimension(200, 35));
        btnPenjualan.setPreferredSize(new java.awt.Dimension(200, 35));
        btnPenjualan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPenjualan);

        btnPembelian.setText("Pembelian");
        btnPembelian.setFocusable(false);
        btnPembelian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPembelian.setMaximumSize(new java.awt.Dimension(200, 35));
        btnPembelian.setMinimumSize(new java.awt.Dimension(200, 35));
        btnPembelian.setPreferredSize(new java.awt.Dimension(200, 35));
        btnPembelian.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembelianActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPembelian);
        jToolBar1.add(jSeparator3);

        btnPesananPembelian.setText("Pesanan Pembelian");
        btnPesananPembelian.setFocusable(false);
        btnPesananPembelian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesananPembelian.setMaximumSize(new java.awt.Dimension(200, 35));
        btnPesananPembelian.setMinimumSize(new java.awt.Dimension(200, 35));
        btnPesananPembelian.setPreferredSize(new java.awt.Dimension(200, 35));
        btnPesananPembelian.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesananPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesananPembelianActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPesananPembelian);

        btnBayarPesananPembelian.setText("Ambil Pesanan Pembelian");
        btnBayarPesananPembelian.setFocusable(false);
        btnBayarPesananPembelian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBayarPesananPembelian.setMaximumSize(new java.awt.Dimension(200, 35));
        btnBayarPesananPembelian.setMinimumSize(new java.awt.Dimension(200, 35));
        btnBayarPesananPembelian.setPreferredSize(new java.awt.Dimension(200, 35));
        btnBayarPesananPembelian.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBayarPesananPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarPesananPembelianActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBayarPesananPembelian);

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
        mniKategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKategoriBarangActionPerformed(evt);
            }
        });
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
        mniPesanPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPesanPembelianActionPerformed(evt);
            }
        });
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
        mniLaporanSirkulasiBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLaporanSirkulasiBarangActionPerformed(evt);
            }
        });
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

    private void mniKategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKategoriBarangActionPerformed
        try {
            DaftarKategoriBarangView view = new DaftarKategoriBarangView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniKategoriBarangActionPerformed

    private void btnKategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriBarangActionPerformed
        DataKategoriBarangView view = new DataKategoriBarangView(this, true);
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }//GEN-LAST:event_btnKategoriBarangActionPerformed

    private void btnBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangActionPerformed
        DataBarangView view = new DataBarangView(this, true);
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }//GEN-LAST:event_btnBarangActionPerformed

    private void mniPesanPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPesanPembelianActionPerformed
        try {
            DataPemesananPembelianView view = new DataPemesananPembelianView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniPesanPembelianActionPerformed

    private void btnPesananPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesananPembelianActionPerformed
        try {
            DataPemesananPembelianView view = new DataPemesananPembelianView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesananPembelianActionPerformed

    private void btnBayarPesananPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarPesananPembelianActionPerformed
        try {
            DataPembelianDariPemesananView view = new DataPembelianDariPemesananView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBayarPesananPembelianActionPerformed

    private void btnPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembelianActionPerformed
        try {
            DataPembelianView view = new DataPembelianView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPembelianActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
        try {
            DataPenjualanView view = new DataPenjualanView(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void mniLaporanSirkulasiBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLaporanSirkulasiBarangActionPerformed
        try {
            LaporanSirkulasiBarang view = new LaporanSirkulasiBarang(this);
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniLaporanSirkulasiBarangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarang;
    private javax.swing.JButton btnBayarPesananPembelian;
    private javax.swing.JButton btnKategoriBarang;
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnPemasok;
    private javax.swing.JButton btnPembelian;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnPesananPembelian;
    private javax.swing.JDesktopPane desktop;
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
