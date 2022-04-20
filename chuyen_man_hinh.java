/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class chuyen_man_hinh {
    
    private JPanel root;
    private String kindSelected = "";
    
    private List<danhmuc> listItem = null;

    public chuyen_man_hinh(JPanel root) {
        this.root = root;
    }

   public void setView(JPanel jpnItem, JLabel jlbItem) throws SQLException
   {
       kindSelected = "KhachHang";
       jpnItem.setBackground(new Color(96, 100, 191));
       jlbItem.setBackground(new Color(96, 100, 191));
       root.removeAll();
       root.setLayout(new BorderLayout());
       root.add(new KhachHangJPanel());
       //root.add(new KhachHangJPanel());
       root.validate();
       root.repaint();
   }
   public void setEvent(List<danhmuc> listItem)
   {
       this.listItem = listItem;
       for(danhmuc item: listItem)
       {
           item.getJlb().addMouseListener(new LableEvent(item.getKind(), item.getJpb(),item.getJlb() ));
       }
   }
   
   class LableEvent implements MouseListener
   {
       private JPanel node;
       private String kind;
       
       private JPanel jpnItem;
       private JLabel jlbItem;

        public LableEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
       
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind)
            {
                case "KhachHang":
            {
                try {
                    node = new KhachHangJPanel();
                } catch (SQLException ex) {
                    Logger.getLogger(chuyen_man_hinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case "NhanVien":
            {
                try {
                    node = new NhanVienJPanel();
                } catch (SQLException ex) {
                    Logger.getLogger(chuyen_man_hinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case "DichVu":
            {
                try {
                    node = new DichvuJPanel();
                } catch (SQLException ex) {
                    Logger.getLogger(chuyen_man_hinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case "HoaDon":
            {
                try {
                    node = new HoaDonJPanel();
                } catch (SQLException ex) {
                    Logger.getLogger(chuyen_man_hinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
            }
             root.removeAll();
             root.setLayout(new BorderLayout());
             root.add(node);
             root.validate();
             root.repaint();
             setChangeBackgroud(kind);
        }
         public LableEvent(JPanel node, String kind, JPanel jpnItem, JLabel jlbItem) {
             this.node = node;
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
//        public void mouseExited(MouseEvent e) {
//            if(!kindSelected.equalsIgnoreCase(kind))
//            {
//                jpnItem.setBackground(new Color(76, 175, 80));
//                jlbItem.setBackground(new Color(760, 175, 80));
//            }
//        }
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind))
            {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
            }
        }
       
   }
   
   private void setChangeBackgroud(String kind)
   {
       for(danhmuc item : listItem)
       {
           if(item.getKind().equalsIgnoreCase(kind))
           {
               item.getJpb().setBackground(new Color(96, 100, 191));
               item.getJlb().setBackground(new Color(96, 100, 191));
           }
           else
           {
                item.getJpb().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
           }
       }
   }
}
