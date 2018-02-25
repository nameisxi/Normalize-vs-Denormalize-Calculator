package domain;

import java.sql.Date;
import java.util.*;
import java.sql.*;

public class DenormalizedEvent {
    private Integer id;
    private String username;
    private String address;
    private Date date;
    private String operation;
    private String ip;
    private String device;

    public DenormalizedEvent(Integer id, String username, String address, Date date, String operation, String ip, String device) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.date = date;
        this.operation = operation;
        this.ip = ip;
        this.device = device;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
