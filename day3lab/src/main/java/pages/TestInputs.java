package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInputs
 */
@WebServlet("/test_input")
public class TestInputs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest reque st, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			pw.print("<h5>Hello ,"+request.getParameter("f1")+"</h5>");
			pw.print("<h5>Favorite Colors : "+Arrays.toString(request.getParameterValues("clr"))+"</h5>");
			pw.print("<h5>Chosen Browser : "+request.getParameter("browser")+"</h5>");
			pw.print("<h5>City : "+request.getParameter("myselect")+"</h5>");
			pw.print("<h5>Description : "+request.getParameter("info")+"</h5>");
			
		}
	}

}
