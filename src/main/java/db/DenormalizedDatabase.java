package db;

import java.util.*;
import java.sql.*;

public class DenormalizedDatabase {
    private String dbAddress;

    public DenormalizedDatabase(String dbAddress) {
        this.dbAddress = dbAddress;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbAddress);
    }
}
