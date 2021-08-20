package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KursspringApplicationTests {

    @Autowired
    Knight knight;
    @Autowired
    KnightRepository knightRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCastle() {
        String except = "Znajduje sie tu zamek o nazwie Castle BlackZamieszkały przez rycerza Rycerz o imieniu Lancelot(29).";
        assertEquals(except, knightRepository.toString());
    }
}
