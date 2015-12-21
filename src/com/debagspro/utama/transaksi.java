/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debagspro.utama;

import java.awt.event.KeyEvent;
import java.io.InputStream;
import com.debagspro.koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MOCHAMMAD FIQRI J-PC
 */
public class transaksi extends javax.swing.JFrame {
    
    Statement stt;
    Statement stt2;
    ResultSet rss;
    DefaultTableModel model;
    String tgl;
    /**
     * Creates new form transaksi
     */
    public transaksi() {
        initComponents();
        tabel_transaksi();
        tampil_tabel_transaksi();
        tglskrg();
        no_transaksi();
        kode_produk();
        this.setLocationRelativeTo(null);
    }
    
    public JTextField id_karyawan(){
          return txt_id_karyawan;
    }

    public void simpan_no(){
    Connection con = koneksi.getConnection();
        String sql = "INSERT INTO transaksi VALUES('"+txt_no_transaksi.getText()+"','"+txt_id_karyawan.getText()+"','"+tgl+"')";
        try {
            stt = con.createStatement();
            stt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
    
     public void tglskrg(){
        Date skrg= new Date();
        SimpleDateFormat format= new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
        SimpleDateFormat format2= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        tgl = format2.format(skrg);
        tgl_transaksi.setText(format.format(skrg));
    }
     
    public void no_transaksi(){
        Connection con = koneksi.getConnection();
        String sql = "SELECT id_transaksi FROM transaksi";
        try {
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            if(rss.last()){
                txt_no_transaksi.setText(String.valueOf(rss.getInt(1)+1));
            }
            else
                txt_no_transaksi.setText("1");
        } catch (Exception e) {
        }
    }
    
    public void runReportDefault(String sourcefilename, HashMap hash) {
        Connection con = koneksi.getConnection();
        try {
            InputStream report;
            report = getClass().getResourceAsStream(sourcefilename);
            JasperPrint jprint = JasperFillManager.fillReport(report,hash, con);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setFitPageZoomRatio();
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void bayar() {
        Connection con = koneksi.getConnection();
        String sql = "INSERT INTO pembayaran VALUES('"+txt_no_transaksi.getText()+"','"+txt_bayar.getText()+"','"+txt_kembalian.getText()+"')";
        try {
            stt = con.createStatement();
            stt.executeUpdate(sql);
        }
    
        catch (Exception e) {
        
        }
    }
    
    public void kode_produk(){
        Connection con = koneksi.getConnection();
        String sql = "SELECT * FROM tblproduk";
        try {
         stt = con.createStatement();
         rss= stt.executeQuery(sql);
         while(rss.next()){
             cmb_kode.addItem(rss.getString("id_produk"));
         }
        } 
        catch (Exception e) {
        
        }
    }
    
    private void tabel_transaksi(){
        model = new DefaultTableModel();
        tbl_transaksi.setModel(model);
        model.addColumn("ID Transaksi");
        model.addColumn("No Transaksi");
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Size");
        model.addColumn("Jenis");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
    }
    
    private void tampil_tabel_transaksi(){
       Connection con = koneksi.getConnection();
       try {
           stt = con.createStatement();
           String sql = "SELECT * FROM detail_transaksi WHERE id_transaksi = '"+txt_no_transaksi.getText()+"'";
           rss = stt.executeQuery(sql);
           while(rss.next()){
               Object[] o;
               o = new Object[9];
               o[0] = rss.getString(1);
               o[1] = rss.getString(2);
               o[2] = rss.getString(3);
               o[3] = rss.getString(4);
               o[4] = rss.getString(5);
               o[5] = rss.getString(6);
               o[6] = rss.getString(7);
               o[7] = rss.getString(8);
               o[8] = rss.getString(9);
               model.addRow(o);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    
   public void clear(){
        txt_nama_produk_t.setText("");
        txt_size_t.setText("");
        txt_jenis_t.setText("");
        txt_harga_t.setText("");
        txt_jumlah_t.setText("");
        txt_jumlah_t.setEnabled(true);
    }
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transaksi = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tgl_transaksi = new javax.swing.JTextField();
        txt_no_transaksi = new javax.swing.JTextField();
        txt_nama_produk_t = new javax.swing.JTextField();
        txt_jumlah_t = new javax.swing.JTextField();
        txt_harga_t = new javax.swing.JTextField();
        cmb_kode = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txt_id_karyawan = new javax.swing.JTextField();
        txt_total_semua = new javax.swing.JTextField();
        txt_size_t = new javax.swing.JTextField();
        txt_jenis_t = new javax.swing.JTextField();
        txt_bayar = new javax.swing.JTextField();
        txt_kembalian = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_total_semua1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        transaksi.setBorder(new javax.swing.border.MatteBorder(null));
        transaksi.setMinimumSize(new java.awt.Dimension(850, 850));
        transaksi.setPreferredSize(new java.awt.Dimension(850, 850));
        transaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Tanggal Transaksi");
        transaksi.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, -1, -1));

        jLabel13.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel13.setText("ID Transaksi");
        transaksi.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel14.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel14.setText("ID Produk");
        transaksi.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel15.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel15.setText("Nama Produk");
        transaksi.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel16.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel16.setText("Harga");
        transaksi.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel17.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel17.setText("Jumlah");
        transaksi.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        tgl_transaksi.setEditable(false);
        tgl_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_transaksiActionPerformed(evt);
            }
        });
        transaksi.add(tgl_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 190, -1));

        txt_no_transaksi.setEditable(false);
        txt_no_transaksi.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txt_no_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_no_transaksiActionPerformed(evt);
            }
        });
        transaksi.add(txt_no_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 93, -1));

        txt_nama_produk_t.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txt_nama_produk_t.setEnabled(false);
        transaksi.add(txt_nama_produk_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 250, -1));

        txt_jumlah_t.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txt_jumlah_t.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jumlah_tKeyTyped(evt);
            }
        });
        transaksi.add(txt_jumlah_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 70, -1));

        txt_harga_t.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txt_harga_t.setEnabled(false);
        txt_harga_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_harga_tActionPerformed(evt);
            }
        });
        transaksi.add(txt_harga_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 130, -1));

        cmb_kode.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        cmb_kode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_kodeItemStateChanged(evt);
            }
        });
        cmb_kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_kodeActionPerformed(evt);
            }
        });
        transaksi.add(cmb_kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 150, -1));

        jButton7.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jButton7.setText("Tambah");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        transaksi.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 80, -1));

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_transaksi);

        transaksi.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 1120, 95));

        jLabel6.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel6.setText("FORM TRANSAKSI");
        transaksi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel7.setText("ID Karyawan");
        transaksi.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel8.setText("Size");
        transaksi.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel9.setText("Jenis");
        transaksi.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel10.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel10.setText("Bayar");
        transaksi.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        jLabel11.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel11.setText("Kembalian");
        transaksi.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        jLabel18.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel18.setText("Total");
        transaksi.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Rincian Harga");
        transaksi.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));
        transaksi.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 1130, -1));
        transaksi.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1120, 10));

        jButton4.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jButton4.setText("Selanjutnya");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        transaksi.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 120, -1));

        jButton5.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jButton5.setText("Hapus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        transaksi.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 80, -1));

        jButton6.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jButton6.setText("Cetak");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        transaksi.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 80, -1));

        txt_id_karyawan.setEditable(false);
        transaksi.add(txt_id_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 50, -1));

        txt_total_semua.setEditable(false);
        txt_total_semua.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        txt_total_semua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_semuaActionPerformed(evt);
            }
        });
        transaksi.add(txt_total_semua, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 210, -1));

        txt_size_t.setEditable(false);
        txt_size_t.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        transaksi.add(txt_size_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 60, -1));

        txt_jenis_t.setEditable(false);
        txt_jenis_t.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        transaksi.add(txt_jenis_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 250, -1));

        txt_bayar.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        txt_bayar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_bayarInputMethodTextChanged(evt);
            }
        });
        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_bayarKeyTyped(evt);
            }
        });
        transaksi.add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 210, -1));

        txt_kembalian.setEditable(false);
        txt_kembalian.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        transaksi.add(txt_kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 210, -1));

        jButton1.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jButton1.setText("Bayar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        transaksi.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 80, -1));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Perum Dalung Permai Blok . GG No. 17 Kuta Utara - Bali ");

        jLabel26.setFont(new java.awt.Font("Corbel", 0, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("DebagsPro Shop");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel26))
                    .addComponent(jLabel25))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        transaksi.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        txt_total_semua1.setEditable(false);
        txt_total_semua1.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txt_total_semua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_semua1ActionPerformed(evt);
            }
        });
        transaksi.add(txt_total_semua1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 142, -1));

        jMenu2.setText("File");

        jMenuItem4.setText("Login Admin");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Log Out");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Laporan");

        jMenuItem2.setText("Laporan Penjualan");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tgl_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_transaksiActionPerformed

    private void txt_no_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_no_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_no_transaksiActionPerformed

    private void txt_jumlah_tKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlah_tKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && txt_jumlah_t.getText().length() < 10
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_txt_jumlah_tKeyTyped

    private void txt_harga_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_harga_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_harga_tActionPerformed

    private void cmb_kodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_kodeItemStateChanged
        Connection con = koneksi.getConnection();
        ResultSet rss2;
        String sql = "SELECT * FROM tblproduk WHERE id_produk = '"+cmb_kode.getSelectedItem().toString()+"'";
        try {
            stt = con.createStatement();
            rss2 = stt.executeQuery(sql);
            if(rss2.next()){
                txt_nama_produk_t.setText(rss2.getString("nama_produk"));
                txt_size_t.setText(rss2.getString("size"));
                txt_jenis_t.setText(rss2.getString("jenis"));
                txt_harga_t.setText(rss2.getString("harga"));
            }
            rss2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmb_kodeItemStateChanged

    private void cmb_kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_kodeActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Connection con = koneksi.getConnection();
        if(txt_jumlah_t.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Data tidak boleh kosong");
            txt_kembalian.setText("");
            txt_bayar.setText("");
        }
        else{
            int total = Integer.parseInt(txt_harga_t.getText()) * Integer.parseInt(txt_jumlah_t.getText());
            int simpan2 = 0;
            if(txt_total_semua.getText().equals("")){
                simpan2 = 0;
            }
            else
            simpan2 = Integer.valueOf(txt_total_semua.getText());

            String sql2 = "INSERT INTO detail_transaksi(id_transaksi,id_produk,nama_produk,size,jenis,harga,jumlah,total_harga) VALUES('"+txt_no_transaksi.getText()+"','"+cmb_kode.getSelectedItem().toString()+"','"+txt_nama_produk_t.getText()+"','"+txt_size_t.getText()+"','"+txt_jenis_t.getText()+"','"+txt_harga_t.getText()+"','"+txt_jumlah_t.getText()+"','"+total+"')";
            try {
                simpan_no();
                stt2 = con.createStatement();
                stt2.executeUpdate(sql2);
                txt_total_semua.setText(String.valueOf(simpan2+total));
                JOptionPane.showMessageDialog(this, "Barang Berhasil Dipilih");
                tabel_transaksi();
                tampil_tabel_transaksi();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        no_transaksi();
        tabel_transaksi();
        tampil_tabel_transaksi();
        txt_total_semua.setText("");
        txt_bayar.setText("");
        txt_kembalian.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Connection con = koneksi.getConnection();
        int row = tbl_transaksi.getSelectedRow();
        try {
            stt = con.createStatement();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Anda Belum Memilih Tabel");
            }
            else{
                int harga = Integer.parseInt((String) tbl_transaksi.getModel().getValueAt(row, 6));
                int banyak = Integer.parseInt((String) tbl_transaksi.getModel().getValueAt(row, 7));
                int total = Integer.parseInt(txt_total_semua.getText());
                String sql = "DELETE FROM detail_transaksi WHERE id_detail_transaksi = '"+tbl_transaksi.getModel().getValueAt(row, 0)+"'";
                stt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                txt_total_semua.setText(String.valueOf(total-(harga*banyak)));
                tabel_transaksi();
                tampil_tabel_transaksi();
                clear();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Connection con = koneksi.getConnection();
        String NamaFile = "/com/debagspro/report/struk_debags.jasper";
        HashMap hash = new HashMap();
        try {
            hash.put("idtransaksi", txt_no_transaksi.getText());
            runReportDefault(NamaFile,hash);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_total_semuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_semuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_semuaActionPerformed

    private void txt_bayarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_bayarInputMethodTextChanged
        if(txt_jumlah_t.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Data tidak boleh kosong");
        }
        int b = Integer.parseInt(txt_jumlah_t.getText());
        if ( b < 0 ) {
            JOptionPane.showMessageDialog(rootPane, " Jumlah Yang di Input Harus Lebih dari 0");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarInputMethodTextChanged

    private void txt_bayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') && txt_bayar.getText().length() < 10
            || (c == KeyEvent.VK_BACK_SPACE)
            || (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = koneksi.getConnection();

        if (txt_bayar.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Pembayaran tidak boleh kosong");
        }

        else {
            int a = Integer.parseInt(txt_bayar.getText());
            int b = Integer.parseInt(txt_total_semua.getText());

            if(a < b) {
                JOptionPane.showMessageDialog(rootPane, "Pembayaran Kurang!");
                txt_kembalian.setText("0");
            }

            else {
                txt_kembalian.setText(String.valueOf(a-b));
                bayar();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_total_semua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_semua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_semua1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        login_admin adm = new login_admin();
        this.setVisible(false);
        adm.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        laporan lpr = new laporan();
        this.setVisible(false);
        lpr.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        login_karyawan lgn = new login_karyawan();
        this.setVisible(false);
        lgn.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmb_kode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tgl_transaksi;
    private javax.swing.JPanel transaksi;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_harga_t;
    private javax.swing.JTextField txt_id_karyawan;
    private javax.swing.JTextField txt_jenis_t;
    private javax.swing.JTextField txt_jumlah_t;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_nama_produk_t;
    private javax.swing.JTextField txt_no_transaksi;
    private javax.swing.JTextField txt_size_t;
    private javax.swing.JTextField txt_total_semua;
    private javax.swing.JTextField txt_total_semua1;
    // End of variables declaration//GEN-END:variables
}
