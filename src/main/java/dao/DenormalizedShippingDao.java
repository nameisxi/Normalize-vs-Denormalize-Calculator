package dao;

import db.DenormalizedDatabase;
import domain.DenormalizedShipping;

import java.util.*;
import java.sql.*;

public class DenormalizedShippingDao implements Dao<DenormalizedShipping, Integer> {

    private DenormalizedDatabase db;

    public DenormalizedShippingDao(DenormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public DenormalizedShipping findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DenormalizedShipping> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DenormalizedShipping saveOrUpdate(DenormalizedShipping dn) throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM Shipping WHERE id = (?)");
            statement.setInt(1, dn.getId());
            ResultSet rs = statement.executeQuery();

            statement.close();

            if (!rs.next()) {
                rs.close();
                return this.save(dn);
            } else {
                rs.close();
                return this.update(dn);
            }
        }
    }

    public DenormalizedShipping save(DenormalizedShipping dn) throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Shipping (id, customer_name, seller_name, date, shipping_class, address, method_of_shipping) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, dn.getId());
            statement.setString(2, dn.getCustomerName());
            statement.setString(3, dn.getSellerName());
            statement.setDate(4, dn.getDate());
            statement.setString(5, dn.getShippingClass());
            statement.setString(6, dn.getAddress());
            statement.setString(7, dn.getMethodOfShipping());
            statement.executeUpdate();

            statement.close();
        }
        return dn;
    }

    public DenormalizedShipping update(DenormalizedShipping dn) throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Shipping SET customer_name = (?), seller_name = (?), date = (?), shipping_class = (?), address = (?), method_of_shipping = (?) WHERE id = (?)");
            statement.setString(1, dn.getCustomerName());
            statement.setString(2, dn.getSellerName());
            statement.setDate(3, dn.getDate());
            statement.setString(4, dn.getShippingClass());
            statement.setString(5, dn.getAddress());
            statement.setString(6, dn.getMethodOfShipping());
            statement.setInt(7, dn.getId());
            statement.executeUpdate();

            statement.close();
        }
        return dn;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteAll() throws SQLException {
        try (Connection connection = this.db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Shipping");
            statement.executeUpdate();
            statement.close();
        }
    }

}

