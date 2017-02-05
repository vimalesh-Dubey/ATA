package com.wipro.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.dao.CreditCardDAO;

@Service
@Transactional
public class PaymentImpl implements Payment 
{
	@Autowired
	public CreditCardDAO card_dao;
	

	@Override
	public boolean findByCardNumber(String userID, String cardNumber) 
	{
		if(userID!=null||cardNumber!=null)
		{
			CreditCardBean card_bean=card_dao.findByID(userID);
			if(card_bean.getCreditCardNumber()==cardNumber)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return false;
	}

	@Override
	public String process(Payment payment) 
	{	
		//payment.findByCardNumber(userID, cardNumber)
		return null;
		
	}

}
