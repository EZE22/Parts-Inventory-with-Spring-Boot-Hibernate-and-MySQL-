package com.example.parts_inventory.dao;

import com.example.parts_inventory.entity.Canon;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;


import java.util.List;

@Repository
public class CanonDAOImpl implements CanonDAO {

    private EntityManager entityManager;

    @Autowired
    public CanonDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Canon> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Canon> myQuery = currentSession.createQuery("from Canon");
        List<Canon> canonParts = myQuery.getResultList();
        return canonParts;
    }

    @Override
    @Transactional
    public Canon findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Canon selectPart = currentSession.get(Canon.class, theId);
        return selectPart;
    }

    @Override
    @Transactional
    public void save(Canon newPart) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newPart);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Canon> myQuery = currentSession.createQuery("delete from Canon where id=:partId");
        myQuery.setParameter("partId", theId);
        myQuery.executeUpdate();
    }
}
