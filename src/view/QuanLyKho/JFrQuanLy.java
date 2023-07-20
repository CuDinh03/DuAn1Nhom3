
package view.QuanLyKho;

import DAO.ProductDAO;
import IO.ReadFileExcel;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Product;
import service.ProductService;


public class JFrQuanLy extends javax.swing.JFrame {
    
    private DefaultTableModel dtm = new DefaultTableModel();
    
    private  ProductService productService;
    
    private ProductDAO productDAO = new ProductDAO();

    /**
     * Creates new form JFrQuanLy
     */
    public JFrQuanLy() {
        initComponents();
        this.loadTable();
        this.loadCbbDanhMuc();
        this.productService = new ProductService();
    }
    
    private void loadTable() {
        ProductDAO productDAO = new ProductDAO();
        
        dtm = (DefaultTableModel) tblKhoHang.getModel();
        dtm.setRowCount(0);
        
        for (Product product : productDAO.getAllProducts()) {
            String status;
            if (product.getStatus() == 0) {
                status = "Hết hàng";
            } else {
                status = "Còn hàng";
            }
            Object[] rowData = {
                product.getId(),
                product.getMa(),
                product.getName(),
                product.getIdDanhMuc(),
                product.getNguonGoc(),
                product.getNgayTao(),
                product.getNgaySua(),
                product.getNgaySx(),
                product.getHsd(),
                product.getGiaGoc(),
                status
            };
            dtm.addRow(rowData);
            
        }
        
    }

    
    
    public void loadCbbDanhMuc() {
        for (Product product : productDAO.getAllProducts()) {
            this.cbbDanhMuc.addItem(product.getIdDanhMuc());
            this.cbbFinddanhMuc.addItem(product.getIdDanhMuc());
        }
    }
    
    private void mouseClick() {
        int banGhiChon = tblKhoHang.getSelectedRow();
        if (banGhiChon == -1) {
            return;
        }
        
        String id = tblKhoHang.getValueAt(banGhiChon, 0).toString();
        String ma = tblKhoHang.getValueAt(banGhiChon, 1).toString();
        String ten = tblKhoHang.getValueAt(banGhiChon, 2).toString();
        String danhMuc = tblKhoHang.getValueAt(banGhiChon, 3).toString();
        String nguonGoc = tblKhoHang.getValueAt(banGhiChon, 4).toString();
        String ngayTao = tblKhoHang.getValueAt(banGhiChon, 5).toString();
        String ngaySua = tblKhoHang.getValueAt(banGhiChon, 6).toString();
        String nSX = tblKhoHang.getValueAt(banGhiChon, 7).toString();
        String hSD = tblKhoHang.getValueAt(banGhiChon, 8).toString();
        String donGia = tblKhoHang.getValueAt(banGhiChon, 9).toString();
        String trangThai = tblKhoHang.getValueAt(banGhiChon, 10).toString();
        
        txtID.setText(id);
        txtMaSP.setText(ma);
        txtTenSp.setText(ten);
        cbbDanhMuc.setSelectedItem(danhMuc);
        txtNguonGoc.setText(nguonGoc);
        txtNgayTao.setText(ngayTao);
        txtNgaySua.setText(ngaySua);
        txtNSX.setText(nSX);
        txtHSD.setText(hSD);
        txtDonGia.setText(donGia);
        cbbTrangThai.setSelectedItem(trangThai);
        
    }
    
