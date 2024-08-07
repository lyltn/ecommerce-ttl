package controller.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import connect.Dao;

@WebServlet("/CliAddImgPro")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class CliAddImgPro extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
		String description = request.getParameter("describe");
		String status = request.getParameter("status");
		String brandt = request.getParameter("brand");
		String categoryt = request.getParameter("category");
		String afft = request.getParameter("aff");
		String sext = request.getParameter("sex");
		System.out.print(brandt+ categoryt+ sext+ afft);
		int brand = Integer.parseInt(brandt);
		int category = Integer.parseInt(categoryt);
		int aff = Integer.parseInt(afft);
		int sex =Integer.parseInt(sext) ;
		
		javax.servlet.http.HttpSession session = request.getSession();
		int idUser = (int) session.getAttribute("idUser");
		Random random = new Random();
		Dao dao = new Dao();
		System.out.println(name + " " + description+ " " + status + " " + brandt + " " + categoryt+ " "+ afft + " "+ sext);
		if(status != null) {
			dao.insertProduct( name, description, brand, category, sex, aff, idUser, 1);
		}else{
			dao.insertProduct( name, description, brand, category, sex, aff, idUser, 0);
		}
        

        System.out.println("Processing file upload...");
        int idProduct = dao.getIdNewProduct();
        Collection<Part> fileParts = request.getParts();

        try {
            for (Part filePart : fileParts) {
                if (filePart.getName().equals("images")) {
                    try (InputStream inputStream = filePart.getInputStream()) {
                        if (inputStream != null) {
                            System.out.println("Uploading image for product ID: " + idProduct);
                            dao.insertImgProduct(idProduct, inputStream);
                        }
                    } catch (IOException e) {
                        System.err.println("Error reading file part input stream: " + e.getMessage());
                    }
                }
            }
            request.setAttribute("signal", "Inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error processing file upload: " + e.getMessage());
            request.setAttribute("signal", "Error during insertion.");
        }

        RequestDispatcher rd = request.getRequestDispatcher("cliaddproduct.jsp");
        rd.forward(request, response);
    }
}
