package BL.reportBL.unused;

import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TestExcel {

	public static void main(String[] args) throws Exception {
		File file = new File("c:\\Users\\lzb\\Desktop\\test.xls");
		WritableWorkbook book = Workbook.createWorkbook(file);
		WritableSheet sheet = book.createSheet("saleReport", 0);
		
		int col =4;
		int row = 1;
		Label first = new Label(col,row,"test");
		sheet.addCell(first);
		book.write();
		book.close();
		
		
		Workbook oldbook = Workbook.getWorkbook(file);
		WritableWorkbook book2 = Workbook.createWorkbook(file,oldbook);
		WritableSheet sheet2 = book2.createSheet("test2", 1);
		
		Label second = new Label(col,row,"second");
		sheet2.addCell(second);
		book2.write();
		book2.close();

		
	}
}
