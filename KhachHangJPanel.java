/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class KhachHangJPanel extends javax.swing.JPanel {
    DefaultTableModel tabModel;
    /**
     * Creates new form KhachHangJPanel
     */
    public KhachHangJPanel() throws SQLException {
        initComponents();
        tabModel = (DefaultTableModel)tabKh.getModel();
        
        showKhachhang();
    }

    private void showKhachhang() throws SQLException{
        List<Khach_hang> khachhangList = null;
        try {
             khachhangList = Khach_hangDao.findAll();
        } catch (ClassNotFoundException ex) {
         Logger.getLogger(KhachHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabModel.setRowCount(0);
        
        khachhangList.forEach((kh) -> {
            tabModel.addRow(new Object[] {tabModel.getRowCount()+1, kh.getMakh(), kh.getHoten(), kh.getSdt(), kh.getNgaysinh(), kh.getDiachi()});
        });
    }
     private void LoadData() throws ClassNotFoundException, SQLException, ParseException
    {
        if (tabKh.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tabKh.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<Khach_hang> lstkh = Khach_hangDao.findAll();
            //-- Xác định là dịch vụ nào đang được click
            
            Khach_hang kh = lstkh.get(i);
            //--- Set giá trị cho các control
            
            txtMakh.setText(kh.getMakh());
                 txtTenkh.setText(kh.getHoten());
                SimpleDateFormat ngaytt= new SimpleDateFormat("yyyy-MM-dd");
                Date date= ngaytt.parse(kh.getNgaysinh());
                jDateChooser1.setDate(date);
                String sdt=String.valueOf(kh.getSdt());
               txtSdt.setText(sdt);
                txtDiachi.setText(kh.getDiachi());
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMakh = new javax.swing.JTextField();
        txtTenkh = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        btnluu = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabKh = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(153, 255, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Mã khách hàng");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Họ tên");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Số điện thoại");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ");

        btnluu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-them.png"))); // NOI18N
        btnluu.setText("Thêm");
        btnluu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-lammoi.png"))); // NOI18N
        btnLammoi.setText("Làm mới");
        btnLammoi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-timkiem.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        tabKh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã khách hàng", "Họ tên", "SĐT", "Ngày sinh", "Địa chỉ"
            }
        ));
        tabKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabKh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtMakh, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnTimkiem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLammoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtMakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        txtMakh.setText("");
        txtTenkh.setText("");
        txtDiachi.setText("");
        jDateChooser1.setDateFormatString("");
        txtSdt.setText("");
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
            //List<Khach_hang> khachhangList = null;
            // TODO add your handling code here:
            //String makh = txtMakh.getText();
//            String hoten = txtTenkh.getText();
//            String diachi = txtDiachi.getText();
//            String ngaysinh = txtNgaysinh.getText();
//            int sdt = Integer.parseInt(txtSdt.getText());
            
            //Khach_hang kh = new Khach_hang(makh, hoten, diachi, ngaysinh, sdt);
            
            StringBuilder sb = new StringBuilder();
            if(txtMakh.getText().equals(""))
            {
                sb.append("Ma khach hang khong duoc de trong");
                txtMakh.setBackground(Color.red);
            }else
                txtMakh.setBackground(Color.WHITE);
            if(sb.length()>0)
            {
                JOptionPane.showMessageDialog(this, sb);
                return;
            }
            try{
                Khach_hang kh = new Khach_hang();
                kh.setMakh(txtMakh.getText());
                kh.setHoten(txtTenkh.getText());
                kh.setDiachi(txtDiachi.getText());
                SimpleDateFormat ngaytt= new SimpleDateFormat("yyyy-MM-dd");
                String date= ngaytt.format(jDateChooser1.getDate());
                kh.setNgaysinh( date);
                kh.setSdt(Integer.parseInt(txtSdt.getText()));
                
                Khach_hangDao dao= new Khach_hangDao();
                dao.insert(kh);
                JOptionPane.showMessageDialog(this, "khach hang moi da duoc them ");
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showKhachhang();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnluuActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        if(txtMakh.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "can nhap ma khach hang can tim!!!");
            return;
        }
        
        try{
            Khach_hangDao dao = new Khach_hangDao();
            
            Khach_hang kh = dao.findID(txtMakh.getText());
            
            if(kh !=null)
            {
                txtTenkh.setText(kh.getHoten());
                SimpleDateFormat ngaytt= new SimpleDateFormat("yyyy-MM-dd");
                Date date= ngaytt.parse(kh.getNgaysinh());
                jDateChooser1.setDate(date);
                String sdt=String.valueOf(kh.getSdt());
               txtSdt.setText(sdt);
                txtDiachi.setText(kh.getDiachi());
            }else
                JOptionPane.showMessageDialog(this, "khong tim thay ma khach hang!!!");
        }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         StringBuilder sb = new StringBuilder();
            if(txtMakh.getText().equals(""))
            {
                sb.append("Ma khach hang khong duoc de trong");
                txtMakh.setBackground(Color.red);
            }else
                txtMakh.setBackground(Color.WHITE);
            if(sb.length()>0)
            {
                JOptionPane.showMessageDialog(this, sb);
                return;
            }
            try{
                Khach_hang kh = new Khach_hang();
                kh.setMakh(txtMakh.getText());
                kh.setHoten(txtTenkh.getText());
                kh.setDiachi(txtDiachi.getText());
                SimpleDateFormat ngaytt= new SimpleDateFormat("yyyy-MM-dd");
                String date= ngaytt.format(jDateChooser1.getDate());
                kh.setNgaysinh( date);
                kh.setSdt(Integer.parseInt(txtSdt.getText()));
                
                Khach_hangDao dao= new Khach_hangDao();
                dao.update(kh);
                JOptionPane.showMessageDialog(this, "khach hang moi da duoc sua ");
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showKhachhang();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
            StringBuilder sb = new StringBuilder();
            if(txtMakh.getText().equals(""))
            {
                sb.append("Ma khach hang khong duoc de trong");
                txtMakh.setBackground(Color.red);
            }else
                txtMakh.setBackground(Color.WHITE);
            if(sb.length()>0)
            {
                JOptionPane.showMessageDialog(this, sb);
                return;
            }
            if(JOptionPane.showConfirmDialog(this, "ban co muon xoa khach hang khong?")==JOptionPane.NO_OPTION)
            {
                return;
            }
            try{
                Khach_hangDao dao= new Khach_hangDao();
                dao.delete(txtMakh.getText());
                
                JOptionPane.showMessageDialog(this, "khach hang da duoc xoa ");
                btnLammoiActionPerformed(evt);
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showKhachhang();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tabKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabKhMouseClicked
        try {
            LoadData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhachHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabKhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnluu;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabKh;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenkh;
    // End of variables declaration//GEN-END:variables
}
