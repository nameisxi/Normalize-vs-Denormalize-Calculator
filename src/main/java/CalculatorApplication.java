import dao.DenormalizedEventDao;
import dao.NormalizedEventDao;
import dao.PageDao;
import dao.UserDao;
import db.DenormalizedDatabase;
import db.NormalizedDatabase;
import domain.*;

import java.io.File;
import java.util.*;
import java.sql.*;

public class CalculatorApplication {

    public static void main(String[] args) throws Exception {
        DataGenerator generator = new DataGenerator();
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Data(generator.ip(), generator.address(), generator.operation(), generator.user(), generator.device(), generator.date()));
        }

        // Denormalized database
        File dbFile1 = new File("db", "events-denormalized.db");

        DenormalizedDatabase denormalizedDB = new DenormalizedDatabase("jdbc:sqlite:" + dbFile1.getAbsolutePath());
        DenormalizedEventDao dnEventDao = new DenormalizedEventDao(denormalizedDB);

        long start1 = System.nanoTime();
        int id1 = 1;
        for (Data row : data) {
            DenormalizedEvent dn = new DenormalizedEvent(id1, row.getUser(), row.getAddress(), row.getDate(), row.getOperation(), row.getIp(), row.getDevice());
            dnEventDao.saveOrUpdate(dn);
            id1++;
        }

        long end1 = System.nanoTime();
        System.out.println("It took " + (end1 - start1) + " nanoseconds and " + ((double)(end1 - start1) / 1000000000.0) + " seconds to add the data to denormalized database.");

        // Normalized database
        File dbFile2 = new File("db", "events-normalized.db");

        NormalizedDatabase normalizedDB = new NormalizedDatabase("jdbc:sqlite:" + dbFile2.getAbsolutePath());
        NormalizedEventDao nEventDao = new NormalizedEventDao(normalizedDB);
        UserDao userDao = new UserDao(normalizedDB);
        PageDao pageDao = new PageDao(normalizedDB);

        long start2 = System.nanoTime();
        int id2 = 1;
        for (Data row : data) {
            User user = new User(id2, row.getUser());
            userDao.saveOrUpdate(user);
            Page page = new Page(id2, row.getAddress());
            pageDao.saveOrUpdate(page);
            NormalizedEvent ne = new NormalizedEvent(id2, user, page, row.getDate(), row.getOperation(), row.getIp(), row.getDevice());
            nEventDao.saveOrUpdate(ne);
            id2++;
        }

        long end2 = System.nanoTime();

        System.out.println("It took " + (end2 - start2) + " nanoseconds and " + ((double)(end2 - start2) / 1000000000.0) + " seconds to add the data to normalized database.");
    }

}
