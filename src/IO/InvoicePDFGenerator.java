package IO;

/**
 *
 * @author maccuacu
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import model.Items;
import model.Order;
import model.OrderDetail;
import model.ShoppingCart;

public class InvoicePDFGenerator {

    public static void exportPDF(Order order, OrderDetail detail, ShoppingCart shoppingCart) {
        File folder = new File("InvoicePDF");

        if (!folder.exists()) {
            folder.mkdir();
        }
        String invoiceNumber = order.getMa();
        Date date = order.getNgaySua();
        double totalAmount = detail.getTongTien();
        List<Items> list = shoppingCart.getItemsList();

        String tenKH = order.getIdKh();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("/Users/maccuacu/Desktop/da1/QuanlyChuoiCH/src/InvoicePDF/invoice.pdf"));
            document.open();
            Font vietnameseFont = FontFactory.getFont("Arial", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            // Thêm thông tin hóa đơn vào PDF
            document.add(new Paragraph("Hóa đơn số: " + invoiceNumber,vietnameseFont));
            document.add(new Paragraph("Tên khách hàng: " + tenKH,vietnameseFont));
            int i=0;
            for (Items items : list) {
                i++;
                document.add(new Paragraph("Sản phẩm " + i + ": " + items.getNameProducs(),vietnameseFont));
                document.add(new Paragraph("Số lượng sản phẩm " + i + ": " + items.getQuantity(),vietnameseFont));
                document.add(new Paragraph("Giá sản phẩm " + i + ": " + items.getPrice(),vietnameseFont));

            }
            document.add(new Paragraph("Ngày mua: " + date.toString(),vietnameseFont));
            document.add(new Paragraph("Tổng tiền: " + totalAmount,vietnameseFont));

            document.close();

            System.out.println("Hóa đơn đã được tạo thành công. Đã lưu thành công vào tệp invoice.pdf");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
