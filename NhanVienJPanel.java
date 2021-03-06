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
public class NhanVienJPanel extends javax.swing.JPanel {
    DefaultTableModel tabModel;
    /**
     * Creates new form NhanVienJPanel
     */
    public NhanVienJPanel() throws SQLException {
        initComponents();
        tabModel = (DefaultTableModel)tabNV.getModel();
        
        showNhanvien();
        
    }
    
    private void showNhanvien() throws SQLException{
        List<Nhan_vien> nhanvienList = null;
        try {
             nhanvienList = Nhan_vienDao.findAll();
        } catch (ClassNotFoundException ex) {
         Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabModel.setRowCount(0);
        
        nhanvienList.forEach((nv) -> {
            tabModel.addRow(new Object[] {
                tabModel.getRowCount()+1, nv.getManv(), nv.getHoten(), nv.getNgaysinh(), nv.getQuequan(),
                nv.getGioitinh(), nv.getSocmt(), nv.getSdt(), nv.getChucvu(), nv.getCalam(), nv.getLuong()
            });
        });
    }
     private void LoadData() throws ClassNotFoundException, SQLException, ParseException
    {
        if (tabNV.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tabNV.getSelectedRow();
            
            //-- Lấy được danh sách sinh viên
            List<Nhan_vien> lstnv = Nhan_vienDao.findAll();
            //-- Xác định là dịch vụ nào đang được click
            
            Nhan_vien nv = lstnv.get(i);
            //--- Set giá trị cho các control
                txtManv.setText(nv.getManv());
                txtHoten.setText(nv.getHoten());
                SimpleDateFormat ngaytt= new SimpleDateFormat("yyyy-MM-dd");
                Date date= ngaytt.parse(nv.getNgaysinh());
                jDateChooser1.setDate(date);
                txtQuequan.setText(nv.getQuequan());
                cmbGioitinh.setSelectedItem(nv.getGioitinh());
                String cmt=String.valueOf(nv.getSocmt());
                txtSocmt.setText(cmt);
                String sdt=String.valueOf(nv.getSdt());
                txtSdt.setText(sdt);
                cmbChucvu.setSelectedItem(nv.getChucvu());
                cmbCalam.setSelectedItem(nv.getCalam());
                String luong= String.valueOf(nv.getLuong());
                txtLuong.setText(luong);
                
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
        txtManv = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSocmt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbGioitinh = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        cmbChucvu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbCalam = new javax.swing.JComboBox<>();
        btnTimkiem = new javax.swing.JButton();
        tabNhanvien = new javax.swing.JScrollPane();
        tabNV = new javax.swing.JTable();
        txtQuequan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Mã nhân viên");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Họ tên");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Quê quán");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Số chúng minh thư");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Số điện thoại");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Chức vụ");

        cmbGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

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
        btnLammoi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        cmbChucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thợ chính", "Thợ phụ" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Ca làm");

        cmbCalam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fulltime", "Partime" }));

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-timkiem.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        tabNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã nhân viên", "Họ tên", "Ngày sinh", "Quê quán", "Giới tính", "Số cmt", "Số điện thoại", "Chức vụ", "Ca Làm", "Lương"
            }
        ));
        tabNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabNVMouseClicked(evt);
            }
        });
        tabNhanvien.setViewportView(tabNV);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Giới tính");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Lương");

        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabNhanvien)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLammoi)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimkiem)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtHoten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(txtManv, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtQuequan)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel7))
                                    .addComponent(cmbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbCalam, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(98, 98, 98))
                                            .addComponent(txtSocmt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel10))
                                    .addComponent(cmbChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(185, 214, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtQuequan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(172, 172, 172)
                                        .addComponent(jLabel7))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(txtSocmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbCalam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tabNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb= new StringBuilder();
        if(txtManv.getText().equals(""))
        {
            sb.append("Ma nhan vien khong duoc de trong!!!");
            txtManv.setBackground(Color.red);
        }
        else
            txtManv.setBackground(Color.WHITE);
        if(sb.length()>0)
        {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            Nhan_vien nv= new Nhan_vien();
            nv.setManv(txtManv.getText());
            nv.setHoten(txtHoten.getText());
            SimpleDateFormat ngaytt= new SimpleDateFormat("dd/MM/yyyy");
            String date= ngaytt.format(jDateChooser1.getDate());
            nv.setNgaysinh(date);
            nv.setQuequan(txtQuequan.getText());
            nv.setGioitinh(cmbGioitinh.getSelectedItem().toString());
            nv.setSocmt(Integer.parseInt(txtSocmt.getText()));
            nv.setSdt(Integer.parseInt(txtSdt.getText()));
            nv.setChucvu(cmbChucvu.getSelectedItem().toString());
            nv.setCalam(cmbCalam.getSelectedItem().toString());
            nv.setLuong(Integer.parseInt(txtLuong.getText()));
            
            Nhan_vienDao dao= new Nhan_vienDao();
            dao.insert(nv);
             JOptionPane.showMessageDialog(this, "nhan vien moi da duoc them ");
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showNhanvien();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        txtManv.setText("");
        txtHoten.setText("");
        jDateChooser1.setDateFormatString("");
        txtQuequan.setText("");
        cmbGioitinh.setSelectedIndex(0);
        txtSocmt.setText("");
        txtSdt.setText("");
        cmbChucvu.setSelectedIndex(0);
        cmbCalam.setSelectedIndex(0);
        txtLuong.setText("");
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        if(txtManv.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "can nhap ma nhan vien can tim!!!");
            return;
        }
        
        try{
            Nhan_vienDao dao = new Nhan_vienDao();
            
            Nhan_vien nv = dao.findID(txtManv.getText());
            
            if(nv !=null)
            {
                txtHoten.setText(nv.getHoten());
                SimpleDateFormat ngaytt= new SimpleDateFormat("yyyy-MM-dd");
                Date date= ngaytt.parse(nv.getNgaysinh());
                jDateChooser1.setDate(date);
                txtQuequan.setText(nv.getQuequan());
                cmbGioitinh.setSelectedItem(nv.getGioitinh());
                String cmt=String.valueOf(nv.getSocmt());
                txtSocmt.setText(cmt);
                String sdt=String.valueOf(nv.getSdt());
                txtSdt.setText(sdt);
                cmbChucvu.setSelectedItem(nv.getChucvu());
                cmbCalam.setSelectedItem(nv.getCalam());
                String luong= String.valueOf(nv.getLuong());
                txtLuong.setText(luong);
            }else
                JOptionPane.showMessageDialog(this, "khong tim thay ma nhan vien!!!");
        }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         StringBuilder sb= new StringBuilder();
        if(txtManv.getText().equals(""))
        {
            sb.append("Ma nhan vien khong duoc de trong!!!");
            txtManv.setBackground(Color.red);
        }
        else
            txtManv.setBackground(Color.WHITE);
        if(sb.length()>0)
        {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            Nhan_vien nv= new Nhan_vien();
            nv.setManv(txtManv.getText());
            nv.setHoten(txtHoten.getText());
            SimpleDateFormat ngaytt= new SimpleDateFormat("yyyy-MM-dd");
            String date= ngaytt.format(jDateChooser1.getDate());
            nv.setNgaysinh(date);
            nv.setQuequan(txtQuequan.getText());
            nv.setGioitinh(cmbGioitinh.getSelectedItem().toString());
            nv.setSocmt(Integer.parseInt(txtSocmt.getText()));
            nv.setSdt(Integer.parseInt(txtSdt.getText()));
            nv.setChucvu(cmbChucvu.getSelectedItem().toString());
            nv.setCalam(cmbCalam.getSelectedItem().toString());
            nv.setLuong(Integer.parseInt(txtLuong.getText()));
            
            Nhan_vienDao dao= new Nhan_vienDao();
            dao.update(nv);
             JOptionPane.showMessageDialog(this, "nhan vien moi da duoc sua ");
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showNhanvien();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
            if(txtManv.getText().equals(""))
            {
                sb.append("Ma nhan vien khong duoc de trong");
                txtManv.setBackground(Color.red);
            }else
                txtManv.setBackground(Color.WHITE);
            if(sb.length()>0)
            {
                JOptionPane.showMessageDialog(this, sb);
                return;
            }
            if(JOptionPane.showConfirmDialog(this, "ban co muon xoa nhan vien khong?")==JOptionPane.NO_OPTION)
            {
                return;
            }
            try{
                Nhan_vienDao dao= new Nhan_vienDao();
                dao.delete(txtManv.getText());
                
                JOptionPane.showMessageDialog(this, "nhan vien da duoc xoa ");
                btnLammoiActionPerformed(evt);
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
                ex.printStackTrace();
            }
        try {
            showNhanvien();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tabNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabNVMouseClicked
        try {
            // TODO add your handling code here:
            LoadData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabNVMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbCalam;
    private javax.swing.JComboBox<String> cmbChucvu;
    private javax.swing.JComboBox<String> cmbGioitinh;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable tabNV;
    private javax.swing.JScrollPane tabNhanvien;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtQuequan;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSocmt;
    // End of variables declaration//GEN-END:variables
}
