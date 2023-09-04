/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Shopping;

import DAO.CustomerDAO;
import DAO.ItemsDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import DAO.ShoppingCartDAO;
import DAO.StoreDAO;
import DAO.UserDAO;
import Erro.InsufficientProductQuantityException;
import IO.InvoicePDFGenerator;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Customer;
import model.Items;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.ShoppingCart;
import model.Store;
import model.User;
import model.UserSession;
import view.QuanLyKho.*;

/**
 *
 * @author phamq
 */
public class JFrMain extends javax.swing.JFrame {
// String getDate =((JTextField)txtDate.getDateEditor().getUiComponent()).getText();

    /**
     * Creates new form JFrShopping
     */
    CardLayout card;
    private DefaultTableModel dtm, dtmHD, dtmGH;
    private List<Items> itemList;
    private StoreDAO sdao = new StoreDAO();

    public JFrMain() {
        initComponents();
        setLocationRelativeTo(null);
//          panelQLSanPham = new javax.swing.JPanel();
//        card = (CardLayout) panelBody.getLayout();
//        card.show(panelBody, "pnlBanHang");
        this.loadTable();

        this.itemList = new ArrayList<>();

        this.loadTableCart();
        this.showTotal();
//        this.loadCbb();
        this.loadOrder();

    }

    public void loadTable() {
        ProductDAO prdao = new ProductDAO();

        dtm = (DefaultTableModel) tblDanhSachSP.getModel();
        dtm.setRowCount(0);
        for (Product pr : prdao.getAllProducts()) {
            Object[] data = {
                pr.getCode(), pr.getPrName(), pr.getIdType(), pr.getExpiry(), pr.getMFG(), pr.getOriginal(), pr.getCost(), pr.getPrStatus()
            };
            dtm.addRow(data);
        }

    }

