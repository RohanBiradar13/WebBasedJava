package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post of " + getClass().getName());
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			// how to retrieve the user details ? : from the request scope
			User user = (User) request.getAttribute("user_details");
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='en' dir='ltr'>");
			pw.println("<head>");
			pw.println("<meta charset='UTF-8'>");
			pw.println("<title>Logout Page</title>");
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

			pw.println("</style>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");
			pw.print("<h5>Login Successful from topic servlet...</h5>");
			if (user != null)
				pw.print("<h5> User details fetched from the current request scope " + user + "</h5>");
			else
				pw.print("<h5>Request dispatching failed!!!</h5>");

		}

	}
}
