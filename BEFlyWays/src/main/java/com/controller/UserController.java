package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.dao.UserDao;
import com.dao.UserDaoImplem;


@WebServlet("/UserLogin")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//private UserDao userDao = new UserDaoImplem();
	
	

    public UserController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			 authenticateLogin(request, response);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}


	private void authenticateLogin(HttpServletRequest request, HttpServletResponse response) {
		
		Integer theIdUserforCookie = null;
		
		String theUsername = request.getParameter("aUsername");
		String thePassword = request.getParameter("aPassword");
		
		
		UserDao userDao = new UserDaoImplem();
		
		boolean result = userDao.validateAuthentication(theUsername,thePassword);
		
		if(result)
		{
			theIdUserforCookie = userDao.getIdUser(theUsername);
			
			Cookie userIdCookie = new Cookie("idUser",theIdUserforCookie.toString()); 
			Cookie userNameCookie = new Cookie("userName",theUsername); 
			
			response.addCookie(userIdCookie);
			response.addCookie(userNameCookie);
			
			//System.out.print("IdCooki = "+userIdCookie+" - Username = "+userNameCookie);
			
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("generalMenu.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
