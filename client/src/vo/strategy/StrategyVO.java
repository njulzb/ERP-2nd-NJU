package vo.strategy;



import java.util.Date;

import po.strategy.StrategyPO;
import vo.Form.tradeFormVO.SaleExportFormVO;

/**
 * 销售策略
 * @author mxf，LZB
 *
 */
public abstract class StrategyVO {
    Date startTime;               //起始时间
	int durationDays ;             //持续时间,以天为单位
	String ID;
		

	

	public StrategyVO(Date startTime, int duration,String id){

		this.startTime = startTime;
		this.durationDays = duration;
		this.ID = id;
	}
	
	public StrategyVO(StrategyPO po) {
		this.ID = po.getID();
		this.startTime = po.getStartTime();
		this.durationDays = po.getDurationDays();
		
	}
	
	abstract public StrategyPO toPO();
	
	abstract public StrategyResult calculateResult(SaleExportFormVO form);
	
	
	abstract public boolean equals(Object obj);
	
	
	//get methods
	public Date getStartTime(){return startTime;}
	public int getDuration(){return durationDays;}
	public String getID(){return ID;}
	
	//set methods
	public boolean setStartTime(Date newStartTime){startTime = newStartTime;return true;}
	public boolean setDuration(int days){this.durationDays=days;return true;}
	public boolean setID(String newID){this.ID = newID;return true;}
}
