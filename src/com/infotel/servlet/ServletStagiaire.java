package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Stagiaire;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ServletStagiaire")
public class ServletStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();

	public ServletStagiaire() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom;
		String prenom;
		int age;

		if (request.getParameter("lastname") != null) {
			nom = request.getParameter("lastname");
			prenom = request.getParameter("firstname");
			age = Integer.parseInt(request.getParameter("age"));

			Stagiaire s = new Stagiaire();
			s.setAge(age);
			s.setNom(nom);
			s.setPrenom(prenom);
			
			service.ajouterStagiaire(s);
		}

		request.setAttribute("stagiaires", service.findAllStagiaire());

		request.getRequestDispatcher("stagiaire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
