import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.util.*;

public class testSheetData {
    public static void main(String args[]) throws IOException {
        try {
            File file = new File("test.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int cellTyping = cell.getCellType();

                    switch (cellTyping) {
                        case 1:    //field that represents string cell type
                            System.out.print(cell.getStringCellValue() + "\t\t\t");
                            break;
                        case 0:    //field that represents number cell type
                            System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                            System.out.print("-Empty Cell-");
                            break;
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}