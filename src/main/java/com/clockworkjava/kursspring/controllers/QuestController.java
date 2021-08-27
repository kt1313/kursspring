package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.services.QuestService;
import jdk.dynalink.linker.LinkerServices;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.clockworkjava.kursspring.services.KnightService;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);


        return "assignQuest";


    }

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String assignQuest(Knight knight) throws ExecutionControl.NotImplementedException {
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.update(quest);
        return "redirect:/knights";


    }

    @RequestMapping(value = "/checkQuests")
    public String checkQuests() {

        List<Knight> allKnights = knightService.getAllKnights();
        allKnights.forEach(knight -> knight.getQuest().isCompleted());

        int currentGold = playerInformation.getGold();

        playerInformation.setGold(currentGold+knightService.collectReward());

        return "redirect:/knights";

    }
}
