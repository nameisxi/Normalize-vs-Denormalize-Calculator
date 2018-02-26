package dao;

import db.NormalizedDatabase;
import domain.Customer;

import java.util.*;
import java.sql.*;

public class CustomerDao implements Dao<Customer, Integer> {
    private NormalizedDatabase db;

    public CustomerDao(NormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public Customer findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer saveOrUpdate(Customer c) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM Customer WHERE id = (?)");
        statement.setInt(1, c.getId());
        ResultSet rs = statement.executeQuery();

        statement.close();
        connection.close();

        if (rs == null) {
            rs.close();
            return this.save(c);
        } else {
            rs.close();
            return this.update(c);
        }
    }

    public Customer save(Customer c) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Customer (id, name) VALUES (?, ?)");
        statement.setInt(1, c.getId());
        statement.setString(2, c.getName());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return c;
    }

    public Customer update(Customer c) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Customer SET name = (?) WHERE id = (?)");
        statement.setString(1, c.getName());
        statement.setInt(2, c.getId());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return c;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
