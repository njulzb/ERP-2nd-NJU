package DataService.strategyDataService.stub;

import java.util.ArrayList;
import java.util.Iterator;

public class JustForTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(21321);
		System.out.println(searchByID(list.iterator(),21321));
		
	}
	
	public static Integer searchByID(Iterator<?> it,int id) {
		if (it==null) {
			return null;
		}
		while (it.hasNext()) {
			
			Integer cur = (Integer)it.next();
			if (cur.intValue()==id) {
				return cur;
			}
			
		}
		
		return null;
	}

}
