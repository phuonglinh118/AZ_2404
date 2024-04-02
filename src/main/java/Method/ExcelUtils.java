package Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e){

            throw (e);

        }

    }

    public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception

    {

        String[][] tabArray = null;

        try{

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startCol = 1;

            int ci=0,cj=0;

            int totalRows = 1;

            int totalCols = 2;

            tabArray=new String[totalRows][totalCols];

            for (int j=startCol;j<=totalCols;j++, cj++)

            {

                tabArray[ci][cj]=getCellData(iTestCaseRow,j);

                System.out.println(tabArray[ci][cj]);

            }

        }

        catch (FileNotFoundException e)

        {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e)

        {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return(tabArray);

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

        try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();

            return CellData;

        }catch (Exception e){

            return"";

        }

    }

    public static String getTestCaseName(String sTestCase)throws Exception{

        String value = sTestCase;

        try{

            int posi = value.indexOf("@");

            value = value.substring(0, posi);

            posi = value.lastIndexOf(".");

            value = value.substring(posi + 1);

            return value;

        }catch (Exception e){

            throw (e);

        }

    }

    public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

        int i;

        try {

            int rowCount = ExcelUtils.getRowUsed();

            for ( i=0 ; i<rowCount; i++){

                if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

                    break;

                }

            }

            return i;

        }catch (Exception e){

            throw(e);

        }

    }

    public static int getRowUsed() throws Exception {

        try{

            int RowCount = ExcelWSheet.getLastRowNum();

            return RowCount;

        }catch (Exception e){

            System.out.println(e.getMessage());

            throw (e);

        }

    }

    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter = new DataFormatter();

    public Object[][] getExcelData(String excelSheetPath, String sheetName) {
        Object[][] Data = new Object[0][];
        try (
                OPCPackage pkg = OPCPackage.open(new File(excelSheetPath)); //excel File path
        ) {
            workbook = new XSSFWorkbook(pkg); //work dùng cho file xlxs
            worksheet = workbook.getSheet(sheetName);// get my sheet from workbook
            XSSFRow Row = worksheet.getRow(0);   // lấy row bắt đầu từ 0
            int RowNum = worksheet.getPhysicalNumberOfRows();// tổng row
            int ColNum = Row.getLastCellNum(); // colum cuối cùng

            Data = new Object[RowNum - 1][ColNum];

            for (int i = 0; i < RowNum - 1; i++) // loop chạy từ row trước
            {
                XSSFRow row = worksheet.getRow(i + 1);

                for (int j = 0; j < ColNum; j++) //Loop chạy tiếp theo colum
                {
                    if (row == null)
                        Data[i][j] = "";
                    else {
                        XSSFCell cell = row.getCell(j);
                        if (cell == null)
                            Data[i][j] = ""; //if it get Null value it pass no data
                        else {
                            String value = formatter.formatCellValue(cell);
                            Data[i][j] = value;

                        }
                    }
                }
            }
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        return Data;
    }
}

