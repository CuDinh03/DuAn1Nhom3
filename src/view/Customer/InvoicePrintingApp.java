/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InvoicePrintingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Invoice Printing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JButton printButton = new JButton("In hóa đơn");

        // Thêm ActionListener cho nút "In hóa đơn"
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gọi phương thức để tạo và in hóa đơn PDF
                createAndPrintInvoice();
            }
        });

        panel.add(printButton);
        frame.add(panel);
        
        frame.pack();
        frame.setVisible(true);
    }

    // Phương thức để tạo và in hóa đơn PDF
    private static void createAndPrintInvoice() {
        Document document = new Document();
        try {
            // Chọn vị trí lưu tệp PDF
            PdfWriter.getInstance(document, new FileOutputStream("/Users/maccuacu/Desktop/da1/QuanlyChuoiCH/src/InvoicePDF/invoice.pdf"));

            // Mở tài liệu để bắt đầu viết
            document.open();

            // Thêm nội dung vào tài liệu
            Paragraph title = new Paragraph("Hóa đơn", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            document.add(title);

            // Thêm thông tin hóa đơn và sản phẩm
            Paragraph invoiceInfo = new Paragraph("Số hóa đơn: 12345\nNgày: 2023-09-05", FontFactory.getFont(FontFactory.HELVETICA, 12));
            document.add(invoiceInfo);

            // Thêm sản phẩm vào hóa đơn
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            PdfPCell cell1 = new PdfPCell(new Phrase("Tên sản phẩm"));
            PdfPCell cell2 = new PdfPCell(new Phrase("Số lượng"));
            PdfPCell cell3 = new PdfPCell(new Phrase("Giá"));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            // Điền dữ liệu sản phẩm vào bảng
            table.addCell("Sản phẩm A");
            table.addCell("5");
            table.addCell("$10.00");

            table.addCell("Sản phẩm B");
            table.addCell("3");
            table.addCell("$15.00");

            document.add(table);

            // Tạo và thêm tổng tiền
            Paragraph total = new Paragraph("Tổng tiền: $55.00", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            document.add(total);

            // Đóng tài liệu để hoàn thành in
            document.close();

            JOptionPane.showMessageDialog(null, "Hóa đơn đã được in thành công!", "In hóa đơn", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

