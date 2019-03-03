package pl.ave.controller;


import pl.ave.dao.ProductDao;
import pl.ave.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int count = Integer.parseInt(request.getParameter("count"));
        String option = request.getParameter("option");
        try {
            ProductDao dao = new ProductDao();
            Product product = null;
            String operation = null;
            if ("add".equals(option)) {
                product = new Product(name, description, category, price, count);
                dao.create(product);
                operation = "add";
            }
            request.setAttribute("option", operation);
            request.setAttribute("product", product);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
