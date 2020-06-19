package util;

import DAO.UserDAO;
import DAO.UserHibernateDAO;
import DAO.UserJdbcDAO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {

    private static String daoType = getProperties();

    private static String getProperties() {
        Properties properties = new Properties();
        String daoType;
        try (FileReader reader = new FileReader(new File("d:/Example/JMTask112/src/main/resources/.properties"))) {
            properties.load(reader);
            daoType = properties.getProperty("daotype");
        } catch (IOException exc) {
            return null;
        }
        return daoType;
    }

    private static UserJdbcDAO createJdbcDao() {
        return new UserJdbcDAO(DBHelper.getInstance().getConnection());
    }

    private static UserHibernateDAO createHibernateDao() {
        return new UserHibernateDAO(DBHelper.getInstance().getSessionFactory());
    }

    public static UserDAO getUserDAO() {
        if(daoType != null && daoType.equals("jdbc")) {
            return createJdbcDao();
        } else if(daoType != null && daoType.equals("hibernate")) {
            return createHibernateDao();
        } else {
            return null;
        }

    }

}
