/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsalontocnam;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class danhmuc {
    
    private String kind;
    private JPanel jpb;
    private JLabel jlb;

    public danhmuc() {
    }

    public danhmuc(String kind, JPanel jpb, JLabel jlb) {
        this.kind = kind;
        this.jpb = jpb;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpb() {
        return jpb;
    }

    public void setJpb(JPanel jpb) {
        this.jpb = jpb;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

    Object getJpn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
