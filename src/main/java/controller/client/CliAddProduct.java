package controller.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import connect.Dao;
import jakarta.servlet.annotation.MultipartConfig;
import model.Product;

/**
 * Servlet implementation class CliAddProduct
 */
@WebServlet("/CliAddProduct")

public class CliAddProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		List<Product> pro = new ArrayList<Product>();
		pro = dao.getAllProduct();
		
		request.setAttribute("listpro",pro);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("cliaddproduct.jsp");
        rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		
		
	}

}
