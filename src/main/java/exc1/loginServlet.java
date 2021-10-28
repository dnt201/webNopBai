package exc1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //get current action
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
        
        else if(action.equals("login")){
        //get parameters from the request
        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("Password");
        
        request.setAttribute("UserName", UserName);
        request.setAttribute("Password", Password);
        
        url ="/exercise1/thankLogin.jsp";
        getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
        }
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
