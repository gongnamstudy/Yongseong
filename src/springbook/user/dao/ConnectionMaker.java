package springbook.user.dao;

import java.sql.SQLException;
import java.sql.Connection;

public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
