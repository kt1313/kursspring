package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;

public class DBKnightRepository implements KnightRepository {



    @Override
    public void createKnight(Knight knight) {
        System.out.println("Uzywam DB");
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("uzywam bazy danych");
        return null;    }

    @Override
    public Knight getKnight(String name) {
        System.out.println("uzywam bazy danych");
        return null;    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("uzywam bazy danych");
    }

    @Override
    @PostConstruct
    public void build() {

    }


}
