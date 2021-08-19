package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
public class MainConfig {

    @Autowired
    Quest quest;

    @Bean(name="lancelot")
    @Primary
    public Knight lancelot() {
        Knight lancelot = new Knight("Lancelot", 29);
        lancelot.setQuest(quest);
        return lancelot;
    }

    @Bean(name="percival")
    public Knight createKnightBean() {
        Knight percival = new Knight("Percival", 25);
        percival.setQuest(quest);
        return percival;
    }

}