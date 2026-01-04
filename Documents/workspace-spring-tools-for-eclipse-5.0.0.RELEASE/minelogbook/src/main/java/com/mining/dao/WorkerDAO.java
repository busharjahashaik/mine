package com.mining.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.Worker;
import com.mining.util.HibernateUtil;

public class WorkerDAO {

    public void save(Worker worker) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.save(worker);

        tx.commit();
        session.close();
    }

    public Worker getById(int workerId) {
        Session session = HibernateUtil.getSession().getSession();
        Worker worker = session.get(Worker.class, workerId);
        session.close();
        return worker;
    }
}