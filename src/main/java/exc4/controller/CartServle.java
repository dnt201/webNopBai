package exc4.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exc4.data.ProductIO;
import exc4.business.*;


@WebServlet("/CartServle")
public class CartServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServle() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		ServletContext sc = getServletContext();
		HttpSession session = request.getSession();
		
		//get action
		String action = request.getParameter("action");
		
		if (action == null) {
			action ="homepage"; // trang chu
		}
		
		String url ="/index.jsp"; //homepage
		
		//mua tiếp
		if(action.equals("shop")) {
			url ="/exercise4/index.jsp";
			String path = sc.getRealPath("/WEB-INF/products.txt");
            ArrayList<Product> products = ProductIO.getProducts(path);
            session.setAttribute("producst", products);
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		
		else if (action.equals("cart")) {
			String productCode = request.getParameter("productCode");
			String quantityString = request.getParameter("quantity");
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
			}
			int quantity;
			
			try {
				quantity = Integer.parseInt(quantityString);
				if(quantity<0) {
					quantity = 1;
				}
			}catch	(NumberFormatException nfe) {
				quantity = 1;	
			}
			String path = sc.getRealPath("/WEB-INF/products.txt");

            Product product = ProductIO.getProduct(productCode, path);
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if (quantity > 0) {
                cart.addItem(lineItem);
            } else if (quantity == 0) {
                cart.removeItem(lineItem);
            }
            session.setAttribute("cart", cart);
            
            request.setAttribute("totalMoney",  cart.getTotalMoney());
            
            url = "/exercise4/cart.jsp";
        	getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		else if(action.equals("checkout")) {	
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart.getCount()>0) {
				request.setAttribute("totalMoney",  cart.getTotalMoney());
				
				cart.emptyCart();
				
				url = "/exercise4/checkoutDone.jsp";
				getServletContext()
				.getRequestDispatcher(url)
				.forward(request, response);
			}
			
			 url = "/exercise4/checkout.jsp";
	        	getServletContext()
				.getRequestDispatcher(url)
				.forward(request, response);
		}
		else if(action.equals("remove")) {
			Cart cart = (Cart) session.getAttribute("cart");
			LineItem lineItem = new LineItem();
			
			String path = sc.getRealPath("/WEB-INF/products.txt");
			Product product = ProductIO.getProduct(request.getParameter("productCode"), path);
			
			lineItem.setProduct(product);
			lineItem.setQuantity(0);
			
			cart.removeItem(lineItem);
			session.setAttribute("cart", cart);
			
			request.setAttribute("totalMoney",  cart.getTotalMoney());
			
			url = "/exercise4/cart.jsp";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
			
		}
		
		else if(action.equals("update")) {
			Cart cart = (Cart) session.getAttribute("cart");
			LineItem lineItem = new LineItem();
			String path = sc.getRealPath("/WEB-INF/products.txt");

			Product product = ProductIO.getProduct(request.getParameter("productCode"), path);
			String quantityString = request.getParameter("quantity");

			lineItem.setProduct(product);
			lineItem.setQuantity(Integer.parseInt(quantityString));

			cart.updateItem(lineItem);
			session.setAttribute("cart", cart);
			
			request.setAttribute("totalMoney",  cart.getTotalMoney());
			
			url = "/exercise4/cart.jsp";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		else if(action.equals("homepage")) {
			url = "/index.html";
			getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
		}
		
		
		else
			response.getWriter().append("Vô else rồi ").append(request.getParameter("action"));
	}
		
}


