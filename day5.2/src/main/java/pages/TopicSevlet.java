package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import pojo.User;

@WebServlet("/topics")
public class TopicSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			HttpSession hs = request.getSession(); // Get existing session
			User user = (User) hs.getAttribute("user_details");

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

			pw.println("<div class='title'>Topic Page</div>");

			pw.println("<h5>Login Successful from topic servlet...</h5>");

			if (user != null) {
				pw.println("<h5>Validated User Details from Session: " + user + "</h5>");
				// get topic dao instance from the HttpSession
				TopicDaoImpl dao = (TopicDaoImpl) hs.getAttribute("topic_dao");
				// invoke topic dao method to get all topic names;
				List<String> allTopicNames = dao.getAllTopics();
				 //allTopicNames.forEach(topicNames -> pw.print(topicNames+"<br/>"));
			     //dynamic form generation
				pw.print("<form action='tutorials'>");
				pw.print("<h5 align='center'>All Topics</h5>");
				allTopicNames.forEach(topicName -> pw.print("<input type='radio' name='topic' value='" + topicName + "'/>" + topicName + "<br/>"));
				pw.print("<input type='submit' value='Choose Topic'/>");
				pw.print("</form>");

			} else { // no session tracking
				pw.println("<h5>No Cookies: Session tracking failed!!!!</h5>");
				// add a logout link
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
