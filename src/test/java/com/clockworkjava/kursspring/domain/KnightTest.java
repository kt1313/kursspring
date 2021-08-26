package com.clockworkjava.kursspring.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {


    public void testIfQuestMarkedAsStarted(){

        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest("Testowe zadanie");

        knight.setQuest(quest);

        assertTrue(knight.getQuest().isStarted());


    }
}
