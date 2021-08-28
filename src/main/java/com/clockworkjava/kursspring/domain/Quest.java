//package com.clockworkjava.kursspring.domain;
//
//public class Quest {
//
//    private String description;
//
//    private int reward = 100;
//
//    private int lenght = 30000;
//
//    private boolean started = false;
//    private boolean completed =false;
//
//
//    public Quest(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return description;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getReward() {
//        return reward;
//    }
//
//    public void setReward(int reward) {
//        this.reward = reward;
//    }
//
//    public int getLenght() {
//        return lenght;
//    }
//
//    public void setLenght(int lenght) {
//        this.lenght = lenght;
//    }
//
//    public boolean isStarted() {
//        return started;
//    }
//
//    public void setStarted(boolean started) {
//        this.started = started;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
//
//    public void setCompleted(boolean completed) {
//        this.completed = completed;
//    }
//}
package com.clockworkjava.kursspring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Quest {

    @Id
    private int id;

    private String description;

    private int reward = 100;


    protected int lenghtInSeconds = 10;

    private boolean started = false;

    private boolean completed = false;

    protected LocalDateTime startDate;

    public Quest() {

    }

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenght() {
        return lenghtInSeconds;
    }

    public void setLenght(int lenght) {
        this.lenghtInSeconds = lenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {

        if (started) {
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {

        if (this.completed){
            return this.completed;
        }else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);
            boolean isAfter = now.isAfter(questEndDate);
            if (isAfter) {
                this.completed = true;
            }
            return isAfter;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
