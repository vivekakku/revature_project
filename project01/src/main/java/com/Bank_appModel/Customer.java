package com.Bank_appModel;

public class Customer {

	private String cust_id;
	private String cust_name;
	private String cust_phno;
	private String cust_gender;
	private String cust_emailId;
	private String cust_pwd;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String cust_id, String cust_name, String cust_phno, String cust_gender, String cust_emailId,
			String cust_pwd) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_phno = cust_phno;
		this.cust_gender = cust_gender;
		this.cust_emailId = cust_emailId;
		this.cust_pwd = cust_pwd;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phno() {
		return cust_phno;
	}

	public void setCust_phno(String cust_phno) {
		this.cust_phno = cust_phno;
	}

	public String getCust_gender() {
		return cust_gender;
	}

	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	public String getCust_emailId() {
		return cust_emailId;
	}

	public void setCust_emailId(String cust_emailId) {
		this.cust_emailId = cust_emailId;
	}

	public String getCust_pwd() {
		return cust_pwd;
	}

	public void setCust_pwd(String cust_pwd) {
		this.cust_pwd = cust_pwd;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_phno=" + cust_phno
				+ ", cust_gender=" + cust_gender + ", cust_emailId=" + cust_emailId + ", cust_pwd=" + cust_pwd + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cust_emailId == null) ? 0 : cust_emailId.hashCode());
		result = prime * result + ((cust_gender == null) ? 0 : cust_gender.hashCode());
		result = prime * result + ((cust_id == null) ? 0 : cust_id.hashCode());
		result = prime * result + ((cust_name == null) ? 0 : cust_name.hashCode());
		result = prime * result + ((cust_phno == null) ? 0 : cust_phno.hashCode());
		result = prime * result + ((cust_pwd == null) ? 0 : cust_pwd.hashCode());
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
		Customer other = (Customer) obj;
		if (cust_emailId == null) {
			if (other.cust_emailId != null)
				return false;
		} else if (!cust_emailId.equals(other.cust_emailId))
			return false;
		if (cust_gender == null) {
			if (other.cust_gender != null)
				return false;
		} else if (!cust_gender.equals(other.cust_gender))
			return false;
		if (cust_id == null) {
			if (other.cust_id != null)
				return false;
		} else if (!cust_id.equals(other.cust_id))
			return false;
		if (cust_name == null) {
			if (other.cust_name != null)
				return false;
		} else if (!cust_name.equals(other.cust_name))
			return false;
		if (cust_phno == null) {
			if (other.cust_phno != null)
				return false;
		} else if (!cust_phno.equals(other.cust_phno))
			return false;
		if (cust_pwd == null) {
			if (other.cust_pwd != null)
				return false;
		} else if (!cust_pwd.equals(other.cust_pwd))
			return false;
		return true;
	}
	
	
}
