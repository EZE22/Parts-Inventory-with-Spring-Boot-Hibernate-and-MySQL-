package com.example.parts_inventory.dao;

import com.example.parts_inventory.entity.Sony;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SonyDAOImpl implements SonyDAO {

    private EntityManager entityManager;

    @Autowired
    public SonyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query sonyQuery = currentSession.createQuery("from Sony");
        return sonyQuery.getResultList();
    }

    @Override
    @Transactional
    public Sony findById(int partId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Sony selectedPart = currentSession.get(Sony.class, partId);
        return selectedPart;
    }

    @Override
    @Transactional
    public void save(Sony newPart) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newPart);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query myQuery = currentSession.createQuery("delete from Sony where id=:partId");
        myQuery.setParameter("partId", theId);
        myQuery.executeUpdate();
    }
}
