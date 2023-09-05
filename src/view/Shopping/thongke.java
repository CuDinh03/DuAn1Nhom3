/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Shopping;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.Custormer;
import model.Order;
import model.OrderDetail;
import view.QuanLyKho.JFrQuanLy;

/**
 *
 * @author trung
 */
public class thongke extends javax.swing.JFrame {

    DefaultTableModel dtm;

    public thongke() {
        initComponents();
        setLocationRelativeTo(null);
        this.loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        a = new javax.swing.JLabel();
        lbTongHoaDon = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        h = new javax.swing.JLabel();
        lbDaNhanHoaDon = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        s = new javax.swing.JLabel();
        LbDangChohd = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        btnLoadTb = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHienThiHoaDon = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lbDtAll = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(222, 231, 227));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(928, 520));

        jPanel6.setBackground(new java.awt.Color(222, 231, 227));

        jPanel21.setBackground(new java.awt.Color(222, 231, 227));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê"));
        jPanel21.setLayout(new java.awt.GridLayout());

        jPanel22.setBackground(new java.awt.Color(245, 147, 137));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel22.setForeground(new java.awt.Color(250, 12, 12));

        a.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a.setText("Tổng số ");

        lbTongHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTongHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTongHoaDon.setText("0");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lbTongHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lbTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(a)
                .addContainerGap())
        );

        jPanel21.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(11, 226, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        h.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        h.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h.setText("Đã thanh toán");

        lbDaNhanHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbDaNhanHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDaNhanHoaDon.setText("0");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(h, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbDaNhanHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(h)
                .addContainerGap())
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(lbDaNhanHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        jPanel21.add(jPanel23);

        jPanel28.setBackground(new java.awt.Color(4, 251, 58));
        jPanel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        s.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        s.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s.setText("Đang chờ");

        LbDangChohd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LbDangChohd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbDangChohd.setText("0");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(s, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LbDangChohd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(s)
                .addContainerGap())
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(LbDangChohd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        jPanel21.add(jPanel28);

        jPanel10.setBackground(new java.awt.Color(222, 231, 227));

        jPanel20.setBackground(new java.awt.Color(222, 231, 227));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        btnLoadTb.setText("Load");
        btnLoadTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTbActionPerformed(evt);
            }
        });

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadTb)
                .addGap(38, 38, 38))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadTb)
                    .addComponent(btnback))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tbHienThiHoaDon.setAutoCreateRowSorter(true);
        tbHienThiHoaDon.setBackground(new java.awt.Color(222, 231, 227));
        tbHienThiHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Tên khách hàng", "Số điện thoại", "Ngày tạo/thanh toán ", "Tổng tiền", "Trạng thái "
            }
        ));
        jScrollPane3.setViewportView(tbHienThiHoaDon);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê hoá đơn", jPanel6);

        jPanel7.setBackground(new java.awt.Color(222, 231, 227));

        jPanel14.setBackground(new java.awt.Color(222, 231, 227));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê"));
        jPanel14.setLayout(new java.awt.GridLayout(1, 4));

        jPanel18.setBackground(new java.awt.Color(92, 146, 253));
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Tổng doanh thu ");

        lbDtAll.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbDtAll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDtAll.setText("0");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lbDtAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(lbDtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addContainerGap())
        );

        jPanel14.add(jPanel18);

        jPanel11.setBackground(new java.awt.Color(222, 231, 227));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê doanh thu", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadTbActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new JFrQuanLy().setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

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
//            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new thongke().setVisible(true);
//            }
//        });
//    }

    private void loadTable() {
        OrderDetailDAO odao = new OrderDetailDAO();
        OrderDAO ordao = new OrderDAO();
        CustomerDAO cusdao = new CustomerDAO();

        dtm = (DefaultTableModel) tbHienThiHoaDon.getModel();
        dtm.setRowCount(0);

        for (Order ors : ordao.findAll()) {
            String status = "";
            OrderDetail detail = odao.getOrderDetailById(ors.getId());
            Customer cus;
            try {
                cus = cusdao.getCustomerById(ors.getIdCustomer());
                if (ors.getInventoryStatus() == 1) {
                    status = "Đã thanh toán";
                } else {
                    status = "Chưa thanh toán";
                }
                Object[] data = {
                    ors.getCode(), cus.getUserName(), "000", ors.getCreateDate(), detail.getTotal(), status
                };
                dtm.addRow(data);
            } catch (SQLException ex) {
                Logger.getLogger(thongke.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        this.lbDaNhanHoaDon.setText(String.valueOf(ordao.calculateTotalPaidInvoices()));
        this.lbTongHoaDon.setText(String.valueOf(ordao.calculateTotalPaidInvoices3()));
        this.LbDangChohd.setText(String.valueOf(ordao.calculateTotalPaidInvoices2()));
        this.lbDtAll.setText(String.valueOf(odao.sumTotal()));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbDangChohd;
    private javax.swing.JLabel a;
    private javax.swing.JButton btnLoadTb;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel h;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbDaNhanHoaDon;
    private javax.swing.JLabel lbDtAll;
    private javax.swing.JLabel lbTongHoaDon;
    private javax.swing.JLabel s;
    private javax.swing.JTable tbHienThiHoaDon;
    // End of variables declaration//GEN-END:variables
}
