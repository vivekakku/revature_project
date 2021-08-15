package com.Bank_appModel;

public class Account  {
	private String cust_id;
	private String cust_acc_no;
	
	private String acc_type;
	private String aadhar;
	private double open_bal;
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(String cust_id, String cust_acc_no, String acc_type, String aadhar, double open_bal) {
		super();
		this.cust_id = cust_id;
		this.cust_acc_no = cust_acc_no;
		this.acc_type = acc_type;
		this.aadhar = aadhar;
		this.open_bal = open_bal;
	}
	
	
	public Account(String cust_id, String aadhar, double open_bal) {
		super();
		this.cust_id=cust_id;
		
		//this.accountNumber = aSccountNumber;
		this.cust_acc_no= cust_acc_no;
		this.open_bal = open_bal;
		
	}



	public String getCust_id() {
		return cust_id;
	}



	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}



	public String getCust_acc_no() {
		return cust_acc_no;
	}



	public void setCust_acc_no(String cust_acc_no) {
		this.cust_acc_no = cust_acc_no;
	}



	public String getAcc_type() {
		return acc_type;
	}



	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}



	public String getAadhar() {
		return aadhar;
	}



	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}



	public double getOpen_bal() {
		return open_bal;
	}



	public void setOpen_bal(double open_bal) {
		this.open_bal = open_bal;
	}


	@Override
	public String toString() {
		return "Account [cust_id=" + cust_id + ", cust_acc_no=" + cust_acc_no + ", acc_type=" + acc_type + ", aadhar="
				+ aadhar + ", open_bal=" + open_bal + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadhar == null) ? 0 : aadhar.hashCode());
		result = prime * result + ((acc_type == null) ? 0 : acc_type.hashCode());
		result = prime * result + ((cust_acc_no == null) ? 0 : cust_acc_no.hashCode());
		result = prime * result + ((cust_id == null) ? 0 : cust_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(open_bal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Account other = (Account) obj;
		if (aadhar == null) {
			if (other.aadhar != null)
				return false;
		} else if (!aadhar.equals(other.aadhar))
			return false;
		if (acc_type == null) {
			if (other.acc_type != null)
				return false;
		} else if (!acc_type.equals(other.acc_type))
			return false;
		if (cust_acc_no == null) {
			if (other.cust_acc_no != null)
				return false;
		} else if (!cust_acc_no.equals(other.cust_acc_no))
			return false;
		if (cust_id == null) {
			if (other.cust_id != null)
				return false;
		} else if (!cust_id.equals(other.cust_id))
			return false;
		if (Double.doubleToLongBits(open_bal) != Double.doubleToLongBits(other.open_bal))
			return false;
		return true;
	}
	

	
}
