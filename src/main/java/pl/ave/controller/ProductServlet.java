package pl.ave.controller;


import pl.ave.dao.DaoFactory;
import pl.ave.dao.ProductDao;
import pl.ave.model.Product;
import pl.ave.util.DbOperationException;

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
        double price = 0;
        if(request.getParameter("price") != null && request.getParameter("price") != "") {
            price = Double.parseDouble(request.getParameter("price"));
        }
        int count = 0;
        if(request.getParameter("count") != null && request.getParameter("count") != "") {
            count = Integer.parseInt(request.getParameter("count"));
        }
        String option = request.getParameter("option");
        try {
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL_DAO);
            ProductDao dao = factory.getProductDao();
            Product product = null;
            String operation = null;
            if ("search".equals(option)) {
                product = dao.read(name);
                operation = "search";
            } else if ("add".equals(option)) {
                product = new Product(name, description, category, price, count);
                dao.create(product);
                operation = "add";
            } else if ("update".equals(option)) {
                product = new Product(name, description, category, price, count);
                dao.update(product);
                operation = "update";
            } else if ("delete".equals(option)) {
                product = new Product(name, description, category, price, count);
                dao.delete(product);
                operation = "delete";
            }
            request.setAttribute("option", operation);
            request.setAttribute("product", product);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (DbOperationException e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
