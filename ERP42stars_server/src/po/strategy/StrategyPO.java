package po.strategy;

import java.io.Serializable;
import java.sql.Date;


/**
 * 销售策略
 * @author mxf,LZB (if bugs found ,please contact at 161250063@smail.nju.edu.cn)
 *
 */
public abstract class StrategyPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Date startTime;              //起始时间
	int durationDays;                //持续时间,以天为单位
	String id;
		
	
	/**
	 * constructor
	 * @param startTime
	 * @param duration
	 * @param id
	 */
	public StrategyPO( String id,Date startTime, int duration){
		this.startTime = startTime;
		this.durationDays = duration;
		this.id = id;
	}
	
	
	
	
	
	public Date getStartTime(){return startTime;}
	public int getDurationDays(){return durationDays;}
	public String getID(){return id;}
	
	
	public boolean setStartTime(Date newStartTime){startTime = newStartTime;return true;}
	public boolean setDurationDays(int days){this.durationDays=days;return true;}
	public boolean setID(String newID){return true;}
	
}
