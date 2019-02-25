package springbook.user.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleConnectionMaker {
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/kimyongseong", "root", "");
        return c;
    }
}
