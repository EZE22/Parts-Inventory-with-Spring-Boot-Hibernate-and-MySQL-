package com.example.parts_inventory.dao;

import com.example.parts_inventory.entity.Nikon;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class NikonDAOImpl implements NikonDAO {

    private EntityManager entityManager;

    @Autowired
    public NikonDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Nikon> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Nikon> myQuery = currentSession.createQuery("from Nikon");
        List<Nikon> parts = myQuery.getResultList();
        return parts;
    }

    @Override
    @Transactional
    public Nikon findById(int partId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Nikon selectedPart = currentSession.get(Nikon.class, partId);
        return selectedPart;
    }

    @Override
    @Transactional
    public void save(Nikon newPart) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(newPart);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Nikon> myQuery = currentSession.createQuery("delete from Nikon where id=:partId");
        myQuery.setParameter("partId", theId);
        myQuery.executeUpdate();
    }
}
