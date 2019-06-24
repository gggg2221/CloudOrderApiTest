//package org.zt.common;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
///**
// * Created by zt on 2018/12/21.
// */
//public class ExcelUtils {
//    private static Sheet ExcelWSheet;
//    private static Workbook ExcelWBook;
//    private static Cell Cell;
//    private static XSSFRow Row;
//    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
//        String[][] tabArray = null;
//        try {
//            if (FilePath.endsWith(".xls")) {
//                FileInputStream ExcelFile = new FileInputStream(FilePath);
//                ExcelWBook = new HSSFWorkbook(ExcelFile);
//            }else if (FilePath.endsWith(".xlsx") || FilePath.endsWith(".xlsm")) {
//                ExcelWBook = new XSSFWorkbook(FilePath);
//            }
//            ExcelWSheet = ExcelWBook.getSheet(SheetName);
//            int testcols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
////            System.out.println("totalCols="+String.valueOf(testcols));
//            int startRow = 1;
//            int startCol = 1;
//            int ci,cj;
//            int totalRows = ExcelWSheet.getLastRowNum();
////            System.out.println(totalRows);
//            // you can write a function as well to get Column count
//            int totalCols = testcols-1;
////            System.out.println(totalCols);
//            tabArray=new String[totalRows][totalCols];
//            ci=0;
//            for (int i=startRow;i<=totalRows;i++, ci++) {
//                cj=0;
//                for (int j=startCol;j<=totalCols;j++, cj++){
//                    tabArray[ci][cj]=getCellData(i,j);
////                    System.out.println(tabArray[ci][cj]);
//                }
//            }
//        }
//        catch (FileNotFoundException e){
//            System.out.println("Could not read the Excel sheet");
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            System.out.println("Could not read the Excel sheet");
//            e.printStackTrace();
//        }
//        return tabArray;
//    }
//    public static String getCellData(int RowNum, int ColNum) throws Exception {
//        try{
//            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
//            int dataType = Cell.getCellType();
//            if  (dataType == 3) {
//                return "";
//            }
//            else{
//                String CellData = Cell.getStringCellValue();
//                return CellData;
//            }
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            throw (e);
//        }
//    }
//}
