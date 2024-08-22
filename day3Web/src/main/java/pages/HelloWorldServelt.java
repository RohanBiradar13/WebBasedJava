package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//trace the life cycle of the servlet managed by the web container
@WebServlet(urlPatterns = "/hello")
//WC : map
//Key : /hello
//value : F.Q servelt class name (pages.HelloWorldServlet)
public class HelloWorldServelt extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// override init method

	@Override
	public void init() throws ServletException {
		System.out.println("in init : invoked by " + Thread.currentThread());
	}

	@Override 
	public void destroy() {
		System.out.println("in init : invoked by " + Thread.currentThread());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do get : invoked by "+Thread.currentThread());
	    //Objective : send dyn resp to the clnt
		//1. set resp content type (resp header) : text/html
		resp.setContentType("text/html");
		//2. attach buffered, char o/p stream to send resp from Servlet ---> Web clnt
		try(PrintWriter pw = resp.getWriter()){
			pw.print("<h5> Welcome to Servlets..."+LocalDateTime.now()+ "</h5>");    
		}
	}

}
