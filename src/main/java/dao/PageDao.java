package dao;

import db.NormalizedDatabase;
import domain.Page;

import java.util.*;
import java.sql.*;

public class PageDao implements Dao<Page, Integer> {
    private NormalizedDatabase db;

    public PageDao(NormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public Page findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Page> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page saveOrUpdate(Page p) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM User WHERE id = (?)");
        statement.setInt(1, p.getId());
        ResultSet rs = statement.executeQuery();

        statement.close();
        connection.close();

        if (rs == null) {
            rs.close();
            return this.save(p);
        } else {
            rs.close();
            return this.update(p);
        }

    }

    public Page save(Page p) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Page (id, address) VALUES (?, ?)");
        statement.setInt(1, p.getId());
        statement.setString(2, p.getAddress());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return p;
    }

    public Page update(Page p) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Page SET address = (?) WHERE id = (?)");
        statement.setString(1, p.getAddress());
        statement.setInt(2, p.getId());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return p;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
