package com.wipro.ata.controller;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ProfileBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.CredentialsDAO;
import com.wipro.ata.dao.ProfileBeanDAO;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.service.Customer;
import com.wipro.ata.util.Authentication;
import com.wipro.ata.util.User;


@Controller
public class ATAController 
{
	@Autowired
	private Administrator admin;
	@Autowired
	private Customer customer;
	@Autowired
	private Authentication auth;
	@Autowired
	private User user;
	@Autowired
	private ProfileBeanDAO profile_bean;
	@Autowired
	private CredentialsDAO c_dao;
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	@RequestMapping("/login")
	public ModelAndView goToLoginPage(@ModelAttribute("LoginData") CredentialsBean credentialsBean)
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping("/usrlogn")
	public ModelAndView Login(@ModelAttribute("LoginData") CredentialsBean credentialsBean,HttpSession session)
	{
		//return new ModelAndView("Home_Page_admin");
		String result = user.login(credentialsBean);
		if(result.equalsIgnoreCase("A"))
		{
			session.setAttribute("Uid",credentialsBean.getUserID());   //set the session attribute which will be used for session
																	// maintainance in each page
			
			session.setMaxInactiveInterval(10000);				//  set the expiry time for session
			return new ModelAndView("Home_Page_admin","usrname",credentialsBean.getUserID());
		}
		else if(result.equals("C"))
		{
			session.setAttribute("Uid",credentialsBean.getUserID());
			return new ModelAndView("Home_page_user","usrname",credentialsBean.getUserID());
		}

		else if(result.equals("FAIL"))
		{
			return new ModelAndView("failure");

		}
		else 
		{
			return new ModelAndView("invalid");
		}
	}
	// ==================reset Password===============================
     @RequestMapping("/reset_pwd")
     public ModelAndView goToresetPwd(@ModelAttribute("respwd") ProfileBean profileBean)
     {
    	 return new ModelAndView("reset_pwd");
    	 
     }
     
     @RequestMapping("/Reset_pass")
     public ModelAndView ResetPwd(@ModelAttribute("respwd") ProfileBean profileBean,HttpSession session)
     {
    	 //String result=user.register(profileBean);
    	 profileBean.setUserId((String)session.getAttribute("Uid"));
    	 if(profile_bean.updateProfileBean(profileBean))
    	 {
    		 CredentialsBean cb=new CredentialsBean();
    		 cb.setUserID(profileBean.getUserId());
    		 cb.setPassword(profileBean.getPassword());
    		 c_dao.updateCredentials(cb);
    		 return new ModelAndView("success");
    	 }
    	 else{
    		 return new ModelAndView("failure");
     }}
    //=====================New User=================================
     
     @RequestMapping("/register")
     public ModelAndView goToNewUserPage(@ModelAttribute("usrprofile") ProfileBean profileBean)
     {
    	 return new ModelAndView("New_User");
     }
     
     @RequestMapping("/RegisterUser")
     public ModelAndView RegisterNewUser(@ModelAttribute("usrprofile") ProfileBean profileBean)
     {
    	 String result=user.register(profileBean);
    	 String uid = profileBean.getUserId();
    	 System.out.println("UserID: "+uid);
    	 if(result.equals("SUCCESS"))
    		 return new ModelAndView("Users_ID","uid",uid);
    	 else
    		 return new ModelAndView("failure");
     }
     
     //====================Add Vehicle========================================  
     
	@RequestMapping("/add_vehicle")
	public ModelAndView goTOAddVehicle(@ModelAttribute("vehicledata") VehicleBean VehicleBean,HttpSession session)
	{
		//System.out.println(session.getAttribute("Uid"));
		if(session.getAttribute("Uid")==null)
			return new ModelAndView("logout");
			else
				return new ModelAndView("add_vehicle");
	}


      @RequestMapping("/addVehicle")
	public ModelAndView AddVehicle(@ModelAttribute("vehicledata") VehicleBean VehicleBean, VehicleBean vehicleBean)
	{
    	  if(admin.addVehicle(vehicleBean).contains("SUCCESS"))
    	  {
    		  return new ModelAndView("success");
    	  }
           
    	  	return new ModelAndView("failure");
		
    }
      
      
      //====================Update Vehicle========================================  
      
