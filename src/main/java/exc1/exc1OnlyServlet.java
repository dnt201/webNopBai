package exc1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class week4onlyServlet
 */
@WebServlet("/exc1OnlyServlet")
public class exc1OnlyServlet extends HttpServlet {
	
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("<!DOCTYPE html> <html lang=\"en\"> <head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <meta name=\"viewport\" content=\"width=, initial-scale=1.0\"> <link rel=\"stylesheet\" href=\"./assets/css/exc1.css\"> <link rel=\"stylesheet\" href=\"./assets/themify-icons/themify-icons.css\"> <title>Document</title> </head> <body> <div class=\"login\"> <form action=\"exc1Login\" method=\"post\"> <h2>User Login</h2> <input required type=\"text\" placeholder=\"  User name\" name=\"UserName\"required> <br> <input required type=\"password\" placeholder=\"  Password\" name=\"Password\" required> <br> <button class=\"btn\" name=\"action\" value=\"login\">Login</button> <br> </form> <a href=\"\"> Forgot Password?</a> </div> </body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
