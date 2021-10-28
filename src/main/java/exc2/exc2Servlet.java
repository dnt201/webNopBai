package exc2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/exc2Servlet")
public class exc2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public exc2Servlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = getServletContext().getRealPath("/WEB-INF/EmailList.txt");
		
		String url = "/index.html";
		
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");

		if(action.equals(null) || action.equals("homepage") ){
			url = "/index.html";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}

		else if (action.equals("add")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			
			User user = new User(firstName, lastName, email);
			//Validate
			String message = null;
			
			if (firstName == "" && lastName == "" && email == "") { 
				message = "Vui lòng nhập đầy đủ thông tin!!!";
				url ="/exercise2_email/exc2.jsp";
			}
			else if(firstName == "" || lastName == "") {
				message = "Vui lòng nhập đầy đủ HỌ và TÊN";
				url ="/exercise2_email/exc2.jsp";
			}
			else if (email == "") {
				message = "Vui lòng nhập email của bạn";
				url ="/exercise2_email/exc2.jsp";
			}
			else { //tất cả đều ổn
 				message ="";
 				url = "/exercise2_email/thanks.jsp"; //the "thanks" page
 				//Add user vào database
 				UserIO.addRecord(user, path);
			}
			
			 // create the Date object and store it in the request
	        Date currentDate = new Date();
	        request.setAttribute("currentDate", currentDate);

	        // create users list and store it in the session
	        ArrayList<User> users = UserIO.getUsers(path);

	        session.setAttribute("users", users);
			
			
			request.setAttribute("user",user);
			request.setAttribute("message", message);
			
			//url = path+"exercise2_email/thanks.jsp"; //the "thanks" page
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);

			//response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		else if (action.equals("join")) {
			url ="/exercise2_email/exc2.jsp";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
	}

}