  	@RequestMapping("/update_vehicle")
  	public ModelAndView update_vehicle(@ModelAttribute("upvehicle") VehicleBean VehicleBean,HttpSession session)
  	{
  		
  		boolean result = admin.modifyVehicle(VehicleBean);
  		/*if(admin.addVehicle(VehicleBean).contains("SUCCESS"))
  	  {
  		  return new ModelAndView("success");
  	  }*/
         if(result==false)
  	  	  return new ModelAndView("failure");
         else
        	 return new ModelAndView("success");
  	}
      
      //===================================view vehicle By Admin================================
      @RequestMapping("/view_vehicle")
  	public ModelAndView goTOViewVehicle(@ModelAttribute("upvehicle") VehicleBean VehicleBean,HttpSession session)
  	{
    	  if(session.getAttribute("Uid")==null)
  			return new ModelAndView("logout");
    	 
    	  ArrayList<VehicleBean> arr=admin.viewVehicle();
    	  return new ModelAndView("view_vehicle","arr",arr);
  	}
      
      //====================view vehicle by User=============================================
      
      @RequestMapping("/viewusr_vehicle")
    	public ModelAndView goTOViewUsrVehicle(HttpSession session)
    	{
    	  if(session.getAttribute("Uid")==null)
    			return new ModelAndView("logout");
      	  ArrayList<VehicleBean> arr=admin.viewVehicle();
      	
    		return new ModelAndView("viewusr_vehicle","arr",arr);
    	}
      
      //====================================delete vehicle=============================
      @RequestMapping("/delete_vehicle")
    	public ModelAndView goTODeleteVehicle(@ModelAttribute("upvehicle") VehicleBean VehicleBean,HttpServletRequest request,HttpServletResponse response)
    	{
    	  String s[]=request.getParameterValues("c1");
    	  ArrayList<String> arr=new ArrayList<String>();
    	  for(int counter=0;counter<s.length;counter++)
    	  {
    		  arr.add(s[counter]);
    	  }
    	  //deleting 
    	  admin.deleteVehicle(arr);
    	  ArrayList<VehicleBean> arr2=admin.viewVehicle();
    	  
      	  //view again
    		return new ModelAndView("view_vehicle","arr",arr2);
    	} 
      //================view route by Admin=======================================================
      @RequestMapping("/view_route")
    	public ModelAndView goTOViewRoute(@ModelAttribute("uproute") RouteBean routeBean,HttpSession session)
    	{
    	  if(session.getAttribute("Uid")==null)
  			return new ModelAndView("logout");
      	  ArrayList<RouteBean> arr=admin.viewRoute();
      	 /* for(VehicleBean v: arr)
      	  {
      		  System.out.println(v.getName());
      	  }*/
      	//  System.out.println(arr);
    		return new ModelAndView("view_route","arr",arr);
    	} 
      
      //====================view route by user===================================================
      @RequestMapping("/viewusr_route")
  	public ModelAndView goTOViewUsrRoute(HttpSession session)
  	{
    	  if(session.getAttribute("Uid")==null)
  			return new ModelAndView("logout");
    	  ArrayList<RouteBean> arr=admin.viewRoute();
    	 /* for(VehicleBean v: arr)
    	  {
    		  System.out.println(v.getName());
    	  }*/
    	//  System.out.println(arr);
  		return new ModelAndView("viewusr_route","arr",arr);
  	} 
      
      //====================delete route=============================================
      @RequestMapping("/delete_route")
  	public ModelAndView goTODeleteRoute(@ModelAttribute("uproute") RouteBean routeBean,HttpServletRequest request,HttpServletResponse response)
  	{
    	  String s[]=request.getParameterValues("c1");
    	 ArrayList<String> arr=new ArrayList<String>();
    	  for(int counter=0;counter<s.length;counter++)
    	 {
    		 arr.add(s[counter]);
    	 }
    	  admin.deleteRoute(arr);
    	  ArrayList<RouteBean> arr2=admin.viewRoute();
    	  
    	 	return new ModelAndView("view_route","arr",arr2);
  	}
      
      
     //====================Add route=====================================================
      
      @RequestMapping("/add_route")
  	public ModelAndView goToAddRoute(@ModelAttribute("Routedata") RouteBean routeBean,HttpSession session)
  	{
    	  System.out.println(session.getAttribute("Uid"));
    	  if(session.getAttribute("Uid")==null)
  			return new ModelAndView("logout");
  			else
  				return new ModelAndView("add_route");
  	}


        @RequestMapping("/addRoute")
  	public ModelAndView AddRoute(@ModelAttribute("Routedata") RouteBean routeBean)
  	{
          if(admin.addRoute(routeBean).equals("SUCCESS"))
          {
        	  return new ModelAndView("success");
          }
      	  	return new ModelAndView("failure");
  		
      }
        
