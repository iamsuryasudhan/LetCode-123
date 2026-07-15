package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    static String path = "C:\\Users\\vsgov\\eclipse-workspace\\LetCodeAutomation\\src\\main\\resources\\TestData.xlsx";

   
    public static String getCellData(String sheetName, int row, int col) throws Exception {

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);

        Row r = sheet.getRow(row);
        Cell cell = r.getCell(col);

        String data = cell.toString();

        wb.close();
        fis.close();

        return data;
    }

   
    public static void setCellData(String sheetName, int row, int col, String data) throws Exception {

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);

        Row r = sheet.getRow(row);
        if (r == null) {
            r = sheet.createRow(row);
        }

        Cell cell = r.getCell(col);
        if (cell == null) {
            cell = r.createCell(col);
        }

        cell.setCellValue(data);

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        wb.close();
        fis.close();
        fos.close();
    }
}