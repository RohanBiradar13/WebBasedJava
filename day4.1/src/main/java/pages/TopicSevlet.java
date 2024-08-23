package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopicSevlet
 */
@WebServlet("/topics")
public class TopicSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Login Successful from topic servlet...</h5>");
			// get validated user details from a cookie
			// ASI : Method of HttpServletRequest
			// Cookie[] getCookies() : null => no cookies
			// not null ----- cookioes exist --iterate over the array --- look for the
			// cookie
			// holding the user details
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies)
					if (c.getName().equals("validated_user_details")) {
						pw.print("<h5>User Details Fetched from a cookie " + c.getValue() + "</h5>");
					}
			} else// no cookies
				pw.print("<h5>No Cookies : session tracking failed!!!! </h5>");

		}
	}

}
