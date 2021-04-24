package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.dao.UserDao;
import com.dao.UserDaoImplem;


@WebServlet("/ChangePassword")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangePasswordController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		changePassword(request, response);
	}


	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		
		Integer userIdtoUse = null;
		String thePassword = request.getParameter("aPassword");
		String theConfPassword = request.getParameter("confPassword");
		
		Cookie cookies[] = request.getCookies(); //getCookies returns an array of cookies

		userIdtoUse = getUserIdFromCookies(cookies);
		
		
		try {
			if(thePassword != null && theConfPassword != null)
			{
				if(thePassword.equals(theConfPassword))
				{
					UserDao userDao = new UserDaoImplem();
					userDao.updateUserPassword(userIdtoUse, thePassword);
				}
				else
				{
					//Password not conform
				}
					
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		
	}

	

	private Integer getUserIdFromCookies(Cookie cookies[]) {
		
		String userNameFromCookie = null;
		Integer userId = null;
		
		for(Cookie cookie : cookies)
		{
			if(cookie.getName().equals("userName"))
			{
				userNameFromCookie = cookie.getValue(); //IN NORMAL TIME, CHECK IF THAT USERNAME EXIST IN THE DATABASE
				
				UserDao userDao = new UserDaoImplem();
			
				userId = userDao.getIdUser(userNameFromCookie);
			}
		}
		
		return userId;
	}

}
