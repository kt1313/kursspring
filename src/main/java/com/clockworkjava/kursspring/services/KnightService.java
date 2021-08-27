package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import jdk.jshell.spi.ExecutionControl;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    PlayerInformation playerInformation;
    @Autowired
    KnightRepository knightRepository;

    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);
    }


    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) throws ExecutionControl.NotImplementedException {
        knightRepository.updateKnight(knight.getId(), knight);

    }

    public int collectReward() {

        Predicate<Knight> knightPredicate = knight ->

        {
            if (knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }
        };

        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate)
                .forEach(knight -> knight.setQuest(null));
        return sum;

    }

    public void getMyGold() {

        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
                    if (knight.getQuest() != null) {
                        knight.getQuest().isCompleted();
                    }
                }
        );
        int currentGold = playerInformation.getGold();

        playerInformation.setGold(currentGold + collectReward());

    }


}
