package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDaoImpl;
import pojo.Tutorial;

/**
 * Servlet implementation class TutorialDetailsServlet
 */
@WebServlet("/tutorial_details")
public class TutorialDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set IN params
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			TutorialDaoImpl tutorialDao = (TutorialDaoImpl) session.getAttribute("tutorial_dao");
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='en' dir='ltr'>");
			pw.println("<head>");
			pw.println("<meta charset='UTF-8'>");
			pw.println("<title>Topic Page</title>");
			pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
			pw.println("<style>");
			pw.println("/* Embedded CSS */");
			pw.println(
					"@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');");

			pw.println("* {");
			pw.println("    margin: 0;");
			pw.println("    padding: 0;");
			pw.println("    box-sizing: border-box;");
			pw.println("    font-family: 'Poppins', sans-serif;");
			pw.println("}");

			pw.println("html, body {");
			pw.println("    display: grid;");
			pw.println("    height: 100vh;");
			pw.println("    width: 100%;");
			pw.println("    place-items: center;");
			pw.println("    background: linear-gradient(to right, #99004d 0%, #ff0080 100%);");
			pw.println("}");

			pw.println("::selection {");
			pw.println("    background: #ff80bf;");
			pw.println("}");

			pw.println(".container {");
			pw.println("    background: #fff;");
			pw.println("    max-width: 350px;");
			pw.println("    width: 100%;");
			pw.println("    padding: 25px 30px;");
			pw.println("    border-radius: 5px;");
			pw.println("    box-shadow: 0 10px 10px rgba(0, 0, 0, 0.15);");
			pw.println("}");

			pw.println(".container .title {");
			pw.println("    font-size: 30px;");
			pw.println("    font-weight: 600;");
			pw.println("    margin: 20px 0 10px 0;");
			pw.println("    position: relative;");
			pw.println("}");

			pw.println(".container .title:before {");
			pw.println("    content: '';");
			pw.println("    position: absolute;");
			pw.println("    height: 4px;");
			pw.println("    width: 33px;");
			pw.println("    left: 0px;");
			pw.println("    bottom: 3px;");
			pw.println("    border-radius: 5px;");
			pw.println("    background: linear-gradient(to right, #99004d 0%, #ff0080 100%);");
			pw.println("}");

			pw.println("h5 {");
			pw.println("    font-size: 18px;");
			pw.println("    color: #333;");
			pw.println("    margin: 20px 0;");
			pw.println("}");

			pw.println("a {");
			pw.println("    color: #007BFF;");
			pw.println("    text-decoration: none;");
			pw.println("    font-weight: bold;");
			pw.println("}");

			pw.println("a:hover {");
			pw.println("    color: #0056b3;");
			pw.println("}");
			pw.println("</style>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");

			pw.println("<div class='title'>Tutorial Page</div>");

			pw.println("<h5>Login Successful from tutorial details servlet...</h5>");
			String tutorialName = request.getParameter("name");
			tutorialDao.updateVisitCount(tutorialName);
			Tutorial tutorialDetails = tutorialDao.getTutorialDetails(tutorialName);
			if (tutorialDao != null) {
				pw.println("<div class='title'>Tutorial Details by tutorial name</div>");
				pw.println("<h5>Tutorial Details, " + tutorialDetails.getContents() + "</h5>");
			} else {
				pw.print("<h5>No Cookies : session tracking failed!!!</h5>");
				pw.print("<h5><a href='logout'>Log Out</a></h5>");

			}
			pw.println("<h5><a href='logout'>Log Out</a></h5>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (Exception e) {
			throw new ServletException("err in do get of " + getClass().getName() + " " + e);
		}
	}

}
