/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DichvuJPanel extends javax.swing.JPanel {
    DefaultTableModel tabModel;
    /**
     * Creates new form DichvuJPanel
     */
    public DichvuJPanel() throws SQLException {
        initComponents();
        tabModel = (DefaultTableModel)tabDV.getModel();
        
        showDichvu();
    }
    
    
    private void showDichvu() throws SQLException{
        List<Dich_vu> dichvuList = null;
        try {
             dichvuList = Dich_vuDao.findAll();
        } catch (ClassNotFoundException ex) {
         Logger.getLogger(DichvuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabModel.setRowCount(0);
        
        dichvuList.forEach((dv) -> {
            tabModel.addRow(new Object[] {tabModel.getRowCount()+1, dv.getMadv(), dv.getTendv(), dv.getGia()});
        });
    }
    private void LoadData() throws ClassNotFoundException, SQLException
    {
        if (tabDV.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tabDV.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<Dich_vu> lstdv = Dich_vuDao.findAll();
            //-- Xác định là dịch vụ nào đang được click
            
            Dich_vu dv = lstdv.get(i);
            //--- Set giá trị cho các control
            txtMadv.setText(dv.getMadv());
            txtTendv.setText(dv.getTendv());
                String gia=String.valueOf(dv.getGia());
                txtGia.setText(gia);
            
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
        txtMadv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTendv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDV = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 0, 204));

        jLabel1.setText("Mã dịch vụ");

        jLabel2.setText("Tên dịch vụ");

        jLabel3.setText("Giá");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        tabDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Giá"
            }
        ));
        tabDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabDV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMadv, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(36, 36, 36))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(23, 23, 23)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTendv, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnLammoi)
                                .addGap(41, 41, 41)
                                .addComponent(btnTimkiem)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMadv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTendv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb= new StringBuilder();
        if(txtMadv.getText().equals(""))
        {
            sb.append("Ma dich vu khong duoc de trong!!!");
            txtMadv.setBackground(Color.red);
        }
        else
            txtMadv.setBackground(Color.WHITE);
        if(sb.length()>0)
        {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            Dich_vu dv= new Dich_vu();
            dv.setMadv(txtMadv.getText());
            dv.setTendv(txtTendv.getText());
            dv.setGia(Integer.parseInt(txtGia.getText()));
            
            Dich_vuDao dao= new Dich_vuDao();
            dao.insert(dv);
             JOptionPane.showMessageDialog(this, "dich vu moi da duoc them ");
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {                                 
            showDichvu();
        } catch (SQLException ex) {
            Logger.getLogger(DichvuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        txtMadv.setText("");
        txtTendv.setText("");
        txtGia.setText("");
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        if(txtMadv.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "can nhap ma dich vu can tim!!!");
            return;
        }
        
        try{
            Dich_vuDao dao = new Dich_vuDao();
            
            Dich_vu dv = dao.findID(txtMadv.getText());
            
            if(dv !=null)
            {
                txtTendv.setText(dv.getTendv());
                String gia=String.valueOf(dv.getGia());
                txtGia.setText(gia);
            }else
                JOptionPane.showMessageDialog(this, "khong tim thay ma dich vu!!!");
        }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb= new StringBuilder();
        if(txtMadv.getText().equals(""))
        {
            sb.append("Ma dich vu khong duoc de trong!!!");
            txtMadv.setBackground(Color.red);
        }
        else
            txtMadv.setBackground(Color.WHITE);
        if(sb.length()>0)
        {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            Dich_vu dv= new Dich_vu();
            dv.setMadv(txtMadv.getText());
            dv.setTendv(txtTendv.getText());
            dv.setGia(Integer.parseInt(txtGia.getText()));
            
            Dich_vuDao dao= new Dich_vuDao();
            dao.update(dv);
             JOptionPane.showMessageDialog(this, "dich vu moi da duoc sua");
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showDichvu();
        } catch (SQLException ex) {
            Logger.getLogger(DichvuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
            if(txtMadv.getText().equals(""))
            {
                sb.append("Ma dich vu khong duoc de trong");
                txtMadv.setBackground(Color.red);
            }else
                txtMadv.setBackground(Color.WHITE);
            if(sb.length()>0)
            {
                JOptionPane.showMessageDialog(this, sb);
                return;
            }
            if(JOptionPane.showConfirmDialog(this, "ban co muon xoa dich vu khong?")==JOptionPane.NO_OPTION)
            {
                return;
            }
            try{
                Dich_vuDao dao= new Dich_vuDao();
                dao.delete(txtMadv.getText());
                
                JOptionPane.showMessageDialog(this, "dich vu da duoc xoa ");
                btnLammoiActionPerformed(evt);
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showDichvu();
        } catch (SQLException ex) {
            Logger.getLogger(DichvuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tabDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDVMouseClicked
        try {
            // TODO add your handling code here:
            LoadData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DichvuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DichvuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabDVMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabDV;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMadv;
    private javax.swing.JTextField txtTendv;
    // End of variables declaration//GEN-END:variables
}
