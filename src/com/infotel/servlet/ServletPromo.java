package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Promo;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ServletPromo")
public class ServletPromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();

	public ServletPromo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomsession;
		int effectif;

		if (request.getParameter("nomsession") != null) {
			nomsession = request.getParameter("nomsession");
			effectif = Integer.parseInt(request.getParameter("effectif"));
			
			Promo p = new Promo();
			p.setNomsession(nomsession);
			p.setEffectif(effectif);
			
			service.ajouterPromo(p);
		}

		request.setAttribute("promotions", service.findALLPromo());

		request.getRequestDispatcher("Promo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
