package com.clockworkjava.kursspring.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
public class PlayerInformation {



private int gold=0;
    private String id;

    public int getGold(){
    return gold;
}

public void setGold(int gold){
    this.gold=gold;
}

    public PlayerInformation() {
            }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }
}