    public void loadOrder() {
        OrderDAO orderDAO = new OrderDAO();
        dtmHD = (DefaultTableModel) this.tblHoaDon.getModel();
        dtmHD.setRowCount(0);

        String status = "";
        CustomerDAO cdao = new CustomerDAO();

        for (Order orders : orderDAO.findAllByStatus()) {
            User nameUser = UserDAO.getUserById(orders.getIdUser());
            Customer custormer;
            try {
                custormer = cdao.getCustomerById(orders.getIdCustomer());
                if (orders.getInventoryStatus() == 0) {
                    status = "Chưa thanh toán";
                } else {
                    status = "Đã thanh toán";
                }
                Object[] data = {
                    orders.getCode(), nameUser.getUserName(), custormer.getUserName(), status
                };
                dtmHD.addRow(data);
            } catch (SQLException ex) {
                Logger.getLogger(JFrMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void loadTableCart() {
        dtmGH = (DefaultTableModel) tblGioHang.getModel();
        dtmGH.setRowCount(0);
        ProductDAO pdao = new ProductDAO();

        for (Items items : itemList) {
            String name = pdao.getProductById(items.getNameProducs()).getPrName();
            Object[] data = {
                items.getCodeProducts(), name, items.getQuantity(), items.getPrice(), items.getPrice().multiply(BigDecimal.valueOf(items.getQuantity()))
            };
            dtmGH.addRow(data);
        }
        this.showTotal();

    }

    private void tienThua(BigDecimal tienKhachdua) {
        BigDecimal tienthua = tienKhachdua.subtract(this.calculateTotalPrice());
        if (tienthua.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(this, "Khách đưa thiếu tiền: " + tienthua.abs() + "k");
        }

//        this.txtTienThua.setText(tienthua.toString());
    }

    private Items findItemByProductId(String maSP) {
        for (Items item : itemList) {
            if (item.getCodeProducts().equals(maSP)) {
                return item;
            }
        }
        return null;
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Items item : itemList) {
            BigDecimal itemPrice = item.getPrice();
            int itemQuantity = item.getQuantity();
            BigDecimal itemTotal = itemPrice.multiply(BigDecimal.valueOf(itemQuantity));
            totalPrice = totalPrice.add(itemTotal);;
        }
        return totalPrice;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNavigation = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lbClose = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        panelBanHang = new javax.swing.JPanel();
        panelGioHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnClearItems = new javax.swing.JButton();
        btnDeletebyMa = new javax.swing.JButton();
        panelHoaDon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        panelThanhToan = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnUpdateOrder = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnTT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtorderCode = new javax.swing.JLabel();
        panelSanPham = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhSachSP = new javax.swing.JTable();
        btnrsOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelNavigation.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout panelNavigationLayout = new javax.swing.GroupLayout(panelNavigation);
        panelNavigation.setLayout(panelNavigationLayout);
        panelNavigationLayout.setHorizontalGroup(
            panelNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        panelNavigationLayout.setVerticalGroup(
            panelNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHeader.setBackground(new java.awt.Color(153, 153, 255));

        lbClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Close Window_3.png"))); // NOI18N
        lbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        jLabel19.setText("Xin chào:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Shop.png"))); // NOI18N
        jLabel1.setText("Nhóm 3");

        txtUserName.setText("_");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtUserName))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBody.setBackground(new java.awt.Color(204, 204, 204));
        panelBody.setVerifyInputWhenFocusTarget(false);
        panelBody.setLayout(new java.awt.CardLayout());

        panelBanHang.setBackground(new java.awt.Color(222, 231, 227));
        panelBanHang.setMaximumSize(new java.awt.Dimension(928, 520));
        panelBanHang.setMinimumSize(new java.awt.Dimension(928, 520));

        panelGioHang.setBackground(new java.awt.Color(222, 231, 227));
        panelGioHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGioHang);

        btnClearItems.setText("Xoá toàn bộ");
        btnClearItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearItemsActionPerformed(evt);
            }
        });

        btnDeletebyMa.setText("Xoá");
        btnDeletebyMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletebyMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGioHangLayout = new javax.swing.GroupLayout(panelGioHang);
        panelGioHang.setLayout(panelGioHangLayout);
        panelGioHangLayout.setHorizontalGroup(
            panelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGioHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletebyMa)
                .addGap(18, 18, 18)
                .addComponent(btnClearItems)
                .addContainerGap())
        );
        panelGioHangLayout.setVerticalGroup(
            panelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGioHangLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearItems)
                    .addComponent(btnDeletebyMa)))
        );

        panelHoaDon.setBackground(new java.awt.Color(222, 231, 227));
        panelHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá đơn"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Tên NV", "Tên KH", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        javax.swing.GroupLayout panelHoaDonLayout = new javax.swing.GroupLayout(panelHoaDon);
        panelHoaDon.setLayout(panelHoaDonLayout);
        panelHoaDonLayout.setHorizontalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelHoaDonLayout.setVerticalGroup(
            panelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelThanhToan.setBackground(new java.awt.Color(222, 231, 227));
        panelThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder("Thanh toán"));

        jLabel15.setText("Tổng tiền: ");

        txtTongTien.setText("0");

        jPanel5.setLayout(new java.awt.GridLayout(2, 2, 10, 5));

        jButton1.setText("Tạo hoá đơn ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        btnUpdateOrder.setText("Cập nhật hoá đơn");
        btnUpdateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrderActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdateOrder);

        jButton6.setText("Huỷ ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);

        btnTT.setText("Thanh Toán");
        btnTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTActionPerformed(evt);
            }
        });
        jPanel5.add(btnTT);

        jLabel2.setText("Mã hoá đơn");

        txtorderCode.setText("0000");

        javax.swing.GroupLayout panelThanhToanLayout = new javax.swing.GroupLayout(panelThanhToan);
        panelThanhToan.setLayout(panelThanhToanLayout);
        panelThanhToanLayout.setHorizontalGroup(
            panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtorderCode)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelThanhToanLayout.setVerticalGroup(
            panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtorderCode))
                .addGap(71, 71, 71)
                .addGroup(panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelSanPham.setBackground(new java.awt.Color(222, 231, 227));
        panelSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblDanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên", "Loại", "HSD", "NSX", "Nguồn gốc", "Đơn giá", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhSachSP);

        jScrollPane5.setViewportView(jScrollPane3);

        javax.swing.GroupLayout panelSanPhamLayout = new javax.swing.GroupLayout(panelSanPham);
        panelSanPham.setLayout(panelSanPhamLayout);
        panelSanPhamLayout.setHorizontalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        panelSanPhamLayout.setVerticalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSanPhamLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnrsOrder.setText("Làm mới");
        btnrsOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrsOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBanHangLayout = new javax.swing.GroupLayout(panelBanHang);
        panelBanHang.setLayout(panelBanHangLayout);
        panelBanHangLayout.setHorizontalGroup(
            panelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBanHangLayout.createSequentialGroup()
                .addGroup(panelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBanHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnrsOrder, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );
        panelBanHangLayout.setVerticalGroup(
            panelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBanHangLayout.createSequentialGroup()
                .addComponent(panelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnrsOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelBanHangLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(panelThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelHoaDon.getAccessibleContext().setAccessibleDescription("");

        panelBody.add(panelBanHang, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNavigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?");
        if (check == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbCloseMouseClicked

    private void btnBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseEntered
//        this.btnBanHang.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnBanHangMouseEntered

    private void btnBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseExited

//       this.btnBanHang.setBackground(new Color(102,204,255));
    }//GEN-LAST:event_btnBanHangMouseExited

    private void btnSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseEntered
//        this.btnSanPham.setBackground(Color.WHITE);
    }//GEN-LAST:event_btnSanPhamMouseEntered

    private void btnSanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseExited
//         this.btnSanPham.setBackground(new Color(102,204,255));
    }//GEN-LAST:event_btnSanPhamMouseExited

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
//      panelBanHang.setVisible(true);
//      panelQLSanPham.setVisible(false);
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

        int col = this.tblHoaDon.getSelectedRow();
        if (col == -1) {
            return;
        }
        String orderMa = this.tblHoaDon.getValueAt(col, 0).toString();
        OrderDAO odao = new OrderDAO();
        String orderId = odao.getOrderByMa(orderMa).getId();
        ItemsDAO idao = new ItemsDAO();
        this.itemList = idao.getAllItemsByOrderId(orderId);
        this.txtorderCode.setText(orderMa);

        this.loadTableCart();

        this.showTotal();

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblDanhSachSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSPMouseClicked
        // TODO add your handling code here:

//        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá không?", "Confirmation", JOptionPane.YES_NO_OPTION);
//        switch (option) {
//            case JOptionPane.YES_OPTION -> {
//                itemList.clear();
//                JOptionPane.showMessageDialog(this, "Xoá thành công");
//                this.loadTableCart();
//            }
//            case JOptionPane.NO_OPTION -> {
//            }
//            case JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION -> {
//            }
//            default -> {
//            }
//        }
        int col = this.tblDanhSachSP.getSelectedRow();
        if (col == -1) {
            return;
        }

//
//
//        
//        
        String userInput = JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm:", "Nhập số lượng", JOptionPane.QUESTION_MESSAGE);

        if (userInput != null && !userInput.isEmpty()) {
            try {
                int quantity = Integer.parseInt(userInput);

                String ma = this.tblDanhSachSP.getValueAt(col, 0).toString();
                String pr = this.tblDanhSachSP.getValueAt(col, 6).toString();

                ProductDAO pdao = new ProductDAO();
                String idpr = pdao.getProductByCode(ma).getId();

                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(pr) * 2);

                Items existingItem = this.findItemByProductId(ma);

                if (existingItem != null) {
                    existingItem.setQuantity(existingItem.getQuantity() + quantity);
                } else {
                    Items item = new Items(ma, idpr, quantity, price, 1);
                    itemList.add(item);
                }

                JOptionPane.showMessageDialog(null, "Bạn đã nhập: " + quantity + " sản phẩm.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã hủy .");
        }
        this.loadTableCart();
        this.showTotal();

    }//GEN-LAST:event_tblDanhSachSPMouseClicked

    private void btnClearItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearItemsActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá không?", "Confirmation", JOptionPane.YES_NO_OPTION);
        switch (option) {
            case JOptionPane.YES_OPTION -> {
                itemList.clear();
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                this.loadTableCart();
            }
            case JOptionPane.NO_OPTION -> {
            }
            case JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION -> {
            }
            default -> {
            }
        }


    }//GEN-LAST:event_btnClearItemsActionPerformed

    private void btnDeletebyMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletebyMaActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá không?", "Confirmation", JOptionPane.YES_NO_OPTION);
        switch (option) {
            case JOptionPane.YES_OPTION -> {
                int row = tblGioHang.getSelectedRow();
                if (row == -1) {
                    return;
                }

                String ma = tblGioHang.getValueAt(row, 0).toString();

                for (Items items : itemList) {
                    if (items.getCodeProducts().equals(ma)) {
                        itemList.remove(items);
                        JOptionPane.showMessageDialog(this, "Xoá thành công");
                        break;
                    }
                }
            }
            case JOptionPane.NO_OPTION -> {
            }
            case JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION -> {
            }
            default -> {
            }
        }

        this.loadTableCart();


    }//GEN-LAST:event_btnDeletebyMaActionPerformed

    private void btnTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTActionPerformed
        // TODO add your handling code here:
        ProductDAO pdao = new ProductDAO();
        for (Items items : itemList) {
            String productCode = items.getCodeProducts();
            Product product = pdao.getProductByCode(productCode);

            if (product != null) {
                int quantityToAdd = items.getQuantity();
                if (quantityToAdd > 0) {
                    try {
                        pdao.updateProductQuantityAfterPayment(product.getId(), quantityToAdd);
                        JOptionPane.showMessageDialog(this, "Thanh toán thành công");

                    } catch (InsufficientProductQuantityException ex) {
                        JOptionPane.showMessageDialog(this, "Số lượng sản phẩm '" + product.getPrName() + "' không đủ.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã '" + productCode + "'.");
            }
        }
        
        String ma = this.txtorderCode.getText().trim();

        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO odtail = new OrderDetailDAO();
        orderDAO.updateOrderByMa(ma);
        Order order = orderDAO.getOrderByMa2(ma);
        OrderDetail detail = odtail.findSingleOrderDetailByCode(order.getId());
        ShoppingCartDAO spdao = new ShoppingCartDAO();
        ShoppingCart shoppingCart = spdao.getShoppingCartByMa(ma);
        shoppingCart.setItemsList(itemList);
        InvoicePDFGenerator.createAndPrintInvoice(order, detail, shoppingCart);
        this.clearALl();
        this.loadOrder();
        this.loadTable();
        this.loadTableCart();

//        InvoicePDFGenerator.exportPDF(order, detail, shopping);
    }//GEN-LAST:event_btnTTActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int col = this.tblHoaDon.getSelectedRow();
        if (col == -1) {
            return;
        }
        String ma = this.tblHoaDon.getValueAt(col, 0).toString();

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.deleteOrderByMa(ma);
        JOptionPane.showMessageDialog(this, "Xóa thành công");
        this.clearALl();
        this.loadOrder();
        this.loadTable();
        this.loadTableCart();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String order = this.txtorderCode.getText().trim();
        if (!order.equals("0000")) {
            JOptionPane.showMessageDialog(this, "Đã có mã hoá đơn này hãy cập nhật hoá đơn hoặc thanh toán");
        } else {
            if (this.itemList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa có hàng trong giỏ!");
                return;
            }
            BigDecimal total = BigDecimal.valueOf(Double.parseDouble(this.txtTongTien.getText()));

            new popupHoaDon(itemList, total).setVisible(true);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnrsOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrsOrderActionPerformed
        // TODO add your handling code here:
        this.loadOrder();
    }//GEN-LAST:event_btnrsOrderActionPerformed

    private void btnUpdateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrderActionPerformed
        // TODO add your handling code here:
        OrderDAO odao = new OrderDAO();
        Order order = odao.getOrderByMa(this.txtorderCode.getText().trim());
        ShoppingCartDAO sdao = new ShoppingCartDAO();
        ItemsDAO idao = new ItemsDAO();
        Date ngaytao = new Date();
        Date ngaySua = new Date();

        for (Items items : itemList) {
            items.setIdInventory(order.getId());
            items.setIdCart(sdao.getShoppingCartByMa(order.getCode()).getId());
            items.setCreateDate(ngaytao);
            items.setUpdateDate(ngaySua);
            idao.insertItem(items);
        }
        odao.updateOrder(order);
        JOptionPane.showMessageDialog(this, "Cập nhật hoá đơn thành công");
        this.loadOrder();
        this.loadTableCart();
        this.clearALl();
    }//GEN-LAST:event_btnUpdateOrderActionPerformed

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
            java.util.logging.Logger.getLogger(JFrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrMain().setVisible(true);

            }
        });
    }

    private javax.swing.JPanel panelQLSanPham;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearItems;
    private javax.swing.JButton btnDeletebyMa;
    private javax.swing.JButton btnTT;
    private javax.swing.JButton btnUpdateOrder;
    private javax.swing.JButton btnrsOrder;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbClose;
    private javax.swing.JPanel panelBanHang;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelGioHang;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHoaDon;
    private javax.swing.JPanel panelNavigation;
    private javax.swing.JPanel panelSanPham;
    private javax.swing.JPanel panelThanhToan;
    private javax.swing.JTable tblDanhSachSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JLabel txtUserName;
    private javax.swing.JLabel txtorderCode;
    // End of variables declaration//GEN-END:variables

    private void showTotal() {
        BigDecimal totalPrice = calculateTotalPrice();
        String totalPriceString = totalPrice.toString();
        this.txtTongTien.setText(totalPriceString);
    }
