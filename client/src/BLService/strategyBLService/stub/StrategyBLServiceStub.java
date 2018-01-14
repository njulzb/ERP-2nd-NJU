package BLService.strategyBLService.stub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import BLService.strategyBLService.StrategyBLService;
import vo.strategy.StrategyVO;


public class StrategyBLServiceStub implements StrategyBLService {

	ArrayList<StrategyVO> list ;
	
	public StrategyBLServiceStub() {
		this.list = new ArrayList<StrategyVO>();
	}
	
	
	@Override
	public String createStrategy(StrategyVO newStrategy) {
		// TODO Auto-generated method stub
		DateFormat format = new SimpleDateFormat("yyMMddhhmmss");
		String datestr =  format.format(new Date());
		newStrategy.setID(datestr);
		this.list.add(newStrategy);
		return datestr;
	}

	@Override
	public boolean deleteStrategy(String id) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.list.size();i++) {
			if (this.list.get(i).getID().equals(id)) {
				this.list.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateStrategy(StrategyVO newer) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.list.size();i++) {
			if (this.list.get(i).getID().equals(newer.getID())) {
				this.list.remove(i);
				this.list.add(i,newer);
				return true;
			}
		}
		return false;
	}

	@Override
	public StrategyVO searchStrategy(String id) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.list.size();i++) {
			if (this.list.get(i).getID().equals(id)) {
				return this.list.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<StrategyVO> getAllStrategy() {
		// TODO Auto-generated method stub
		return this.list;
	}
	
}
