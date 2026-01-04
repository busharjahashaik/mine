package com.mining.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.ShiftLog;
import com.mining.util.HibernateUtil;

public class ShiftLogDAO {

    public void save(ShiftLog shift) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.save(shift);

        tx.commit();
        session.close();
    }

    public ShiftLog getById(int shiftId) {
        Session session = HibernateUtil.getSession().getSession();
        ShiftLog shift = session.get(ShiftLog.class, shiftId);
        session.close();
        return shift;
    }
}