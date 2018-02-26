package dao;

import db.DenormalizedDatabase;
import domain.DenormalizedEvent;

import java.util.*;
import java.sql.*;

public class DenormalizedEventDao implements Dao<DenormalizedEvent, Integer> {

    private DenormalizedDatabase db;

    public DenormalizedEventDao(DenormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public DenormalizedEvent findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DenormalizedEvent> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DenormalizedEvent saveOrUpdate(DenormalizedEvent dn) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM Shipping WHERE id = (?)");
        statement.setInt(1, dn.getId());
        ResultSet rs = statement.executeQuery();

        if (!rs.next()) {
            rs.close();
            return this.save(dn);
        } else {
            rs.close();
            return this.update(dn);
        }
    }

    public DenormalizedEvent save(DenormalizedEvent dn) throws SQLException {
        Connection connection = this.db.getConnection();
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
        connection.close();

        return dn;
    }

    public DenormalizedEvent update(DenormalizedEvent dn) throws SQLException {
        Connection connection = this.db.getConnection();
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
        connection.close();

        return dn;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

