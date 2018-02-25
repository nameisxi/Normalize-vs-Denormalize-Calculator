package dao;

import db.NormalizedDatabase;
import domain.User;

import java.util.*;
import java.sql.*;

public class UserDao implements Dao<User, Integer> {
    private NormalizedDatabase db;

    public UserDao(NormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public User findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User saveOrUpdate(User u) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM User WHERE id = (?)");
        statement.setInt(1, u.getId());
        ResultSet rs = statement.executeQuery();

        statement.close();
        connection.close();

        if (rs == null) {
            rs.close();
            return this.save(u);
        } else {
            rs.close();
            return this.update(u);
        }
    }

    public User save(User u) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO User (id, username) VALUES (?, ?)");
        statement.setInt(1, u.getId());
        statement.setString(2, u.getUsername());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return u;
    }

    public User update(User u) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE User SET username = (?) WHERE id = (?)");
        statement.setString(1, u.getUsername());
        statement.setInt(2, u.getId());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return u;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
