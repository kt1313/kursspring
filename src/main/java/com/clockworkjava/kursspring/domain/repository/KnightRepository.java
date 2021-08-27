package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import jdk.jshell.spi.ExecutionControl;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    void createKnight(Knight knight);

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException(" . ERROR . ");

    };
}
