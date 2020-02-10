package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidate;
import model.Caucus;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/GetCalculator")
public class GetCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCalculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Should get numCandidates from request
		if (request.getParameter("count") != null) {
			int numDelegates = Integer.parseInt(request.getParameter("numDelegates"));
			int numParticipants = Integer.parseInt(request.getParameter("numParticipants"));
			int count = Integer.parseInt(request.getParameter("count"));
			String precinctName = request.getParameter("precinctName");
			
			Caucus caucus = new Caucus();
			caucus.setName(precinctName);
			caucus.setNumDelegates(numDelegates);
			caucus.setNumParticipants(numParticipants);

			for (int i = 1; i <= count; i++) {
				String name = request.getParameter("candidate_" + Integer.toString(i));
				int votes = Integer.parseInt(request.getParameter("votes_" + Integer.toString(i)));
				Candidate c = new Candidate(name, votes);
				caucus.addCandidate(c);
			}
			caucus.validate();
			caucus.calculateDelegates();
			request.setAttribute("caucus", caucus);
			getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);

		} else {
			String numCandidates = request.getParameter("numCandidates");
			request.setAttribute("numCandidates", numCandidates);
			getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
		}
	}
}
