package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.Collection;

public class DBKnightRepository implements KnightRepository {

    @Override
    public void createKnight(String name, int age) {

        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Knight getKnight(String name) {
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    @PostConstruct
    public void build() {

    }


}
