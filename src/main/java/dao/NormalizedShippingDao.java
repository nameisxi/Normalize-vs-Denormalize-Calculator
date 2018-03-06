package dao;

import db.NormalizedDatabase;
import domain.NormalizedShipping;

import java.util.*;
import java.sql.*;

public class NormalizedShippingDao implements Dao<NormalizedShipping, Integer> {
    private NormalizedDatabase db;

    public NormalizedShippingDao(NormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public NormalizedShipping findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NormalizedShipping> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NormalizedShipping saveOrUpdate(NormalizedShipping ns) throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM Shipping WHERE id = (?)");
            statement.setInt(1, ns.getId());
            ResultSet rs = statement.executeQuery();

            statement.close();

            if (!rs.next()) {
                rs.close();
                return this.save(ns);
            } else {
                rs.close();
                return this.update(ns);
            }
        }
    }

    public NormalizedShipping save(NormalizedShipping ns) throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Shipping (id, customer_id, seller_id, date, shipping_class, address, method_of_shipping) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, ns.getId());
            statement.setInt(2, ns.getCustomer().getId());
            statement.setInt(3, ns.getSeller().getId());
            statement.setDate(4, ns.getDate());
            statement.setString(5, ns.getShippingClass());
            statement.setString(6, ns.getAddress());
            statement.setString(7, ns.getMethodOfShipping());
            statement.executeUpdate();

            statement.close();
        }
        return ns;
    }

    public NormalizedShipping update(NormalizedShipping ns) throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Shipping SET date = (?), shipping_class = (?), address = (?), method_of_shipping = (?) WHERE id = (?)");
            statement.setDate(1, ns.getDate());
            statement.setString(2, ns.getShippingClass());
            statement.setString(3, ns.getAddress());
            statement.setString(4, ns.getMethodOfShipping());
            statement.setInt(5, ns.getId());
            statement.executeUpdate();

            statement.close();
        }
        return ns;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteAll() throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Seller");
            statement.executeUpdate();

            statement = connection.prepareStatement("DELETE FROM Customer");
            statement.executeUpdate();

            statement = connection.prepareStatement("DELETE FROM Shipping");
            statement.executeUpdate();

            statement.close();
        }
    }

}

