package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ServletFormation")
public class ServletFormation extends HttpServlet {
	private Iservice service = new ServiceImpl();
	private static final long serialVersionUID = 1L;

    public ServletFormation() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		
		String nomformation = request.getParameter("nomformation");
		
		Formation f = new Formation();
		f.setNomformation(nomformation);
		
		service.ajouterFormation(f);
		
		request.setAttribute("formations", service.findALLFormation());
		
		request.getRequestDispatcher("Formation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
