package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
				// we are redirecting due to redirect the buffer is flushed so there is nothing
				// in it
				// create a cookie : using validated user details
				// javax.servlet.http.Cookie(String cookieName, String cookieValue)
				Cookie c1 = new Cookie("validated_user_details", user.toString());// cookie instance created on the
																					// server side
				// send the cookie to the client
				// Method of HttpServletResponse
				// public void addCookie(Cookie c)
				response.addCookie(c1);
				// pw.print("<h5>Validated User Details: " + user + "</h5>");
				// in case of successful login : redirect the client to the topics page
				// API : HttpServletResponse
				// public void sendRedirect(String location) throws IOException
				response.sendRedirect("topics");
				// WC : sends immediate temp redirect resp to the clnt
				// sts : SC302 | location=topics, content-length=0, set-cookie :
				// validated_user_details : toString of user | body : EMPTY
				// clntb browser : generate a new request
				// URL : http:host:port/day4.1/topics, method=GET
			}
		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName() + " " + e);
		}
	}

}
