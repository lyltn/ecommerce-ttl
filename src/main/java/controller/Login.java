package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Dao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("user-name");
        String pass = request.getParameter("password");
        System.out.println(name + " " + pass);
		Dao dao = new Dao();
		Vector user = dao.geUser(name, pass);
		if(user!=null && (int)user.get(9)==1) {
			Vector<Vector> role = dao.geRoleOfUser((int)user.get(0));
			System.out.println(user);
			System.out.println("role nè : "+role);
			javax.servlet.http.HttpSession session = request.getSession();
			session.removeAttribute("idUser");
			session.setAttribute("idUser", user.get(0));
			int slrole = 0;
			for (Vector vt : role) {
				if((int)vt.get(2)==1 && vt.get(1).equals("customer")) {
					slrole +=1; 	
				}else if((int)vt.get(2)==1 && vt.get(1).equals("client")) {
					slrole += 1;
				}else if((int)vt.get(2)==1 && vt.get(1).equals("admin")) {
					slrole = 0;
				}
			}
			if(slrole > 1) {
				RequestDispatcher rd = request.getRequestDispatcher("cliindex.jsp");
				rd.forward(request, response);
			}else if(slrole == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("adindex.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("cusindex.jsp");
				rd.forward(request, response);
			}

		}else {
			request.setAttribute("signal", "=> Username or password is incorrect!!!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