        //====================Update route=====================================================
        
        @RequestMapping("/up_route")
    	public ModelAndView Update_route(@ModelAttribute("uproute") RouteBean routeBean,HttpSession session)
    	{
        	 if(admin.addRoute(routeBean).equals("SUCCESS"))
             {
           	  return new ModelAndView("success");
             }
         	  	return new ModelAndView("failure");
    	}  
      
      //===================Add Driver=====================================================
        
        @RequestMapping("/add_driver")
    	public ModelAndView goToAddDriver(@ModelAttribute("driverdata") DriverBean driverBean,HttpSession session)
    	{
        	if(session.getAttribute("Uid")==null)
    			return new ModelAndView("logout");
    			else
    		return new ModelAndView("add_driver");
    	}


          @RequestMapping("/adddriver")
    	public ModelAndView AddDriver(@ModelAttribute("driverdata") DriverBean driverBean)
    	{
               if(admin.addDriver(driverBean).equals("SUCCESS"))
               {
            	   return new ModelAndView("success");
               }
        	  	return new ModelAndView("failure");
    		
        }
          //===================view driver================================================
          @RequestMapping("/view_driver")
      	public ModelAndView goToViewDriver(@ModelAttribute("driverdata") DriverBean driverBean,HttpSession session)
      	{
        	  if(session.getAttribute("Uid")==null)
        			return new ModelAndView("logout");
          	 
          	  ArrayList<DriverBean> arr=admin.viewDriver();
          	  return new ModelAndView("view_drivers","arr",arr);
        	  
      	} 
          
          
          //=================================log out===========================
           @RequestMapping("/logout")
      	public ModelAndView logout(HttpSession session)
      	{
        	  String uid=(String) session.getAttribute("Uid");
        	  
        	
        	  user.logout(uid);
        	  session.invalidate();
              return new ModelAndView("logout");
        }
          
          //======================================booking page===========================
          @RequestMapping("/book_vehicle")
        	public ModelAndView goToBookVehicle(@ModelAttribute("BookingData") ReservationBean ReservationBean,HttpSession session)
        	{
        	  if(session.getAttribute("Uid")==null)
      			return new ModelAndView("logout");
      			else
      				
      				return new ModelAndView("book_vehicle");
            }
          
          
          @RequestMapping("/BookVehicle")
      	public ModelAndView BookVehicle(@ModelAttribute("BookingData") ReservationBean reservationBean,HttpSession session)
      	{
        	 session.setAttribute("rBean", reservationBean);
        	  return new ModelAndView("payment");
        	  
        	  
        	  /*String str= customer.bookVehicle(reservationBean);
            	 if(str.equals("SUCCESS"))
            	 {
        		return new ModelAndView("proceed_pay");
            	 }
            	 else
            	 {
            		 return new ModelAndView("failure");
            	 }*/
         }
        //============================payment ==============================================
          @RequestMapping("/proceed_pay")
        	public ModelAndView goToPayment(@ModelAttribute("paymentdata") CreditCardBean creditCardBean,HttpSession session)
        	{
        	
        	  if(session.getAttribute("Uid")==null)
      			return new ModelAndView("logout");
      			else
      				
      				
      				return new ModelAndView("proceed_pay");
          }
          
          
          @RequestMapping("/payment")
      	public ModelAndView goToProceedPayment(@ModelAttribute("paymentdata") CreditCardBean creditCardBean,HttpSession session)
      	{
      	  if(session.getAttribute("Uid")==null)
    			return new ModelAndView("logout");
    			else
    			{
    				ReservationBean reservationBean = (ReservationBean) session.getAttribute("rBean");
    				// yet to be implemented
    				CreditCardBean creditcard = customer.validateCard(creditCardBean.getCreditCardNumber());
    				System.out.println(creditcard);
    				System.out.println(reservationBean.getTotalFare());
    				if(creditcard!=null)
    				{
    					customer.bookVehicle(reservationBean);
    					//System.out.println("fare="+reservationBean.getTotalFare());
    					if(creditcard.getCreditBalance()>reservationBean.getTotalFare())
    					{
    						customer.payMoney(creditcard.getCreditCardNumber(),reservationBean.getTotalFare());
    						
    					
    					}
    				}	
    				
    				return new ModelAndView("view_booking","ResBean",reservationBean);
    			}
        }
          
          
          

}
