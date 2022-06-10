/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;
//import static Main.Tambah_Pembelian.txt_IDpembelian;
//import static Main.Tambah_Pembelian.txt_harga;
//import static Main.Tambah_Pembelian.txt_namabarang;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author iwancell
 */



public class Tambah_Pembelian extends javax.swing.JFrame {

    /**
     * Creates new form Tambah_Pembelian
     */
    String Tanggal;
    private DefaultTableModel model;
    
    public void totalBiaya(){
        int jumlahBaris = jTable1.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txTampil.setText("Rp "+ totalBiaya +",00");
    }
    private void autonumber(){
        try {
            String sql = "SELECT * FROM pembelian ORDER BY kode_pembelian DESC";
            java.sql.Connection conn=(Connection)Konfigurasi.konfigurasiDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet r=stm.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("kode_pembelian").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "00";}
                else if(TR.length()==2)
                {Nol = "0";}
                else if(TR.length()==3)
                {Nol = "";}
                txt_kodepembelian.setText("PB" + Nol + TR);
            } else {
                txt_kodepembelian.setText("PB001");
            }

        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }

    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            txt_kodepembelian.getText(),
            txt_IDpembelian.getText(),
            txt_namabarang.getText(),
            txJumlah.getText(),
            txt_harga.getText(),
            txTampil.getText()
        });
    }
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txt_kodepembelian.setText("");
        txt_IDpembelian.setText("");
        txt_namabarang.setText("");
        txt_harga.setText("");
        txJumlah.setText("");
        autonumber();
    }
    public void clear(){
        txTampil.setText("0");
    }
    
    public void clear2(){
        txt_IDpembelian.setText("");
        txt_namabarang.setText("");
        txt_harga.setText("");
        txJumlah.setText("");
    }
    
    public void tambahTransaksi(){
        int jumlah, harga, total;
        
        jumlah = Integer.valueOf(txJumlah.getText());
        harga = Integer.valueOf(txt_harga.getText());
        total = jumlah * harga;
        
        txTampil.setText(String.valueOf(total));
        
        loadData();
        totalBiaya();
        clear2();
        txt_IDpembelian.requestFocus();
    }
    public Tambah_Pembelian() {
        initComponents();
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("Kode Pembelian");
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total Harga");
        
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        
        txTanggal.setText(s.format(date));
        autonumber();
    jc_kodekaryawan.removeAllItems();
        tampilKaryawan();
    }
    
private void tampilKaryawan(){
    try{
        String sql = "SELECT * FROM karyawan where not `kode_karyawan` = 'K666' AND NOT"
                +"`kode_karyawan` = "+ "'K555' ORDER BY kode_karyawan";
        java.sql.Connection conn=(Connection)Konfigurasi.konfigurasiDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {
                jc_kodekaryawan.addItem(rs.getString(1));
                }
            } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_namabarang = new javax.swing.JTextField();
        txt_kodepembelian = new javax.swing.JTextField();
        jc_kodekaryawan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txJumlah = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txTanggal = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txTampil = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_IDpembelian = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Kode Karyawan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Kode Pembelian");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("ID Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Nama Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 242, 60, 30));
        jPanel1.add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 140, -1));

        txt_kodepembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kodepembelianActionPerformed(evt);
            }
        });
        jPanel1.add(txt_kodepembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 169, -1));

        jc_kodekaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jc_kodekaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 170, -1));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Harga");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 140, -1));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Jumlah");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, -1, -1));

        txJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJumlahActionPerformed(evt);
            }
        });
        jPanel1.add(txJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 140, -1));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Date :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        txTanggal.setForeground(new java.awt.Color(102, 102, 102));
        txTanggal.setText("Tanggal");
        jPanel1.add(txTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        btnTambah.setBackground(new java.awt.Color(0, 102, 102));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 100, 50));

        btnHapus.setBackground(new java.awt.Color(255, 0, 51));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 100, 50));

        txTampil.setBackground(new java.awt.Color(0, 153, 153));
        txTampil.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txTampil.setText("Rp. 0");
        jPanel1.add(txTampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 304, 50));

        btnBatal.setBackground(new java.awt.Color(255, 0, 51));
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 100, 47));

        btnSimpan.setBackground(new java.awt.Color(0, 102, 102));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setToolTipText("");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 100, 47));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 610, 190));
        jPanel1.add(txt_IDpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Tambah Pembelian.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    List_Barang1 a = new List_Barang1();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_kodepembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kodepembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kodepembelianActionPerformed

    private void txJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJumlahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_txJumlahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Pembelian().setVisible(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String noTransaksi = txt_kodepembelian.getText();
        String tanggal = txTanggal.getText();

        try {
            String sql = "INSERT INTO `pembelian`(`kode_pembelian`, `waktu`, `kode_karyawan`) VALUES ('"+noTransaksi+"','"
            +tanggal+"','"+jc_kodekaryawan.getSelectedItem()+"')";
            java.sql.Connection conn=(Connection)Konfigurasi.konfigurasiDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);

            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Connection c = (Connection)Konfigurasi.konfigurasiDB();
            int baris = jTable1.getRowCount();

            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO `detail_pembelian`(`id_pembeli`, `jumlah`, `total_harga`, `kode_produk`, `kode_pembelian`) VALUES (NULL, '"
                + jTable1.getValueAt(i, 3) +"','"+ jTable1.getValueAt(i, 5)
                +"','"+ jTable1.getValueAt(i, 1) +"','"+ jTable1.getValueAt(i, 0)
                +"')";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("simpan Pembelian rinci error");
        }
        clear();
        utama();
        autonumber();
        kosong();
        txTampil.setText("Rp. 0");
        this.setVisible(false);
        new Pembelian().setVisible(true);
    }//GEN-LAST:event_btnSimpanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tambah_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tambah_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tambah_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tambah_Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tambah_Pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jc_kodekaryawan;
    private javax.swing.JTextField txJumlah;
    private javax.swing.JTextField txTampil;
    private javax.swing.JLabel txTanggal;
    public static javax.swing.JTextField txt_IDpembelian;
    public static javax.swing.JTextField txt_harga;
    public javax.swing.JTextField txt_kodepembelian;
    public static javax.swing.JTextField txt_namabarang;
    // End of variables declaration//GEN-END:variables
}
