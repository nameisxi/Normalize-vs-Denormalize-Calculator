package db;

import java.util.*;
import java.sql.*;

public class NormalizedDatabase {
    private String dbAddress;

    public NormalizedDatabase(String dbAddress) {
        this.dbAddress = dbAddress;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbAddress);
    }
}
