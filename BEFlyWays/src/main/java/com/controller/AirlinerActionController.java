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

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.beans.Airliner;
import com.beans.Flight;
import com.dao.AirlinerDao;
import com.dao.AirlinerDaoImplem;


@WebServlet("/AirlinerAction")
public class AirlinerActionController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}


	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getListOfAirliner(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	private void getListOfAirliner(HttpServletRequest request, HttpServletResponse response) {
		
		List<Airliner> allAirliner = null;
		
		try {
			
			AirlinerDao airlinerDao = new AirlinerDaoImplem();
			
			
			HttpSession httpSession = request.getSession();
			
			allAirliner = airlinerDao.listAllAirliners();
			
			httpSession.setAttribute("ALLAIRLINER", allAirliner);

					
			RequestDispatcher dispacher = request.getRequestDispatcher("/listOfAllAirliner.jsp");
			dispacher.forward(request, response);
			
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
