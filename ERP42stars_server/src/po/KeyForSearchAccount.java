package po;

import java.io.Serializable;

public class KeyForSearchAccount implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 7747755100107266251L;
		private String name;
		private String ID;
		private	int moneyLeftMin=-2147483648,moneyLeftMax=2147483647;

		public String getName() {
			return name;
		}

		public void setName(String name) {
	 
			this.name = name;
		}

		public String getID() {
			return ID;
		}

		public void setID(String id) {
			this.ID = id;
		}

		public int getMoneyLeftMin() {
			return moneyLeftMin;
		}

		public void setMoneyLeftMin(int moneyLeftMin) {
			this.moneyLeftMin = moneyLeftMin;
		}

		public int getMoneyLeftMax() {
			return moneyLeftMax;
		}

		public void setMoneyLeftMax(int moneyLeftMax) {
			this.moneyLeftMax = moneyLeftMax;
		}
		
}
