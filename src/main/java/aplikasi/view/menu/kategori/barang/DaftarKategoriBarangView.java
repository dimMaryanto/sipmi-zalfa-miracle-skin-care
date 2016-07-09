/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.kategori.barang;

import aplikasi.config.KoneksiDB;
import aplikasi.controller.TableViewController;
import aplikasi.entity.KategoriBarang;
import aplikasi.repository.RepoKategoriBarang;
import aplikasi.service.ServiceKategoriBarang;
import aplikasi.view.MainMenuView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;

/**
 *
 * @author dimmaryanto
 */
public class DaftarKategoriBarangView extends javax.swing.JInternalFrame {

    private List<KategoriBarang> daftarKategori;
    private final RepoKategoriBarang repo;
    private final TableViewController tableController;
    private final MainMenuView menuController;

    public DaftarKategoriBarangView(MainMenuView aThis) {
        initComponents();
        this.menuController = aThis;
        this.repo = new ServiceKategoriBarang(KoneksiDB.getDataSource());
        this.daftarKategori = new ArrayList<>();
        this.tableController = new TableViewController(tableView);
        refreshDataTable();
    }

    public void refreshDataTable() {
        try {
            this.tableController.clearData();
            daftarKategori = repo.findAll();
            for (KategoriBarang k : daftarKategori) {
                Object[] row = {k.getKode(), k.getNama()};
                tableController.getModel().addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaftarKategoriBarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();

        setTitle("Daftar Kategori Barang");

        jToolBar1.setRollover(true);

        btnTambah.setText("Tambah");
        btnTambah.setFocusable(false);
        btnTambah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTambah.setMaximumSize(new java.awt.Dimension(120, 35));
        btnTambah.setMinimumSize(new java.awt.Dimension(120, 35));
        btnTambah.setPreferredSize(new java.awt.Dimension(120, 35));
        btnTambah.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTambah);

        btnUbah.setText("Ubah");
        btnUbah.setFocusable(false);
        btnUbah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUbah.setMaximumSize(new java.awt.Dimension(120, 35));
        btnUbah.setMinimumSize(new java.awt.Dimension(120, 35));
        btnUbah.setPreferredSize(new java.awt.Dimension(120, 35));
        btnUbah.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUbah);

        btnHapus.setText("Hapus");
        btnHapus.setFocusable(false);
        btnHapus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHapus.setMaximumSize(new java.awt.Dimension(120, 35));
        btnHapus.setMinimumSize(new java.awt.Dimension(120, 35));
        btnHapus.setPreferredSize(new java.awt.Dimension(120, 35));
        btnHapus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHapus);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        txtCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCariCaretUpdate(evt);
            }
        });

        jLabel1.setText("Cari");

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode", "Nama"
            }
        ));
        tableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableView);
        if (tableView.getColumnModel().getColumnCount() > 0) {
            tableView.getColumnModel().getColumn(0).setMinWidth(100);
            tableView.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableView.getColumnModel().getColumn(0).setMaxWidth(100);
            tableView.getColumnModel().getColumn(1).setMinWidth(150);
            tableView.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCariCaretUpdate
        this.tableController.getSorter().setRowFilter(RowFilter.regexFilter(txtCari.getText()));
    }//GEN-LAST:event_txtCariCaretUpdate

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        DataKategoriBarangView view = new DataKategoriBarangView(menuController, this, true);
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseClicked

    }//GEN-LAST:event_tableViewMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (tableController.isSelected()) {
            KategoriBarang kb = daftarKategori.get(tableController.getRowSelected());
            DataKategoriBarangView view = new DataKategoriBarangView(menuController, this, kb, true);
            view.setLocationRelativeTo(null);
            view.setResizable(false);
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Data kategori barang belum pilih", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (tableController.isSelected()) {
            try {
                KategoriBarang kb = daftarKategori.get(tableController.getRowSelected());
                repo.delete(kb.getId());
                refreshDataTable();
            } catch (SQLException ex) {
                Logger.getLogger(DaftarKategoriBarangView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Data kategori barang belum pilih", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
