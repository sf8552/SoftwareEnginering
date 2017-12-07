package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserBean.UserBean;

public class LoginServlet extends HttpServlet {
	private String username;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException{
		
		 username = request.getParameter("username");
		 System.out.print("username="+username);
		 
		 UserBean user = new UserBean();
		 boolean b = user.validate(username);
		 
		 String forward;
		 
		 if (b) {
		  HttpSession session = request.getSession(true);
		  session.setAttribute("username", username);
		  
			 forward = "success.jsp";
		 }
		   else 
			   forward ="failurejsp";
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		 dispatcher.forward(request, response);
		 
		}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException,ServletException{
			doGet(request,response);
		}

}
