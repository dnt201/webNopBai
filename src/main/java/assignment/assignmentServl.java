
package assignment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exc4.data.ProductIO;
import exc4.business.Product;


@WebServlet("/assignmentServl")
public class assignmentServl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public assignmentServl() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext sc = request.getServletContext();
		HttpSession session = request.getSession();

		String url="";        //get current action
		String action = request.getParameter("action");
		if(action==null){
			action="homepage";  //default action
		}

		if(action.equals("homepage")){
			url = "/index.html";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}

		else if(action.equals("exercise1")){
			url = "/exercise1/exc1Nav.jsp";
			//url= context.getRealPath("/exercise1/exc1.jsp");
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}


		else if(action.equals("exercise2")){
			url = "/exercise2_email/exc2.jsp";
			//url = +context.getRealPath("/exercise2_email/week3.jsp");
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		
		else if(action.equals("exercise4")){
			url = "/exercise4/index.jsp";
			//url = +context.getRealPath("/exercise2_email/week3.jsp");
			String path = sc.getRealPath("/WEB-INF/products.txt");

			ArrayList<Product> products = ProductIO.getProducts(path);
			session.setAttribute("products", products);
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		else if(action.equals("exercise3")){
			url = "/exercise3/index.jsp";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		else if(action.equals("exercise5")){
			url = "/exercise5/index.jsp";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
