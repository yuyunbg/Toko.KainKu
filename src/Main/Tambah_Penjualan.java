/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;
import static Main.Tambah_Penjualan.txt_harga;
import static Main.Tambah_Penjualan.txt_namabarang;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Tambah_Penjualan extends javax.swing.JFrame {

    /**
     * Creates new form Ubah_Penjualan
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
        lbltotal_harga.setText("Rp "+ totalBiaya +",00");
    }
    private void autonumber(){
        try {
            String sql = "SELECT * FROM penjualan ORDER BY kode_penjualan DESC";
            java.sql.Connection conn=(Connection)Konfigurasi.konfigurasiDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet r=stm.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("kode_penjualan").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";
                
                if(TR.length()==1)
                {Nol = "00";}
                else if(TR.length()==2)
                {Nol = "0";}
                else if(TR.length()==3)
                {Nol = "";}
                txt_kodepenjualan.setText("PJ" + Nol + TR);
            } else {
                txt_kodepenjualan.setText("PJ001");
            }

        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            txt_kodepenjualan.getText(),
            txt_IDbarang.getText(),
            txt_namabarang.getText(),
            txt_jumlah.getText(),
            txt_harga.getText(),
            lbltotal_harga.getText()
        });
    }
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    public void utama(){
        txt_kodepenjualan.setText("");
        txt_IDbarang.setText("");
        txt_namabarang.setText("");
        txt_harga.setText("");
        txt_jumlah.setText("");
        autonumber();
    }
    public void clear(){
        lbltotal_harga.setText("0");
    }
    
    public void clear2(){
        txt_IDbarang.setText("");
        txt_namabarang.setText("");
        txt_harga.setText("");
        txt_jumlah.setText("");
    }
    public void tambahTransaksi(){
        int jumlah, harga, total;
        
        jumlah = Integer.valueOf(txt_jumlah.getText());
        harga = Integer.valueOf(txt_harga.getText());
        total = jumlah * harga;
        
        lbltotal_harga.setText(String.valueOf(total));
        
        loadData();
        totalBiaya();
        clear2();
        txt_IDbarang.requestFocus();
    }
    public Tambah_Penjualan() {
        initComponents();
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("Kode Penjualan");
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total Harga");
        
        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        
        lbl_Tanggal.setText(s.format(date));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbltotal_harga = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        btnTambah1 = new javax.swing.JButton();
        btnHapus1 = new javax.swing.JButton();
        jc_kodekaryawan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_kodepenjualan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_IDbarang = new javax.swing.JTextField();
        txt_namabarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_Tanggal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 640, 210));

        lbltotal_harga.setBackground(new java.awt.Color(0, 153, 153));
        lbltotal_harga.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbltotal_harga.setText("Rp. 0");
        jPanel1.add(lbltotal_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 304, 50));

        btnTambah.setBackground(new java.awt.Color(0, 102, 102));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 100, 50));

        btnHapus.setBackground(new java.awt.Color(255, 0, 51));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 100, 50));

        btnBatal.setBackground(new java.awt.Color(255, 0, 51));
        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 100, 47));

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
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 90, 47));

        btn_cari.setBackground(new java.awt.Color(0, 153, 153));
        btn_cari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 250, 60, -1));

        btnTambah1.setBackground(new java.awt.Color(0, 102, 102));
        btnTambah1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah1.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah1.setText("Tambah");
        btnTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambah1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 90, 50));

        btnHapus1.setBackground(new java.awt.Color(255, 0, 51));
        btnHapus1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus1.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus1.setText("Hapus");
        btnHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapus1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 90, 50));

        jc_kodekaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jc_kodekaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 170, -1));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Kode Karyawan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Kode Penjualan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        jPanel1.add(txt_kodepenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 169, -1));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("ID Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        txt_IDbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDbarangActionPerformed(evt);
            }
        });
        jPanel1.add(txt_IDbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 136, -1));
        jPanel1.add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 160, -1));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Nama Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 140, -1));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Harga");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, -1));

        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        jPanel1.add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 130, -1));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Jumlah");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, -1, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Date :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        lbl_Tanggal.setForeground(new java.awt.Color(102, 102, 102));
        lbl_Tanggal.setText("Tanggal");
        jPanel1.add(lbl_Tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Tambah Penjualan.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        new Penjualan().setVisible(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String noTransaksi = txt_kodepenjualan.getText();
        String tanggal = lbl_Tanggal.getText();

        try {
            String sql = "INSERT INTO `penjualan`(`kode_penjualan`, `waktu`, `kode_karyawan`) VALUES ('"+noTransaksi+"','"
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
                String sql = "INSERT INTO `detail_penjualan` (`id_penjual`, `jumlah`, `total_harga`, `kode_produk`, "
                + "`kode_penjualan`) VALUES (NULL, '"
                + jTable1.getValueAt(i, 3) +"','"+ jTable1.getValueAt(i, 5)
                +"','"+ jTable1.getValueAt(i, 1) +"','"+ jTable1.getValueAt(i, 0)
                +"')";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("simpan penjualan rinci error");
        }
        clear();
        utama();
        autonumber();
        kosong();
        lbltotal_harga.setText("Rp. 0");
        this.setVisible(false);
        new Penjualan().setVisible(true);

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        List_Barang a = new List_Barang();
        a.setVisible(true);
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btnTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambah1ActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_btnTambah1ActionPerformed

    private void btnHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapus1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
    }//GEN-LAST:event_btnHapus1ActionPerformed

    private void txt_IDbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDbarangActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_txt_jumlahActionPerformed

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
            java.util.logging.Logger.getLogger(Tambah_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tambah_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tambah_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tambah_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tambah_Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapus1;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTambah1;
    private javax.swing.JButton btn_cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jc_kodekaryawan;
    private javax.swing.JLabel lbl_Tanggal;
    private javax.swing.JTextField lbltotal_harga;
    public static javax.swing.JTextField txt_IDbarang;
    public static javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kodepenjualan;
    public static javax.swing.JTextField txt_namabarang;
    // End of variables declaration//GEN-END:variables
}
