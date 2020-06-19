package servlets;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/adding")
public class ServletAdd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        UserService userService = UserService.getInstance();
        userService.addUser(new User(name, lastName, age));
        List<User> list = userService.getAllUsers();
        req.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/admin/index.jsp").forward(req, resp);
    }
}
