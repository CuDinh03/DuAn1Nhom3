package IO;

import DAO.ProductDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;
import model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFileExcel {

    public static void readFile() {
        try {
            FileInputStream excelFile = new FileInputStream(new File("/Users/maccuacu/Desktop/da1/QuanlyChuoiCH/src/Excel/Products.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }

                String ma = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                String nguonGoc = row.getCell(2).getStringCellValue();
                double giaGoc = row.getCell(3).getNumericCellValue();
                Date ngaySx = new Date(row.getCell(4).getDateCellValue().getTime());
                Date hsd = new Date(row.getCell(5).getDateCellValue().getTime());
                String idDanhMuc = row.getCell(6).getStringCellValue();
                Date ngayTao = new Date(row.getCell(7).getDateCellValue().getTime());
                Date ngaySua = new Date(row.getCell(8).getDateCellValue().getTime());
                int status = (int) row.getCell(9).getNumericCellValue();

                Product product = new Product(ma, name, nguonGoc, giaGoc, ngaySx, hsd, idDanhMuc, ngayTao, ngaySua, status);
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
