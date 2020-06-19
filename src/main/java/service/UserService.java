package service;

import DAO.UserDAO;
import DAO.UserHibernateDAO;
import DAO.UserJdbcDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;
import util.UserDaoFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public static UserService userService;

    private UserDAO dao = getUserDAO();

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public User loginningUser(String name, String lastName) {
        User user = dao.loginningUser(name, lastName);
        return user;
    }


    public boolean updateTable(long id, User user) {
        User oldUser = dao.getUserById(id);
        if (oldUser != null) {
            dao.updateUser(id, user);
        } else {
            return false;
        }
        return true;
    }

    public boolean deleteUser(long id) {
        User oldUser = dao.getUserById(id);
        if (oldUser != null) {
            dao.deleteUser(id);
        } else {
            return false;
        }
        return true;
    }

    public List<User> getAllUsers(){
        return dao.getAllUsers();
    }

    public boolean addUser(User user) {
        return dao.addUser(user);
    }

    private UserDAO getUserDAO() {
        return UserDaoFactory.getUserDAO();
    }
}
