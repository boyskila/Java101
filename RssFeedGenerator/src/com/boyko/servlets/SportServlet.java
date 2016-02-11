package com.boyko.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boyko.service.RssService;

@WebServlet("/sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RssService service = new RssService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setAttribute("sport", service.getRss(response, "http://www.dnevnik.bg/rssc/?rubrid=2368"));
		request.getRequestDispatcher("/jsp/sport.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
