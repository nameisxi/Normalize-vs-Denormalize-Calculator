package domain;

import java.sql.Date;
import java.util.*;
import java.sql.*;

public class NormalizedEvent {
    private Integer id;
    private User user;
    private Page page;
    private Date date;
    private String operation;
    private String ip;
    private String device;

    public NormalizedEvent(Integer id, User user, Page page, Date date, String operation, String ip, String device) {
        this.id = id;
        this.user = user;
        this.page = page;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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
