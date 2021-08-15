package com.Bank_appModel;


public class Transaction
{
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	private String cust_acc_no;
	private double amount;
	private double open_bal1;
	private double closingBalance;
	private String UserId2;
	private int transId;
	private String transType;
	private String date;
	private double tamount;
	
	
	public String getCust_acc_no() {
		return cust_acc_no;
	}
	public void setCust_acc_no(String cust_acc_no) {
		this.cust_acc_no = cust_acc_no;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getOpen_bal1() {
		return open_bal1;
	}
	public void setOpen_bal1(double open_bal1) {
		this.open_bal1 = open_bal1;
	}
	public double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getUserId2() {
		return UserId2;
	}
	public void setUserId2(String userId2) {
		UserId2 = userId2;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTamount() {
		return tamount;
	}
	public void setTamount(double tamount) {
		this.tamount = tamount;
	}
	
	
	public Transaction(String cust_acc_no, double amount, double open_bal1, double closingBalance, 
			String transType) {
		super();
		this.cust_acc_no = cust_acc_no;
		this.amount = amount;
		this.open_bal1=open_bal1;
		this.closingBalance = closingBalance;
		//this.transId = transId;
		this.transType = transType;
	}
	@Override
	public String toString() {
		return "Transaction [cust_acc_no=" + cust_acc_no + ", amount=" + amount + ", open_bal1=" + open_bal1
				+ ", closingBalance=" + closingBalance + ", UserId2=" + UserId2 + ", transId=" + transId
				+ ", transType=" + transType + ", date=" + date + ", tamount=" + tamount + "]";
	}
	public Transaction(String cust_acc_no, double amount, double open_bal1, double closingBalance, String userId2,
			int transId, String transType, String date, double tamount) {
		super();
		this.cust_acc_no = cust_acc_no;
		this.amount = amount;
		this.open_bal1 = open_bal1;
		this.closingBalance = closingBalance;
		UserId2 = userId2;
		this.transId = transId;
		this.transType = transType;
		this.date = date;
		this.tamount = tamount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UserId2 == null) ? 0 : UserId2.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(closingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cust_acc_no == null) ? 0 : cust_acc_no.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		temp = Double.doubleToLongBits(open_bal1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tamount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + transId;
		result = prime * result + ((transType == null) ? 0 : transType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (UserId2 == null) {
			if (other.UserId2 != null)
				return false;
		} else if (!UserId2.equals(other.UserId2))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (Double.doubleToLongBits(closingBalance) != Double.doubleToLongBits(other.closingBalance))
			return false;
		if (cust_acc_no == null) {
			if (other.cust_acc_no != null)
				return false;
		} else if (!cust_acc_no.equals(other.cust_acc_no))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(open_bal1) != Double.doubleToLongBits(other.open_bal1))
			return false;
		if (Double.doubleToLongBits(tamount) != Double.doubleToLongBits(other.tamount))
			return false;
		if (transId != other.transId)
			return false;
		if (transType == null) {
			if (other.transType != null)
				return false;
		} else if (!transType.equals(other.transType))
			return false;
		return true;
	}
	
	
	
}

