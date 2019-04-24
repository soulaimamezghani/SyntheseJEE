package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/SupprimerStagiaire")
public class SupprimerStagiaire extends HttpServlet {
	private Iservice service = new ServiceImpl();
	private static final long serialVersionUID = 1L;

    public SupprimerStagiaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idStagiaire = Integer.parseInt(request.getParameter("idStagiaire"));
		service.supprimerStagiaire(idStagiaire);
		
		request.setAttribute("stagiaires", service.findAllStagiaire());

		request.getRequestDispatcher("stagiaire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
