package com.boyko.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boyko.service.RssService;

@WebServlet(name = "/news", urlPatterns = { "/news" })
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RssService service = new RssService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		request.setAttribute("news", service.getRss(response, "http://www.dnevnik.bg/rssc/?rubrid=1657"));

		request.getRequestDispatcher("/jsp/news.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
