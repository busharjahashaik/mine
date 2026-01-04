package com.mining.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.MineSite;
import com.mining.entity.Worker;
import com.mining.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        // ---- Create MineSite ----
        MineSite mine = new MineSite();
        mine.setName("Coal Mine A");
        mine.setLocation("Telangana");
        mine.setStatus(MineSite.Status.ACTIVE);

        session.save(mine); // save first to generate mineId

        // ---- Create Workers ----
        Worker worker1 = new Worker();
        worker1.setName("Ravi");
        worker1.setRole("Operator");
        worker1.setPhone("9876543210");
        worker1.setMineSite(mine); // MUST assign MineSite

        Worker worker2 = new Worker();
        worker2.setName("Suresh");
        worker2.setRole("Supervisor");
        worker2.setPhone("9123456789");
        worker2.setMineSite(mine); // MUST assign MineSite

        // ---- Save Workers ----
        session.save(worker1);
        session.save(worker2);

        tx.commit(); // commit all changes
        session.close();

        System.out.println("MineSite and Workers inserted successfully");
    }
}
