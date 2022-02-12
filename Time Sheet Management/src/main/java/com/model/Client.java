package com.model;




import javax.persistence.Embeddable;



@Embeddable
public class Client {


	
	private String clientName;
	private String clientPlace;
	public Client(String clientName, String clientPlace) {
		super();
		this.clientName = clientName;
		this.clientPlace = clientPlace;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPlace() {
		return clientPlace;
	}
	public void setClientPlace(String clientPlace) {
		this.clientPlace = clientPlace;
	}







}

