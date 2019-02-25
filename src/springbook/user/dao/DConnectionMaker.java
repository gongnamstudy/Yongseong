package springbook.user.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DConnectionMaker implements ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/kimyongseong", "root", "");
        return c;
    }
}
