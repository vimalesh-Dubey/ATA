package com.wipro.ata.dao;

import java.util.ArrayList;

import com.wipro.ata.bean.CreditCardBean;


public interface CreditCardDAO 
{
	String createCreditCard(CreditCardBean creditCardBean);
	int deleteCreditCard(ArrayList<String> creditCardList) ;
	boolean updateCreditCard(CreditCardBean creditCardBean) ;
	CreditCardBean findByID(String id) ;
	ArrayList<CreditCardBean> findAll();
	boolean ckeckbalance(float payment);
	void updateCreditCardBalance(String creditCardNumber, Double totalFare);


}
