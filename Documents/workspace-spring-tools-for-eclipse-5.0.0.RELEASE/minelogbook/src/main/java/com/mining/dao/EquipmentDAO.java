package com.mining.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.Equipment;
import com.mining.util.HibernateUtil;

public class EquipmentDAO {

    public void save(Equipment Equipment) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.save(Equipment);

        tx.commit();
        session.close();
    }

    public Equipment getById(int equipmentId) {
        Session session = HibernateUtil.getSession().getSession();
        Equipment eq = session.get(Equipment.class, equipmentId);
        session.close();
        return eq;
    }

    public void update(Equipment Equipment) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.update(Equipment);

        tx.commit();
        session.close();
    }
}