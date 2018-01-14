package po;

import java.io.Serializable;
import java.sql.Timestamp;

import utility.LevelOfCustomer;
import utility.StateOfForm;
import utility.TypeOfCustomer;

public class KeyForSearchCustomer implements Serializable{
	private static final long serialVersionUID = -37153434135953041L;
	
	
	
	private String ID;
	private String defaultOperatorID;
	private TypeOfCustomer type;
	private LevelOfCustomer LevelMin,LevelMax;	
	String name;
	
	
	double receiveLimitMin=-1 ,receiveLimitMax=-1 ;
	double receiveAmountMin=-1,receiveAmountMax=-1;
	double payAmountMin=-1,payAmountMax=-1;
	
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDefaultOperatorID() {
		return defaultOperatorID;
	}
	public void setDefaultOperatorID(String defaultOperatorID) {
		this.defaultOperatorID = defaultOperatorID;
	}
	public TypeOfCustomer getType() {
		return type;
	}
	public void setType(TypeOfCustomer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getReceiveLimitMin() {
		return receiveLimitMin;
	}
	public void setReceiveLimitMin(double receiveLimitMin) {
		this.receiveLimitMin = receiveLimitMin;
	}
	public double getReceiveLimitMax() {
		return receiveLimitMax;
	}
	public void setReceiveLimitMax(double receiveLimitMax) {
		this.receiveLimitMax = receiveLimitMax;
	}
	public double getReceiveAmountMin() {
		return receiveAmountMin;
	}
	public void setReceiveAmountMin(double receiveAmountMin) {
		this.receiveAmountMin = receiveAmountMin;
	}
	public double getReceiveAmountMax() {
		return receiveAmountMax;
	}
	public void setReceiveAmountMax(double receiveAmountMax) {
		this.receiveAmountMax = receiveAmountMax;
	}
	public double getPayAmountMin() {
		return payAmountMin;
	}
	public void setPayAmountMin(double payAmountMin) {
		this.payAmountMin = payAmountMin;
	}
	public double getPayAmountMax() {
		return payAmountMax;
	}
	public void setPayAmountMax(double payAmountMax) {
		this.payAmountMax = payAmountMax;
	}
	public LevelOfCustomer getLevelMin() {
		return LevelMin;
	}
	public void setLevelMin(LevelOfCustomer levelMin) {
		LevelMin = levelMin;
	}
	public LevelOfCustomer getLevelMax() {
		return LevelMax;
	}
	public void setLevelMax(LevelOfCustomer levelMax) {
		LevelMax = levelMax;
	}

	

	
}
