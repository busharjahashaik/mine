package com.mining.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.ProductionLog;
import com.mining.util.HibernateUtil;

public class ProductionDAO {

    public void save(ProductionLog prod) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.save(prod);

        tx.commit();
        session.close();
    }
}