//
//    private void thanhtoan() {
//        try {
////            double tienThua = Double.parseDouble(this.txtTienThua.getText());
//            String tienkhd = this.txtTenKHTaiQuay.getText().trim();
////            String sdt = this.txtSDTTQ.getText().trim();
////            if (tienThua < 0 || tienkhd.isEmpty()) {
////                JOptionPane.showMessageDialog(this, "Yêu cầu khách trả đủ tiền mới thanh toán.");
////                return;
////            }
////            if (sdt.isEmpty()) {
////                JOptionPane.showMessageDialog(this, "Yêu cầu nhập số điện thoại của khách mới thanh toán.");
////                return;
////            }
//
//            Random random = new Random();
//
//            String ma = String.valueOf(random.nextInt(10000 - 1 + 1) + 2);
//            String name = "Hoa don " + (new Date()).toString();
//            String tenkh = this.txtTenKHTaiQuay.getText().trim();
//            String tenNv = "";
////            Store stores = sdao.findStoreByName(this.cbbCH.getSelectedItem().toString());
////            String idch = stores.getId();
//            Date ngaytao = new Date();
//            Date ngaySua = new Date();
//
//            ShoppingCartDAO scdao = new ShoppingCartDAO();
//            ShoppingCart shopping = new ShoppingCart("", ma, itemList, tenkh, tenNv, ngaytao, ngaySua, 1);
//            scdao.insertShoppingCart(shopping);
//
////            Order order = new Order(ma, name, tenNv, tenkh,  ngaytao, ngaySua, 0);
//            OrderDAO odao = new OrderDAO();
////            odao.createOrder(order);
//
//            double total = Double.parseDouble(this.txtTongTien.getText());
//            OrderDetailDAO odDao = new OrderDetailDAO();
//
//            String maDetail = String.valueOf(random.nextInt(10000 - 1 + 1) + 1);
//
//            OrderDetail detail = new OrderDetail(maDetail, ma, total, ngaytao, ngaySua, 0);
//            odDao.addOrderDetail(detail);
//
//            ItemsDAO idao = new ItemsDAO();
//            for (Items items : itemList) {
//                items.setIdInventory(odao.getOrderByMa(ma).getId());
//                items.setIdCart(scdao.getShoppingCartByMa(ma).getId());
//                items.setCreateDate(ngaytao);
//                items.setUpdateDate(ngaySua);
//                idao.insertItem(items);
//            }
//            JOptionPane.showMessageDialog(this, "Tạo hoá đợn thành công");
//
//            this.loadOrder();
//            itemList.clear();
//
//            this.clearALl();
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền thanh toán hợp lệ.");
//        }
//
//    }

    private void clearALl() {
        itemList.clear();
        this.txtorderCode.setText("");
        this.txtTongTien.setText("");
//        this.txtTienThua.setText("");
//        this.txtSDTTQ.setText("");
        this.loadTableCart();

    }

}
