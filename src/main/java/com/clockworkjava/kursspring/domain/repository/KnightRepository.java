package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import java.util.Optional;
import javax.annotation.PostConstruct;
import java.util.Collection;

public interface KnightRepository {

    void createKnight(Knight knight);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    Knight getKnightById(Integer id);
}
