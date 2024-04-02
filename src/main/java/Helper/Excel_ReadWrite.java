package Helper;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Excel_ReadWrite {
    static private String ExcelFilePath;
   static private FileInputStream fileIn;
   static private FileOutputStream fileOut;
  static private Workbook wb;
   static private Sheet sh;
    static private Cell cell;
   static private Column column;
   static private Row row;
   static private CellStyle cellStyle;
   static private Color mycolor;
   static private String excelFilePath;
   //static private String excelFilePath;
    static private Map<String, Integer> columns = new HashMap<>();



    public static void setExcelFile (String ExcelPath, String SheetName){
        try {
            File f = new File(ExcelPath); //khai báo file excel
            if (!f.exists()){
                f.createNewFile();
                System.out.println("File don't exist, so create");
            }
            fileIn = new FileInputStream(ExcelPath);
            wb = WorkbookFactory.create(fileIn);
            sh = wb.getSheet(SheetName); //get sheet chứa data
            if (sh == null){
                sh = wb.createSheet(SheetName); // nếu sheet ko có tạo sheet mới
            }
           excelFilePath =ExcelPath;
            //this.excelFilePath = ExcelPath;
            sh.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            } );
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //read data from excel file
    public static String readCellData(int rownum, int colnum) throws Exception{
        try {
            cell =sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)){
                        CellData = String.valueOf(cell.getDateCellValue());
                    }
                    else
                    {
                        CellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        }
        catch (Exception e){
            System.out.println("");
        }
        return " ";
    }
    //write data in excel file
    public static void writeCellData (String text, int rownum, int colnum) throws Exception{
        try {
            row = sh.getRow(rownum);
            if (row == null){
                row = sh.createRow(rownum);
            }
            cell = row.getCell(colnum);
            if (cell== null){
                cell = row.createCell(colnum);
            }
            cell.setCellValue(text);
            fileOut = new FileOutputStream(excelFilePath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
        catch (Exception e){
            //throw (e.getMessage(""));
            System.out.println("");
        }
    }

}
