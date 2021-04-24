package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Source;
import com.dao.SourceDao;
import com.dao.SourceDaoImplem;

/**
 * Servlet implementation class SourceActionController
 */
@WebServlet("/SourceAction")
public class SourceActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SourceActionController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getAllSource(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	private void getAllSource(HttpServletRequest request, HttpServletResponse response) {
		
		List<Source> allSources = null;
		
		SourceDao sourceDao = new SourceDaoImplem();
		
		
		try {
			
			allSources = sourceDao.listOfAllSource();
			
			HttpSession httpSession = request.getSession();
			
			httpSession.setAttribute("ALLSOURCE",allSources);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("listOfSource.jsp");
			dispacher.forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
