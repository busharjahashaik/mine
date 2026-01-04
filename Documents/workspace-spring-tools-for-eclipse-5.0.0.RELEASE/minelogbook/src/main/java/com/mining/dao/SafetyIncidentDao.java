package com.mining.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mining.entity.SafetyIncident;
import com.mining.util.HibernateUtil;

public class SafetyIncidentDao {

    public void save(SafetyIncident incident) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        session.save(incident);

        tx.commit();
        session.close();
    }

    public SafetyIncident getById(int incidentId) {
        Session session = HibernateUtil.getSession().getSession();
        SafetyIncident incident = session.get(SafetyIncident.class, incidentId);
        session.close();
        return incident;
    }

    public void closeIncident(int incidentId) {
        Session session = HibernateUtil.getSession().getSession();
        Transaction tx = session.beginTransaction();

        SafetyIncident incident = session.get(SafetyIncident.class, incidentId);

        if (incident == null) {
            System.out.println("Incident not found");
        } 
        else if (incident.getStatus() == SafetyIncident.Status.CLOSED) {
            System.out.println("Incident already CLOSED");
        } 
        else {
            incident.setStatus(SafetyIncident.Status.CLOSED); // ✅ CORRECT
            session.update(incident);
            System.out.println("Incident closed successfully");
        }

        tx.commit();
        session.close();
    }
}