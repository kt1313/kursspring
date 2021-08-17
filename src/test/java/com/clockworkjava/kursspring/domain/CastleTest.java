package com.clockworkjava.kursspring.domain;

import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastleTest {

    @Test
    public void castleToStringMessage() {
        Quest quest=new Quest();
        Knight knight= new Knight();
        knight.setQuest(quest);
        Castle castle=new Castle(knight, "Castle Black");
        String except = "Znajduje sie tu zamek o nazwie Castle Black. Zamieszkały przez rycerza Rycerz o imieniu Lancelot(29). Ma zadanie: Uratuj ksiezniczke.";
        assertEquals(except, castle.toString());
    }
}
