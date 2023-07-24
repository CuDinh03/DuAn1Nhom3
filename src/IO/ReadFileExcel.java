package IO;

import DAO.ProductDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import model.Product;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFileExcel {

    public static void readFile() {
        try {
            FileInputStream excelFile = new FileInputStream(new File("D:\\DuAn1_Java_PTPM\\Du_an_1\\DuAn1Nhom3\\src\\Excel\\Products.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }

                String ma = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                int soLuong = (int) row.getCell(2).getNumericCellValue();
                String nguonGoc = row.getCell(3).getStringCellValue();
                double giaGoc = row.getCell(4).getNumericCellValue();
                Date ngaySx = new Date(row.getCell(5).getDateCellValue().getTime());
                Date hsd = new Date(row.getCell(6).getDateCellValue().getTime());
                String idDanhMuc = row.getCell(7).getStringCellValue();
                Date ngayTao = new Date(row.getCell(8).getDateCellValue().getTime());
                Date ngaySua = new Date(row.getCell(9).getDateCellValue().getTime());
                int status = (int) row.getCell(10).getNumericCellValue();

                Product product = new Product(ma, name, soLuong, nguonGoc, giaGoc, ngaySx, hsd, idDanhMuc, ngayTao, ngaySua, status);
                ProductDAO pdao = new ProductDAO();
                pdao.addProduct(product);
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

}
