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

import com.beans.Destination;
import com.beans.Source;
import com.dao.DestinationDao;
import com.dao.DestinationDaoImplem;
import com.dao.SourceDao;
import com.dao.SourceDaoImplem;

/**
 * Servlet implementation class DestinationActionController
 */
@WebServlet("/DestinationAction")
public class DestinationActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DestinationActionController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getAllDestination(request, response);
	}

	private void getAllDestination(HttpServletRequest request, HttpServletResponse response) {

		List<Destination> allDestination = null;
		
		DestinationDao destinationDao = new DestinationDaoImplem();
		
		
		try {
			
			allDestination = destinationDao.listAllDestinatin();
			
			HttpSession httpSession = request.getSession();
			
			httpSession.setAttribute("ALLDESTINATION",allDestination);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("listOfDestination.jsp");
			dispacher.forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
