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

import com.beans.Airliner;
import com.beans.Flight;
import com.dao.FlightDao;
import com.dao.FlightDaoImplem;
import com.general.DateParser;

import java.sql.Timestamp;


@WebServlet("/SearchFlight")
public class SearchFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		searchForFlight(request, response);
	}


	private void searchForFlight(HttpServletRequest request, HttpServletResponse response) {
		
		List<Flight> allFlightPerDate = null;
		
		FlightDao flightDao = new FlightDaoImplem();
		DateParser dateParser = new DateParser();
		
		try {
			
			String theDateSearch = request.getParameter("searchFlightDate");
			
			Timestamp dateTimeSearch = dateParser.getRealDateTime(theDateSearch);
			
			//allFlightPerDate = flightDao.listOfAllFlightPerDate(dateTimeSearch);
			
			HttpSession httpSession = request.getSession();
			
			allFlightPerDate = flightDao.listOfAllFligth();
			
			/*
			for(Flight fli : allFlightPerDate)
			{
				System.out.print(fli.getDestination()+" "+fli.getNumFlight()+" "+fli.getDateFligth());
			}
			*/
			
			httpSession.setAttribute("ALLFLIGHTSPERDAY", allFlightPerDate);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("/listOfFlight.jsp");
			dispacher.forward(request, response);
			
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
