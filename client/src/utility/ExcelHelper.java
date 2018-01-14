package utility;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelHelper {

	/**
	 * 将报表导入excel
	 * @param tableName
	 * @param content
	 * @param filePath
	 * @return
	 */
	public static boolean toNewExcel(String tableName,String[][] content , String filePath) {
		File file = new File(filePath);
		try {
			
			WritableWorkbook book = Workbook.createWorkbook(file);
			WritableSheet sheet = book.createSheet(tableName, 0);
			
			int col =0 ,row =0;
			
			for (row = 0;row < content.length; row++) {
				String[] line = content[row];
				
				for (col = 0; col < line.length;col++) {
					Label each = new Label(col,row,line[col]);
					sheet.addCell(each);
				}
				
			}
			
			book.write();
			book.close();
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public static boolean appToExcel(String sheetName , String[][] content ,String filePath) {
		
		if (filePath==null || "".equals(filePath.trim())) {
			return false;
		}
		
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		}
		
		try {
			Workbook oldBook = Workbook.getWorkbook(file);
			WritableWorkbook newBook = Workbook.createWorkbook(file,oldBook);
			WritableSheet sheet = newBook.createSheet(sheetName, newBook.getNumberOfSheets());

			int col =0 ,row =0;
			
			for (row = 0;row < content.length; row++) {
				String[] line = content[row];
				
				for (col = 0; col < line.length;col++) {
					Label each = new Label(col,row,line[col]);
					sheet.addCell(each);
				}
				
			}
			
			newBook.write();
			newBook.close();
			return true;

			
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
