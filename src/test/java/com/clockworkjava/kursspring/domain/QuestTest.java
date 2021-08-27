package com.clockworkjava.kursspring.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate(){

        Quest quest= new               Quest(1, "Testowe zadanie");

        quest.setStarted(true);

        assertNotNull (quest.startDate);
    }
    @Test
    public void questShouldBeCompleted(){

        Quest quest=new Quest(1, "Testowe zadanie");

        quest.setStarted(true);
        quest.lenghtInSeconds=-5;
        assertTrue(quest.isCompleted());
        assertTrue(quest.isCompleted());

    }

    @Test
    public void questShouldNotBeCompleted(){
        Quest quest=new Quest(1, "Testowe zadanie");

        quest.setStarted(true);
        quest.lenghtInSeconds=2000;
        assertFalse(quest.isCompleted());

    }
}
