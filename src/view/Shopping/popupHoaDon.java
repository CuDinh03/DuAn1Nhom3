/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Shopping;

import DAO.CustomerDAO;
import DAO.ItemsDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ShoppingCartDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Customer;
import model.Items;
import model.Order;
import model.OrderDetail;
import model.ShoppingCart;

/**
 *
 * @author maccuacu
 */
public class popupHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form popupHoaDon
     */
    private List<Items> itemList;
    private BigDecimal total;

    public popupHoaDon(List<Items> itemList, BigDecimal total) {

        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(popupHoaDon.DISPOSE_ON_CLOSE);
        this.itemList = itemList;
        this.total = total;
        btncreate.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hoadonpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        txtnamecustomer = new javax.swing.JTextField();
        btncheck = new javax.swing.JButton();
        btncreate = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hoadonpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá Đơn"));

        jLabel1.setText("Số điện thoại");

        jLabel2.setText("Tên khách hàng");

        btncheck.setText("Kiểm tra");
        btncheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncheckActionPerformed(evt);
            }
        });

        btncreate.setText("Tiếp");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });

        btncancel.setText("Huỷ");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hoadonpanelLayout = new javax.swing.GroupLayout(hoadonpanel);
        hoadonpanel.setLayout(hoadonpanelLayout);
        hoadonpanelLayout.setHorizontalGroup(
            hoadonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoadonpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hoadonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hoadonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtphone)
                    .addComponent(txtnamecustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(btncheck)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hoadonpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btncancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncreate))
        );
        hoadonpanelLayout.setVerticalGroup(
            hoadonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoadonpanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(hoadonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncheck))
                .addGap(18, 18, 18)
                .addGroup(hoadonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnamecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(hoadonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncreate)
                    .addComponent(btncancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hoadonpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hoadonpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncheckActionPerformed
        // TODO add your handling code here:

        this.checkCustomer();
        btncreate.setVisible(true);

    }//GEN-LAST:event_btncheckActionPerformed

    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
        // TODO add your handling code here:
        String phone = this.txtphone.getText().trim();
        CustomerDAO cdao = new CustomerDAO();

        Random random = new Random();

        String ma = String.valueOf(random.nextInt(10000 - 1 + 1) + 2);
        String name = "Hoa don " + (new Date()).toString();
        String idkh = cdao.findCustomerIdByPhone(phone);
        String tenkh = this.txtnamecustomer.getText().trim();
        String tenNv = "";
        String idNv = "abcaa424-6ae4-4557-a48a-65a01c1cfba0";

        Date ngaytao = new Date();
        Date ngaySua = new Date();

        ShoppingCartDAO scdao = new ShoppingCartDAO();
        ShoppingCart shopping = new ShoppingCart("", ma, itemList, tenkh, tenNv, ngaytao, ngaySua, 1);
        scdao.insertShoppingCart(shopping);

        Order order = new Order(ma, name, idkh, idNv, ngaytao, ngaySua, 0);
        OrderDAO odao = new OrderDAO();
        odao.createOrder(order);

        OrderDetailDAO odDao = new OrderDetailDAO();

        String maDetail = String.valueOf(random.nextInt(10000 - 1 + 1) + 1);

        OrderDetail detail = new OrderDetail(maDetail, odao.getOrderByMa(ma).getId(), total, ngaytao, ngaySua, 0);
        odDao.addOrderDetail(detail);

        ItemsDAO idao = new ItemsDAO();
        for (Items items : itemList) {
            items.setIdInventory(odao.getOrderByMa(ma).getId());
            items.setIdCart(scdao.getShoppingCartByMa(ma).getId());
            items.setCreateDate(ngaytao);
            items.setUpdateDate(ngaySua);
            idao.insertItem(items);
        }

        JOptionPane.showMessageDialog(this, "Tạo hoá đợn thành công");
        setVisible(false);

        itemList.clear();


    }//GEN-LAST:event_btncreateActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btncancelActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(popupHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(popupHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(popupHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(popupHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new popupHoaDon(itemList).setVisible(true);
//            }
//        });
//    }
    private void checkCustomer() {
        String phone = this.txtphone.getText().trim();

        String phonePattern = "\\d{10}";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        CustomerDAO cdao = new CustomerDAO();
        boolean phoneExists = false;
        try {
            phoneExists = cdao.doesPhoneExist(phone);
        } catch (SQLException ex) {
            Logger.getLogger(popupHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (phoneExists) {
            try {
                String customerName = cdao.getNameByPhone(phone);
                txtnamecustomer.setText(customerName);
            } catch (SQLException ex) {
                Logger.getLogger(popupHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Lỗi khi truy vấn tên khách hàng.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Số điện thoại không tồn tại trong hệ thống.");
            String customerName;
            try {
                customerName = cdao.getNameByPhone(phone);
                txtnamecustomer.setText(customerName);

                Date createDate = new Date();
                long milliseconds = createDate.getTime();
                java.sql.Date sqlDate = new java.sql.Date(milliseconds);

                Customer cus = new Customer("", customerName, phone, "", sqlDate, sqlDate, 1);
                cdao.addCustomer(cus);
                JOptionPane.showMessageDialog(this, "Đã thêm mới khách khách hàng.");

            } catch (SQLException ex) {
                Logger.getLogger(popupHoaDon.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btncheck;
    private javax.swing.JButton btncreate;
    private javax.swing.JPanel hoadonpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtnamecustomer;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
