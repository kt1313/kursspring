package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.PlayerInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class PlayerInformationRepository {

@PersistenceContext
    EntityManager em;

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }


    @Transactional
    public void createPlayerInformation(){
    PlayerInformation pi=new PlayerInformation();
    em.persist(pi);

}


}
