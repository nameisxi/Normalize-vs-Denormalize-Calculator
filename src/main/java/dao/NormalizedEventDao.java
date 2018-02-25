package dao;

import db.NormalizedDatabase;
import domain.NormalizedEvent;

import java.util.*;
import java.sql.*;

public class NormalizedEventDao implements Dao<NormalizedEvent, Integer> {
    private NormalizedDatabase db;

    public NormalizedEventDao(NormalizedDatabase db) {
        this.db = db;
    }

    @Override
    public NormalizedEvent findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NormalizedEvent> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NormalizedEvent saveOrUpdate(NormalizedEvent n) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM Tapahtuma WHERE id = (?)");
        statement.setInt(1, n.getId());
        ResultSet rs = statement.executeQuery();

        if (!rs.next()) {
            rs.close();
            return this.save(n);
        } else {
            rs.close();
            return this.update(n);
        }

    }

    public NormalizedEvent save(NormalizedEvent n) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Event (id, user_id, page_id, date, operation, ip, device) VALUES (?, ?, ?, ?, ?, ?, ?)");
        statement.setInt(1, n.getId());
        statement.setInt(2, n.getUser().getId());
        statement.setInt(3, n.getPage().getId());
        statement.setDate(4, n.getDate());
        statement.setString(5, n.getOperation());
        statement.setString(6, n.getIp());
        statement.setString(7, n.getDevice());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return n;
    }

    public NormalizedEvent update(NormalizedEvent n) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Event SET date = (?), operation = (?), ip = (?), device = (?) WHERE id = (?)");
        statement.setDate(1, n.getDate());
        statement.setString(2, n.getOperation());
        statement.setString(3, n.getIp());
        statement.setString(4, n.getDevice());
        statement.setInt(5, n.getId());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return n;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

