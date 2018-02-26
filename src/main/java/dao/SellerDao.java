package dao;

import db.NormalizedDatabase;
import domain.Seller;

import java.util.*;
import java.sql.*;

public class SellerDao implements Dao<Seller, Integer> {
    private NormalizedDatabase db;

    public SellerDao(NormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public Seller findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seller> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seller saveOrUpdate(Seller s) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM Seller WHERE id = (?)");
        statement.setInt(1, s.getId());
        ResultSet rs = statement.executeQuery();

        statement.close();
        connection.close();

        if (rs == null) {
            rs.close();
            return this.save(s);
        } else {
            rs.close();
            return this.update(s);
        }

    }

    public Seller save(Seller s) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Seller (id, name) VALUES (?, ?)");
        statement.setInt(1, s.getId());
        statement.setString(2, s.getName());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return s;
    }

    public Seller update(Seller s) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Seller SET name = (?) WHERE id = (?)");
        statement.setString(1, s.getName());
        statement.setInt(2, s.getId());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return s;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
