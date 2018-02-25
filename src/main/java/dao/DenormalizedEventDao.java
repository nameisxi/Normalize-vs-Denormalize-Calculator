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
        PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT id FROM Event WHERE id = (?)");
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
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Event (id, username, address, date, operation, ip, device) VALUES (?, ?, ?, ?, ?, ?, ?)");
        statement.setInt(1, dn.getId());
        statement.setString(2, dn.getUsername());
        statement.setString(3, dn.getAddress());
        statement.setDate(4, dn.getDate());
        statement.setString(5, dn.getOperation());
        statement.setString(6, dn.getIp());
        statement.setString(7, dn.getDevice());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return dn;
    }

    public DenormalizedEvent update(DenormalizedEvent dn) throws SQLException {
        Connection connection = this.db.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Event SET username = (?), address = (?), date = (?), operation = (?), ip = (?), device = (?) WHERE id = (?)");
        statement.setString(1, dn.getUsername());
        statement.setString(2, dn.getAddress());
        statement.setDate(3, dn.getDate());
        statement.setString(4, dn.getOperation());
        statement.setString(5, dn.getIp());
        statement.setString(6, dn.getDevice());
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

