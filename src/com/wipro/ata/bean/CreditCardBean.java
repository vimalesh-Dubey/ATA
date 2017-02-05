package com.wipro.ata.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ATA_TBL_CREDITCARD")
public class CreditCardBean 
{
	@Id
	private String CreditCardNumber;
	@Column
	private String ValidFrom;
	@Column
	private String ValidTo;
	@Column
	private double CreditBalance;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userID")
	private CredentialsBean credentialsBean;
	
	
	
	
	public CredentialsBean getCredentialsBean() {
		return credentialsBean;
	}
	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public String getValidFrom() {
		return ValidFrom;
	}
	public void setValidFrom(String validFrom) {
		ValidFrom = validFrom;
	}
	public String getValidTo() {
		return ValidTo;
	}
	public void setValidTo(String validTo) {
		ValidTo = validTo;
	}
	public double getCreditBalance() {
		return CreditBalance;
	}
	public void setCreditBalance(double creditBalance) {
		CreditBalance = creditBalance;
	}
	

}
