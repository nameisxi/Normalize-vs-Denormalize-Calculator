package domain;

import java.sql.Date;
import java.util.*;
import java.sql.*;

public class DataGenerator {
    private final Random random;

    public DataGenerator() {
        this.random = new Random();
    }

    public String ip() {
        return "127.0.0." + random.nextInt(256);
    }

    public Date date() {
        return new Date(new java.util.Date().getTime() - random.nextInt(10000000));
    }

    public String address() {
        return "page-" + random.nextInt(50);
    }

    public String operation() {
        return "operation-" + random.nextInt(10);
    }

    public String device() {
        return "device-" + random.nextInt(50);
    }

    public String user() {
        return "user-" + random.nextInt(50);
    }

}
