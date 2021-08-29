package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return em.createQuery("from Knight", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = em.createQuery("from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);

    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        em.remove(id);
    }

    @Override
    public void build() {

    }


    @Override
    @TransactionAttribute
    public void createKnight(Knight knight) {
        em.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class, id);
    }


    @Override
    @TransactionAttribute
    public void updateKnight(int id,Knight knight){
        em.merge(knight);
    }
}
