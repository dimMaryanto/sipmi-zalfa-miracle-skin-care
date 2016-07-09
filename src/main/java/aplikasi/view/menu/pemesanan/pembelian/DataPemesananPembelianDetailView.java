/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.pemesanan.pembelian;

import aplikasi.config.KoneksiDB;
import aplikasi.config.ValueFormatterFactory;
import aplikasi.controller.TableViewController;
import aplikasi.entity.Barang;
import aplikasi.entity.KategoriBarang;
import aplikasi.entity.PesananPembelian;
import aplikasi.entity.PesananPembelianDetail;
import aplikasi.repository.RepoBarang;
import aplikasi.service.ServiceBarang;
import aplikasi.view.MainMenuView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dimmaryanto
 */
public class DataPemesananPembelianDetailView extends javax.swing.JDialog {

    private final TableViewController tableController;
    private final RepoBarang repoBarang;
    private List<Barang> daftarBarang = new ArrayList<>();
    private final PesananPembelianDetail pesan;
    private final PesananPembelian pesananPembelian;

    /**
     * Creates new form DataPemesananPembelianDetailView
     *
     * @param parent
     * @param modal
     */
    public DataPemesananPembelianDetailView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.tableController = new TableViewController(tableView);
        this.repoBarang = new ServiceBarang(KoneksiDB.getDataSource());
        this.pesan = new PesananPembelianDetail();
        this.pesananPembelian = null;
        this.pesan.setPesananPembelian(pesananPembelian);
        refreshDataTable();
    }

    DataPemesananPembelianDetailView(java.awt.Frame parent, boolean modal, PesananPembelian pesanBarang, DataPemesananPembelianView pemesananPembelianController) {
        super(parent, modal);
        initComponents();
        this.tableController = new TableViewController(tableView);
        this.repoBarang = new ServiceBarang(KoneksiDB.getDataSource());
        this.pesan = new PesananPembelianDetail();
        this.pesananPembelian = pesanBarang;
        this.pesan.setPesananPembelian(pesananPembelian);
        refreshDataTable();
    }

    public void refreshDataTable() {
        try {
            tableController.clearData();
            daftarBarang = repoBarang.findAll();
            for (Barang barang : daftarBarang) {
                Object[] row = {barang.getKode(), barang.getNama(), barang.getJumlah()};
                tableController.getModel().addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataPemesananPembelianDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setFields(Barang brg) {
        txtKode.setText(brg.getKode());
        txtNama.setText(brg.getNama());
        KategoriBarang kb = brg.getKategori();
        txtKodeKategori.setText(kb.getKode());
        txtNamaKategori.setText(kb.getNama());
        txtHargaBeli.setText(ValueFormatterFactory.getCurrency(brg.getHargaBeli()));
        txtStok.setText(ValueFormatterFactory.getNumberBulat(brg.getJumlah()));
    }

    private void clearFields() {
        txtKode.setText("");
        txtNama.setText("");
        txtKodeKategori.setText("");
        txtNamaKategori.setText("");
        txtHargaBeli.setText("");
        txtStok.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtKodeKategori = new javax.swing.JTextField();
        txtNamaKategori = new javax.swing.JTextField();
        txtHargaBeli = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pilih Barang Belanjaan");
        setResizable(false);

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

        btnKembali.setText("Kembali");
        btnKembali.setFocusable(false);
        btnKembali.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKembali.setMaximumSize(new java.awt.Dimension(120, 35));
        btnKembali.setMinimumSize(new java.awt.Dimension(120, 35));
        btnKembali.setPreferredSize(new java.awt.Dimension(120, 35));
        btnKembali.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKembali);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Barang"));
        jPanel1.setMinimumSize(new java.awt.Dimension(350, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 412));

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Kode Kategori");

        jLabel4.setText("Nama Kategori");

        jLabel5.setText("Harga Beli (kisaran)");

        jLabel6.setText("Stok");

        jLabel7.setText("Jumlah yg dibeli");

        txtKode.setEditable(false);

        txtNama.setEditable(false);

        txtKodeKategori.setEditable(false);

        txtNamaKategori.setEditable(false);

        txtHargaBeli.setEditable(false);
        txtHargaBeli.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtStok.setEditable(false);
        txtStok.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtJumlah.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(txtKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaKategori)
                                    .addComponent(txtHargaBeli)
                                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKodeKategori)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamaKategori)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHargaBeli)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtStok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Barang"));

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Stok"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            tableView.getColumnModel().getColumn(2).setMinWidth(80);
            tableView.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableView.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseClicked
        if (tableController.isSelected()) {
            Barang brg = daftarBarang.get(tableController.getRowSelected());
            setFields(brg);
        } else {
            clearFields();
        }
    }//GEN-LAST:event_tableViewMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (tableController.isSelected()) {
            Barang brg = daftarBarang.get(tableController.getRowSelected());
            this.pesan.setBarang(brg);
            this.pesan.setJumlah(Integer.valueOf(txtJumlah.getValue().toString()));

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Barang belum dipilih", getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DataPemesananPembelianDetailView dialog = new DataPemesananPembelianDetailView(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JSpinner txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtKodeKategori;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaKategori;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
