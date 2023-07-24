/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.Shopping;

/**
 *
 * @author maccuacu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InvoiceQueueExample extends JFrame {
    private JList<String> invoiceList;
    private DefaultListModel<String> listModel;
    private JButton btnViewInvoice;
    private JButton btnPayInvoice;

    public InvoiceQueueExample() {
        // Tạo và khởi tạo listModel
        listModel = new DefaultListModel<>();
        invoiceList = new JList<>(listModel);

        // Tạo và cấu hình các nút
        btnViewInvoice = new JButton("View Invoice");
        btnPayInvoice = new JButton("Pay Invoice");

        // Xử lý sự kiện khi bấm nút "View Invoice"
        btnViewInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = invoiceList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String selectedInvoice = listModel.getElementAt(selectedIndex);
                    // Hiển thị hoá đơn tương ứng với mã hoá đơn trong selectedInvoice
                    JOptionPane.showMessageDialog(InvoiceQueueExample.this, "View Invoice: " + selectedInvoice);
                } else {
                    JOptionPane.showMessageDialog(InvoiceQueueExample.this, "Please select an invoice to view.");
                }
            }
        });

        // Xử lý sự kiện khi bấm nút "Pay Invoice"
        btnPayInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = invoiceList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String selectedInvoice = listModel.getElementAt(selectedIndex);
                    // Thực hiện thanh toán hoá đơn tương ứng với mã hoá đơn trong selectedInvoice
                    payInvoice(selectedInvoice);
                } else {
                    JOptionPane.showMessageDialog(InvoiceQueueExample.this, "Please select an invoice to pay.");
                }
            }
        });

        // Đặt layout và thêm các thành phần vào JFrame
        setLayout(new BorderLayout());
        add(new JScrollPane(invoiceList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnViewInvoice);
        buttonPanel.add(btnPayInvoice);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Invoice Queue Example");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Phương thức thêm hoá đơn vào danh sách hoá đơn chờ
    private void addInvoiceToQueue(String invoiceNumber) {
        listModel.addElement(invoiceNumber);
    }

    // Phương thức thực hiện thanh toán hoá đơn
    private void payInvoice(String invoiceNumber) {
        // Thực hiện thanh toán hoá đơn có mã là invoiceNumber
        JOptionPane.showMessageDialog(this, "Pay Invoice: " + invoiceNumber);
        // Sau khi thanh toán xong, bạn có thể xóa hoá đơn này khỏi danh sách hoá đơn chờ nếu cần
        listModel.removeElement(invoiceNumber);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvoiceQueueExample frame = new InvoiceQueueExample();
            frame.setVisible(true);

            // Thêm hoá đơn chờ vào danh sách
            frame.addInvoiceToQueue("INV-001");
            frame.addInvoiceToQueue("INV-002");
            frame.addInvoiceToQueue("INV-003");
            frame.addInvoiceToQueue("INV-004");
        });
    }
}

