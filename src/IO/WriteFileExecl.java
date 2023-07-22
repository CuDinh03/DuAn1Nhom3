
package IO;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import model.Product;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteFileExecl {
    public static void writeFile(List<Product> productList) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Products");


            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Ma");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("NguonGoc");
            headerRow.createCell(3).setCellValue("GiaGoc");
            headerRow.createCell(4).setCellValue("NgaySx");
            headerRow.createCell(5).setCellValue("Hsd");
            headerRow.createCell(6).setCellValue("IdDanhMuc");
            headerRow.createCell(7).setCellValue("NgayTao");
            headerRow.createCell(8).setCellValue("NgaySua");
            headerRow.createCell(9).setCellValue("Status");

            int rowIndex = 1;
            for (Product product : productList) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(product.getMa());
                row.createCell(1).setCellValue(product.getName());
                row.createCell(2).setCellValue(product.getNguonGoc());
                row.createCell(3).setCellValue(product.getGiaGoc());
                row.createCell(4).setCellValue(product.getNgaySx());
                row.createCell(5).setCellValue(product.getHsd());
                row.createCell(6).setCellValue(product.getIdDanhMuc());
                row.createCell(7).setCellValue(product.getNgayTao());
                row.createCell(8).setCellValue(product.getNgaySua());
                row.createCell(9).setCellValue(product.getStatus());
            }


            FileOutputStream fileOut = new FileOutputStream("D:\\DuAn1_Java_PTPM\\Du_an_1\\DuAn1Nhom3\\src\\Excel\\Products.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
