//package com.clockworkjava.kursspring.services;
//
//import com.clockworkjava.kursspring.domain.Quest;
//import com.clockworkjava.kursspring.domain.repository.QuestRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnit;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsInAnyOrder;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnit.class)
//public class QuestServiceTests {
//
//    @Mock
//    QuestRepository repositoryMock;
//
//    public void returnsNotSTartedQUests() {
//
//        @Test
//        public void returnsNotStartedQuests () {
//            when(repositoryMock.getAll().thenReturn());
//
//            List<Quest> quests = new ArrayList<>();
//            Quest q1 = new Quest("Test  quest q1");
//            Quest q2 = new Quest("Test  quest q2");
//            Quest q3 = new Quest("Test  quest q3");
//
//            q2.setStarted(true);
//
//            quests.add(q1);
//            quests.add(q2);
//            quests.add(q3);
//
//
//            when(repositoryMock.getAll().thenReturn(quests));
//
//            QuestService qs = new QuestService();
//
//            qs.setQuestRepository(repositoryMock);
//
//            List<Quest> allNotSTartedQuests = qs.getAllNotSTartedQuests();
//
//            assertEquals("Size of returned quests", 2, allNotSTartedQuests.size());
//            assertThat(allNotSTartedQuests, containsInAnyOrder(q1, q3));
//
//
//        }
//
//    }
package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTests {

    @Mock
    QuestRepository repositoryMock;

    @Test
    public void returnsNotStartedQuests() {

        List<Quest> quests = new ArrayList<>();
        Quest q1 = new Quest(1, "Test quest 1");
        Quest q2 = new Quest(2, "Test quest 2");
        Quest q3 = new Quest(3, "Test quest 3");

        q2.setStarted(true);

        quests.add(q1);
        quests.add(q2);
        quests.add(q3);


        when(repositoryMock.getAll()).thenReturn(quests);

        QuestService qs = new QuestService();

        qs.setQuestRepository(repositoryMock);

        List<Quest> allNotStartedQuests = qs.getAllNotStartedQuests();

        assertEquals("Size of returned quest", 2, allNotStartedQuests.size());
        assertThat(allNotStartedQuests, containsInAnyOrder(q1,q3));
    }
}