    private void add() {
        try {
            String ma = txtMaSP.getText().trim();
            String ten = txtTenSp.getText().trim();
            String idDanhMuc = cbbDanhMuc.getSelectedItem().toString();
            String nguonGoc = txtNguonGoc.getText().trim();
            
            String ngayTao = txtNgayTao.getText().trim();
            String ngaySua = txtNgaySua.getText().trim();
            String nSX = txtNSX.getText().trim();
            String hSD = txtHSD.getText().trim();
            
            java.util.Date utilDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(ngayTao);
            java.util.Date utilDate2 = new SimpleDateFormat("dd-MM-yyyy").parse(ngaySua);
            java.util.Date utilDate3 = new SimpleDateFormat("dd-MM-yyyy").parse(nSX);
            java.util.Date utilDate4 = new SimpleDateFormat("dd-MM-yyyy").parse(hSD);
            
            java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
            java.sql.Date sqlDate3 = new java.sql.Date(utilDate3.getTime());
            java.sql.Date sqlDate4 = new java.sql.Date(utilDate4.getTime());
            
            String donGiaStr = txtDonGia.getText().trim();
            String trangThaiStr = cbbTrangThai.getSelectedItem().toString();
            double donGia = Double.parseDouble(donGiaStr);
            int trangThai = Integer.parseInt(trangThaiStr);
            
            for (Product product : this.productService.findAll()) {
                if (product.getMa().equals(ma)) {
                    JOptionPane.showMessageDialog(this, "Mã này đã tồn tại");
                    return;
                }
            }
            
            Product product = new Product(ma, ten, nguonGoc, donGia, sqlDate3, sqlDate4, idDanhMuc, sqlDate1, sqlDate2, trangThai);
            
            this.productService.insert(product);
            // this.productService.insert(new Product(ma,ten, nguonGoc, donGia, sqlDate3, sqlDate4, idDanhMuc, sqlDate1, sqlDate2, trangThai));

            loadTable();
            JOptionPane.showMessageDialog(this, "Nhập kho thành công");
            
        } catch (ParseException ex) {
            Logger.getLogger(JFrQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void delete() {
        
        int banGhiChon = this.tblKhoHang.getSelectedRow();
        if (banGhiChon == -1) {
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để Xóa");
            return;
        }
        
        String id = txtID.getText();
        
        this.productService.delete(id);
        
        loadTable();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }
    
    private void update() {
        try {
            int banGhiChon = this.tblKhoHang.getSelectedRow();
            if (banGhiChon == -1) {
                JOptionPane.showMessageDialog(this, "Chọn 1 dòng để Update");
                return;
            }
            
            String id = txtID.getText();
            String ma = txtMaSP.getText().trim();
            String ten = txtTenSp.getText().trim();
            String idDanhMuc = cbbDanhMuc.getSelectedItem().toString();
            String nguonGoc = txtNguonGoc.getText().trim();
            
            String ngayTao = txtNgayTao.getText().trim();
            String ngaySua = txtNgaySua.getText().trim();
            String nSX = txtNSX.getText().trim();
            String hSD = txtHSD.getText().trim();
            
            java.util.Date utilDate1 = new SimpleDateFormat("dd-MM-yyyy").parse(ngayTao);
            java.util.Date utilDate2 = new SimpleDateFormat("dd-MM-yyyy").parse(ngaySua);
            java.util.Date utilDate3 = new SimpleDateFormat("dd-MM-yyyy").parse(nSX);
            java.util.Date utilDate4 = new SimpleDateFormat("dd-MM-yyyy").parse(hSD);
            
            java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
            java.sql.Date sqlDate3 = new java.sql.Date(utilDate3.getTime());
            java.sql.Date sqlDate4 = new java.sql.Date(utilDate4.getTime());
            
            String donGiaStr = txtDonGia.getText().trim();
            String trangThaiStr = cbbTrangThai.getSelectedItem().toString();
            double donGia = Double.parseDouble(donGiaStr);
            int trangThai = Integer.parseInt(trangThaiStr);
            
            if (ma.length() == 0) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                return;
            }
            Product product = new Product("", ma, ten, nguonGoc, donGia, sqlDate3, sqlDate4, idDanhMuc, sqlDate1, sqlDate2, trangThai);
            
            this.productService.update(product, id);
            
            loadTable();
            JOptionPane.showMessageDialog(this, "Update thành công");
            
        } catch (ParseException ex) {
            Logger.getLogger(JFrQuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void searchProductByID() {
     
    }
    
 
    private void clear() {
        this.txtID.setText("");
        this.txtMaSP.setText("");
        this.txtTenSp.setText("");
        this.cbbDanhMuc.setSelectedIndex(0);
        this.txtNguonGoc.setText("");
        this.txtNgayTao.setText("");
        this.txtNgaySua.setText("");
        this.txtNSX.setText("");
        this.txtHSD.setText("");
        this.txtDonGia.setText("");
        this.cbbTrangThai.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always //
     * * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnHeader = new javax.swing.JPanel();
        lbClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnKhoHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhoHang = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbFinddanhMuc = new javax.swing.JComboBox<>();
        btnTimTheoMa = new javax.swing.JButton();
        jpnNavigation = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnInput = new javax.swing.JButton();
        btnOutput = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTenSp = new javax.swing.JTextField();
        txtNguonGoc = new javax.swing.JTextField();
        txtNSX = new javax.swing.JTextField();
        txtHSD = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jpnCRUD = new javax.swing.JPanel();
        btnNhapKho = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtNgaySua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        cbbDanhMuc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnHeader.setBackground(new java.awt.Color(153, 153, 255));

        lbClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Close Window_3.png"))); // NOI18N
        lbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Shop.png"))); // NOI18N
        jLabel1.setText("Nhóm 3");

        javax.swing.GroupLayout jpnHeaderLayout = new javax.swing.GroupLayout(jpnHeader);
        jpnHeader.setLayout(jpnHeaderLayout);
        jpnHeaderLayout.setHorizontalGroup(
            jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(910, 910, 910)
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnHeaderLayout.setVerticalGroup(
            jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnHeaderLayout.createSequentialGroup()
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jpnKhoHang.setBackground(new java.awt.Color(255, 255, 255));
        jpnKhoHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kho Hàng\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        tblKhoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Danh mục", "Nguồn gốc", "Ngày tạo", "Ngày sửa", "NSX", "HSD", "Đơn giá", "Trạng thái"
            }
        ));
        tblKhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhoHang);

        txtTimKiem.setBackground(new java.awt.Color(249, 249, 249));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Danh mục");

        cbbFinddanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh Mục" }));

        btnTimTheoMa.setText("Tìm theo mã");
        btnTimTheoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTheoMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnKhoHangLayout = new javax.swing.GroupLayout(jpnKhoHang);
        jpnKhoHang.setLayout(jpnKhoHangLayout);
        jpnKhoHangLayout.setHorizontalGroup(
            jpnKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoHangLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnTimTheoMa)
                .addGap(28, 28, 28)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbFinddanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jpnKhoHangLayout.setVerticalGroup(
            jpnKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoHangLayout.createSequentialGroup()
                .addGroup(jpnKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbbFinddanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimTheoMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
        );

        jpnNavigation.setBackground(new java.awt.Color(153, 153, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Kho Hàng");

        btnInput.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInput.setForeground(new java.awt.Color(0, 0, 255));
        btnInput.setText("Input Excel");
        btnInput.setBorder(new javax.swing.border.MatteBorder(null));
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnOutput.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOutput.setForeground(new java.awt.Color(255, 0, 102));
        btnOutput.setText("Output Execl");
        btnOutput.setBorder(new javax.swing.border.MatteBorder(null));
        btnOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnNavigationLayout = new javax.swing.GroupLayout(jpnNavigation);
        jpnNavigation.setLayout(jpnNavigationLayout);
        jpnNavigationLayout.setHorizontalGroup(
            jpnNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addGroup(jpnNavigationLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpnNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(btnInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNavigationLayout.setVerticalGroup(
            jpnNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNavigationLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập kho\n\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel7.setText("Mã SP");

        jLabel8.setText("Tên SP");

        jLabel10.setText("Danh mục");

        jLabel11.setText("Nguồn gốc");

        jLabel12.setText("NSX");

        jLabel13.setText("HSD");

        jLabel14.setText("Đơn giá");

        jLabel17.setText("Trạng thái");

        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbbTrangThai.setForeground(new java.awt.Color(255, 0, 102));
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", " " }));

        jpnCRUD.setBackground(new java.awt.Color(255, 204, 204));
        jpnCRUD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        btnNhapKho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapKho.setForeground(new java.awt.Color(0, 0, 255));
        btnNhapKho.setText("Nhập kho");
        btnNhapKho.setBorder(new javax.swing.border.MatteBorder(null));
        btnNhapKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapKhoActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 204, 0));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.MatteBorder(null));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.MatteBorder(null));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(new javax.swing.border.MatteBorder(null));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnCRUDLayout = new javax.swing.GroupLayout(jpnCRUD);
        jpnCRUD.setLayout(jpnCRUDLayout);
        jpnCRUDLayout.setHorizontalGroup(
            jpnCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCRUDLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnNhapKho, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpnCRUDLayout.setVerticalGroup(
            jpnCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCRUDLayout.createSequentialGroup()
                .addGroup(jpnCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapKho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jLabel15.setText("Ngày tạo");

        jLabel16.setText("Ngày sửa");

        jLabel2.setText("ID");

        txtID.setEditable(false);

        cbbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh mục" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSp, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtID)
                    .addComponent(cbbDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jpnCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNguonGoc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)))
                                .addGap(3, 3, 3))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtNguonGoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnNavigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnKhoHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpnNavigation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?");
        if (check == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbCloseMouseClicked

    private void tblKhoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoHangMouseClicked
        mouseClick();
    }//GEN-LAST:event_tblKhoHangMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        
//        String importFilePath = "/Users/maccuacu/Desktop/da1/QuanlyChuoiCH/src/Excel/Products.xlsx" ;
//        try {
//            productDAO.importProductsFromExcel(importFilePath);
//        } catch (IOException ex) {
//            Logger.getLogger(JFrQuanLy.class.getName()).log(Level.SEVERE, null, ex);
//        }
        ReadFileExcel.readFile();
        loadTable();

    }//GEN-LAST:event_btnInputActionPerformed

    private void btnOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutputActionPerformed
        
//        String exportFilePath = "Products.xlsx";
//        try {
//            productDAO.exportProductsToExcel(exportFilePath);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(JFrQuanLy.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_btnOutputActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNhapKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapKhoActionPerformed
        add();
    }//GEN-LAST:event_btnNhapKhoActionPerformed

    private void btnTimTheoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTheoMaActionPerformed
        searchProductByID();
    }//GEN-LAST:event_btnTimTheoMaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrQuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnNhapKho;
    private javax.swing.JButton btnOutput;
    private javax.swing.JButton btnTimTheoMa;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbFinddanhMuc;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnCRUD;
    private javax.swing.JPanel jpnHeader;
    private javax.swing.JPanel jpnKhoHang;
    private javax.swing.JPanel jpnNavigation;
    private javax.swing.JLabel lbClose;
    private javax.swing.JTable tblKhoHang;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNSX;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguonGoc;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
