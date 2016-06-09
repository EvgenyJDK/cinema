package com.cinema.web;

import com.cinema.dto.MovieDTO;
import com.cinema.service.api.MovieService;
import com.cinema.service.impl.MovieServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AddFilmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			if (true) {
			response.sendRedirect("/addFilm.html");
		} else{
			response.sendRedirect("/films");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		long duration = Long.valueOf(request.getParameter("duration"));

		MovieService movieService = MovieServiceImpl.getInstance();
		System.out.println("AddFilmServlet");

			if (true) {
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setTitle(title);
			movieDTO.setDescription(description);
			movieDTO.setDuration(duration);

				System.out.println("AddFilmServlet before create");

				movieService.createMovie(movieDTO);
			request.setAttribute("title", title);
			request.setAttribute("description", description);
			request.setAttribute("duration", duration);
			getServletContext().getRequestDispatcher("/resources/jsp/filmDescription.jsp").include(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/addFilm.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either title or description already exists.</font>");
			rd.include(request, response);
		}

	}
}
