/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.view.menu.pelanggan;

import aplikasi.config.KoneksiDB;
import aplikasi.entity.Pelanggan;
import aplikasi.repository.RepoPelanggan;
import aplikasi.service.ServicePelanggan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dimmaryanto
 */
public class DataPelanggan extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private final RepoPelanggan repo = new ServicePelanggan(KoneksiDB.getDataSource());
    private Boolean update;
    private Pelanggan pelanggan;
    private DaftarPelanggan daftarPelanggan;

    public Boolean isUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    /**
     * Creates new form DataPelanggan
     *
     * @param parent
     * @param modal
     */
    public DataPelanggan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setUpdate(false);
        this.daftarPelanggan = null;
        try {
            StringBuilder sb;
            sb = new StringBuilder("PEL").append(String.format("%02d", repo.findAll().size() + 1));
            this.pelanggan = new Pelanggan();
            this.pelanggan.setKode(sb.toString());
            this.pelanggan.setAgen(false);
            txtKode.setText(pelanggan.getKode());
        } catch (SQLException ex) {
            Logger.getLogger(DataPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DataPelanggan(java.awt.Frame parent, DaftarPelanggan daftarPelangganView, boolean modal) {
        super(parent, modal);
        initComponents();
        setUpdate(false);
        this.daftarPelanggan = daftarPelangganView;
        try {
            StringBuilder sb;
            sb = new StringBuilder("PEL").append(String.format("%02d", repo.findAll().size() + 1));
            this.pelanggan = new Pelanggan();
            this.pelanggan.setKode(sb.toString());
            this.pelanggan.setAgen(false);
            txtKode.setText(pelanggan.getKode());
        } catch (SQLException ex) {
            Logger.getLogger(DataPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DataPelanggan(java.awt.Frame parent, boolean modal, Pelanggan p) {
        super(parent, modal);
        initComponents();
        setUpdate(true);
        setFields(p);
        this.pelanggan = p;
    }

    public DataPelanggan(java.awt.Frame parent, boolean modal, Pelanggan p, DaftarPelanggan daftarPelanggan) {
        super(parent, modal);
        initComponents();
        setUpdate(true);
        setFields(p);
        this.daftarPelanggan = daftarPelanggan;
        this.pelanggan = p;
    }

    private void setFields(Pelanggan p) {
        txtKode.setText(p.getKode());
        txtNama.setText(p.getNama());
        txtAlamat.setText(p.getAlamat());
        txtTelp.setText(p.getTlp());
    }

    private void clearFields() {
        txtKode.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelp.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSimpan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnSimpan.setText("Simpan");
        btnSimpan.setFocusable(false);
        btnSimpan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSimpan.setMaximumSize(new java.awt.Dimension(120, 35));
        btnSimpan.setMinimumSize(new java.awt.Dimension(120, 35));
        btnSimpan.setPreferredSize(new java.awt.Dimension(120, 35));
        btnSimpan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSimpan);

        btnKembali.setText("Kembali");
        btnKembali.setFocusable(false);
        btnKembali.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKembali.setMaximumSize(new java.awt.Dimension(120, 35));
        btnKembali.setMinimumSize(new java.awt.Dimension(120, 35));
        btnKembali.setPreferredSize(new java.awt.Dimension(120, 35));
        btnKembali.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnKembali);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pelanggan"));

        jLabel1.setText("Kode");

        txtKode.setEditable(false);

        jLabel2.setText("Nama");

        jLabel3.setText("No Telp");

        jLabel4.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        pelanggan.setNama(txtNama.getText());
        pelanggan.setTlp(txtTelp.getText());
        pelanggan.setAlamat(txtAlamat.getText());
        if (isUpdate()) {
            try {
                repo.update(pelanggan);
                dispose();
                if (daftarPelanggan != null) {
                    daftarPelanggan.refreshDataTable();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Tidak dapat menyimpan data baru pelanggan", "Data pelanggan", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DataPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                repo.save(pelanggan);
                dispose();
                if (daftarPelanggan != null) {
                    daftarPelanggan.refreshDataTable();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Tidak dapat menyimpan perubahan data pelanggan", "Data pelanggan", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DataPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}
