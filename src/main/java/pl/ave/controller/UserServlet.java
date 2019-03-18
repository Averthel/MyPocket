package pl.ave.controller;

import com.sun.org.apache.xpath.internal.operations.Operation;
import pl.ave.dao.DaoFactory;
import pl.ave.dao.UserDao;
import pl.ave.model.User;
import pl.ave.util.DbOperationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        String findUser = request.getParameter("findUser");
        String userForDelete = request.getParameter("userForDelete");

        String register = request.getParameter("register");
        String search = request.getParameter("search");
        String delete = request.getParameter("delete");
        String update = request.getParameter("update");


        try{
            DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL_DAO);
            UserDao dao = factory.getUserDao();
            User user = null;
            String operation = null;
            if("search".equals(search)){
                user = dao.read(findUser);
                operation = "Wynik wyszukania: "+ user.toString();
            }else if("register".equals(register)){
                user = new User(username, password, email);
                dao.create(user);
                operation = "Rejestracja użytkownika: " +username;
            }else if("delete".equals(delete)){
                user = new User(userForDelete, email, password);
                dao.delete(user);
                operation = "usunięto użytkownika: " + userForDelete;
            }else if("update".equals(update)){
                user = new User(username, email, password);
                dao.update(user);
                operation = "zaktualizowano e-mail oraz hasło dla użytkownika: "+ username ;
            }
            request.setAttribute("user", user);
            request.setAttribute("operation", operation);
            request.getRequestDispatcher("userResult.jsp").forward(request, response);
        }catch (DbOperationException e){
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
