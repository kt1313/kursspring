package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnightService {


    @Autowired
    KnightRepository knightRepository;

    public List<Knight> getAllKnights(){
        return new ArrayList<>(knightRepository.getAllKnights());
    }

public void saveKnight(Knight knight){
        knightRepository.createKnight(knight);
}


    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);

    }
}
