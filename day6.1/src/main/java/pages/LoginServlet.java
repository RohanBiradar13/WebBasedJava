package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojo.User;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/validate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void init() throws ServletException {
		// dao inst
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// to inform the WC that init() has failed ---so don't continue with the
			// servicing : throw
			// ServletException
			throw new ServletException("err in init of " + getClass().getName() + " " + e);
		}

	}

	@Override
	public void destroy() {
		try {
			userDao.cleanUp();
			DBUtils.closeConnection();
		} catch (SQLException e) {
			System.out.println("err in destroy of " + getClass().getName() + " " + e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post of "+getClass().getName());
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// Read request params sent by the client
			String email = request.getParameter("em");
			String password = request.getParameter("pass");

			// Debug statements
			System.out.println("Email: " + email);
			System.out.println("Password: " + password);

			// Invoke dao's method for user validation
			User user = userDao.validateUser(email, password);

			// Debug statement
			System.out.println("User: " + user);

			// Check valid or invalid
			if (user == null) {
				// Invalid user---retry link--->login form
				pw.print("<h5>Invalid Login, Please <a href='login.html'>Retry</a> </h5>");
			} else {
				// Send in the response: validated user details
				pw.print("<h5>Login Successful!!!</h5>");// Deos not appear on the clnt browser bcoz of
				//save validated user details under minimum suitable scope(request) : used in server pull
				 request.setAttribute("user_details", user);
				 //Request Dispatching steps
				 //1. get RD object from WC
				 RequestDispatcher rd = request.getRequestDispatcher("topics");
			     //Forward the clnt to the next page in the SAME request
				 rd.forward(request, response);
				 //WC : suspends execution of this(post) method. Clears the response buffer. Invokes Topics servlet doPost method
				 //control comes back to login servlet n continues...
				 System.out.println("Control back in Login Servlet...");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName() + " " + e);
		}
	}

}
