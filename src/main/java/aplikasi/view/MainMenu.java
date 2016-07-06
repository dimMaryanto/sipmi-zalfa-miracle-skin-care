/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view;

import aplikasi.view.menu.pelanggan.DaftarPelanggan;
import aplikasi.view.pemasok.DaftarPemasok;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author dimmaryanto
 */
public class MainMenu extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private void showLoginScreen() {
        Login login = new Login(this, this, true);
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

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        showLoginScreen();
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

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

        jMenuItem1.setText("Pelanggan");
        mnuMasterData.add(jMenuItem1);

        jMenuItem2.setText("Pemasok");
        mnuMasterData.add(jMenuItem2);
        mnuMasterData.add(jSeparator5);

        jMenuItem3.setText("Kategori Barang");
        mnuMasterData.add(jMenuItem3);

        jMenuItem4.setText("Barang");
        mnuMasterData.add(jMenuItem4);

        jMenuBar1.add(mnuMasterData);

        jMenu3.setText("Transaksi");

        jMenuItem5.setText("Pembelian");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Penjualan");
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator6);

        jMenuItem7.setText("Pesanan Pembelian");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Bayar Pesanan");
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Laporan");

        jMenuItem9.setText("Penjualan");
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Pembelian");
        jMenu4.add(jMenuItem10);

        jMenuItem11.setText("Barang");
        jMenu4.add(jMenuItem11);

        jMenuItem12.setText("Sirkulasi Barang");
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPemasokActionPerformed
        try {
            DaftarPemasok view = new DaftarPemasok();
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPemasokActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniExitActionPerformed

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
        try {
            DaftarPelanggan view = new DaftarPelanggan();
            setInnerLayout(view);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPelangganActionPerformed

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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenu mnuAplikasi;
    private javax.swing.JMenu mnuMasterData;
    // End of variables declaration//GEN-END:variables
}
