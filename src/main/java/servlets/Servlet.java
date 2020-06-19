package servlets;

    import model.User;
    import service.UserService;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;

@WebServlet("")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/logging.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login");
        String lastName = req.getParameter("password");
        User user = UserService.getInstance().loginningUser(name, lastName);
        req.setAttribute("user", user);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            if (user.getRole().equals("user")) {
                getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/admin/index.jsp").forward(req, resp);
            }
        } else {
            resp.setStatus(403);
        }
    }
}
