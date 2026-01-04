package com.mining.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.EquipmentUsage;
import com.mining.util.HibernateUtil;

public class EquipmentUsageDAO {

    public void save(EquipmentUsage usage) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.save(usage);

        tx.commit();
        session.close();
    }
}