package IO;

/**
 *
 * @author maccuacu
 */
import DAO.ProductDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Items;
import model.Order;
import model.OrderDetail;
import model.ShoppingCart;

public class InvoicePDFGenerator {


//        File folder = new File("InvoicePDF");
//
//        if (!folder.exists()) {
//            folder.mkdir();
//        }
//        String invoiceNumber = order.getCode();
//        Date date = order.getUpdateDate();
//        BigDecimal totalAmount = detail.getTotal();
//        List<Items> list = shoppingCart.getItemsList();
//
//        String tenKH = order.getIdCustomer();
//
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream("/Users/maccuacu/Desktop/da1/QuanlyChuoiCH/src/InvoicePDF/invoice.pdf"));
//            document.open();
//            Font vietnameseFont = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//
//            // Thêm thông tin hóa đơn vào PDF
//            document.add(new Paragraph("Hóa đơn số: " + invoiceNumber,vietnameseFont));
//            document.add(new Paragraph("Tên khách hàng: " + tenKH,vietnameseFont));
//            for (Items items : list) {
//                i++;
//                document.add(new Paragraph("Sản phẩm " + i + ": " + items.getNameProducs(),vietnameseFont));
//                document.add(new Paragraph("Số lượng sản phẩm " + i + ": " + items.getQuantity(),vietnameseFont));
//                document.add(new Paragraph("Giá sản phẩm " + i + ": " + items.getPrice(),vietnameseFont));
//
//            }
//            document.add(new Paragraph("Ngày mua: " + date.toString(),vietnameseFont));
//            document.add(new Paragraph("Tổng tiền: " + totalAmount,vietnameseFont));
//
//            document.close();
//
//            System.out.println("Hóa đơn đã được tạo thành công. Đã lưu thành công vào tệp invoice.pdf");
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    

    // Phương thức để tạo và in hóa đơn PDF
    public static void createAndPrintInvoice(Order order, OrderDetail detail, ShoppingCart shoppingCart) {
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
            Paragraph invoiceInfo = new Paragraph("Mã hóa đơn:" + order.getCode() , FontFactory.getFont(FontFactory.HELVETICA, 12));
            document.add(invoiceInfo);

            // Thêm sản phẩm vào hóa đơn
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            List<Items> list = shoppingCart.getItemsList();
            PdfPCell cell1 = new PdfPCell(new Phrase("Tên sản phẩm"));
            PdfPCell cell2 = new PdfPCell(new Phrase("Số lượng"));
            PdfPCell cell3 = new PdfPCell(new Phrase("Giá"));
                        table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            for (Items items : list) {
                ProductDAO productDAO = new ProductDAO();
                String name = productDAO.getProductById(items.getNameProducs()).getPrName();
                table.addCell( name);
                table.addCell(String.valueOf(items.getQuantity()));
                table.addCell( String.valueOf(items.getPrice()));

            }




//            // Điền dữ liệu sản phẩm vào bảng
//            table.addCell("Sản phẩm A");
//            table.addCell("5");
//            table.addCell("$10.00");
//
//            table.addCell("Sản phẩm B");
//            table.addCell("3");
//            table.addCell("$15.00");

            document.add(table);

            // Tạo và thêm tổng tiền
            Paragraph total = new Paragraph("Tổng tiền: "  + detail.getTotal() + " $", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            document.add(total);
            document.add(new Paragraph("Ngày mua: " + order.getCreateDate().toString(),FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));


            // Đóng tài liệu để hoàn thành in
            document.close();

            JOptionPane.showMessageDialog(null, "Hóa đơn đã được in thành công!", "In hóa đơn", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
