package vo.goods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import BL.stockBL.Goods;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class SnapshotVO {

	
	
	ArrayList<GoodsForShotVO> goodslist = new ArrayList<GoodsForShotVO>();
	
	
	public SnapshotVO(ArrayList<Goods> list){
		for (Goods each: list) {
			goodslist.add(each.toSnapShot());
		}

	}
	
	
	public boolean toExcel(String filePath) {
		if (this.goodslist==null || this.goodslist.size()==0) {
			System.out.println("the goodsForShotVO list is empty ,while toExcel");
			return false;
		}
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File(filePath));
			WritableSheet sheet = book.createSheet("库存快照", 0);
			
			int row = 0;
			int col = 0;
			Label id1 = new Label(col++,row,"商品编号");
			Label name1 = new Label(col++,row,"商品名称");
			Label type1= new Label(col++,row,"型号");
			Label number1 = new Label(col++,row,"数量");
			Label averPrice1 = new Label(col++,row,"平均价格");
			Label Batch1 = new Label(col++,row,"批次");
			Label date1= new Label(col++,row,"生产日期");
			
			sheet.addCell(id1);
			sheet.addCell(name1);
			sheet.addCell(type1);
			sheet.addCell(number1);
			sheet.addCell(averPrice1);
			sheet.addCell(Batch1);
			sheet.addCell(date1);

			
			
			for (GoodsForShotVO goods : this.goodslist) {
				col = 0;row++;
				Label id = new Label(col++,row,goods.getId());
				Label name = new Label(col++,row,goods.getName());
				Label type = new Label(col++,row,goods.getType());
				Label number = new Label(col++,row,Integer.toString(goods.getNumber()));
				Label averPrice = new Label(col++,row,Double.toString(goods.getAverPrice()));
				Label Batch = new Label(col++,row,goods.getBatchID());
				Label date = new Label(col++,row,goods.getProductionDate().toString());
				
				sheet.addCell(id);
				sheet.addCell(name);
				sheet.addCell(type);
				sheet.addCell(number);
				sheet.addCell(averPrice);
				sheet.addCell(Batch);
				sheet.addCell(date);
				
				
				
			}
			
			book.write();
			book.close();
			
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
		return true;
	}
}
