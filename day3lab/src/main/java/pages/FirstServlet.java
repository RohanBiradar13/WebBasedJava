package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(urlPatterns ={"/first","/abc","/xyz"},loadOnStartup = 1)
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("in init of "+getClass().getName()); 
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do get");
		// set content type of resp. (meant for clnt browser)
		response.setContentType("text/html");
		// 2. Attach/open PW to send buffered, char data from servlet--->clnt
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4> Welcome1 ! " + LocalDateTime.now() + " </h4>");
		} // commiting of the resp

	}

}
