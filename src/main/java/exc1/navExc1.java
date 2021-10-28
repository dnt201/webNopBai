package exc1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class week4Servlet
 */
@WebServlet("/navExc1")
public class navExc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public navExc1() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String url = "/index.html";
		String action = request.getParameter("action");
		if(action==null){
			action="homepage";  //default action
		}

		//perform action and set URL to appropriate page
		if(action.equals("homepage")){
			url="/index.html";  
			RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else if(action.equals("combine")) {
			url="/exercise1/exc1Login.jsp"; 
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}

		else if(action.equals("onlyJSP")) {
			url="/exercise1/onlyJSP/loginOnlyJSP.jsp"; 
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}
