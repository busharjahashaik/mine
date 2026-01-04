package com.mining.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.MineSite;
import com.mining.util.HibernateUtil;

public class MineDao {

    // INSERT
    public void saveMine(MineSite mine) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.save(mine);

        tx.commit();
        session.close();
    }

    // FETCH BY ID
    public MineSite getMineById(int id) {
        Session session = HibernateUtil.getSession().getSession();
        MineSite mine = session.get(MineSite.class, id);
        session.close();
        return mine;
    }

    // FETCH ALL
    public List<MineSite> getAllMines() {
        Session session = HibernateUtil.getSession().getSession();
        List<MineSite> mines =
                session.createQuery("from MineSite", MineSite.class).list();
        session.close();
        return mines;
    }

    // UPDATE
    public void updateMine(MineSite mine) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.update(mine);

        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteMine(int id) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        MineSite mine = session.get(MineSite.class, id);
        if (mine != null) {
            session.delete(mine);
        }

        tx.commit();
        session.close();
    }
}