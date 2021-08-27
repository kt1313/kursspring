//package com.clockworkjava.kursspring.domain;
//
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
////import org.hibernate.validator.constraints.Range;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Objects;
//
//public class Knight {
//
//    private int id;
//    @NotNull
//@Size(min = 2, max = 40, message = "Imie musi zawierac min2 i max 40 znakow")
//    private String name;
//
//    @NotNull
//
//    @Min(value = 18, message = "Wiek musi byc wiekszy od 18 lat")
//    @Max(value = 60, message = "Wiek musi byc mniejszy od 60 lat")
//    private int age;
//    private int level = 1;
//
//    private Quest quest;
//
//
//    public Knight() {
//
//    }
//
//    public Knight(String name, int age) {
//        this.name = name;
//        this.age = age;
//        this.level = 1;
//
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Knight knight = (Knight) o;
//        return age == knight.age;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age);
//    }
//
//    public void setQuest(Quest quest) {
//        System.out.println("Ustawiam zadanie dla rycerza.");
//        this.quest = quest;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getAge() {
//        return this.age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getLevel() {
//        return level;
//    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }
//
//    @Override
//    public String toString() {
//        return "Rycerz o imieniu " + name + "(" + age + "). Ma za zadanie: " + quest;
//    }
//}
package com.clockworkjava.kursspring.domain;

//import org.hibernate.validator.constraints.Range;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Knight {

    private int id;

    @NotNull
    @Size(min=2, max=40,message = "Imie rycerza musi miec miedzy 2, a 40 znakow")
    private String name;

    @NotNull
//    @Min(value = 18, message = "Wiek musi byc 18><60")
//    @Max(value = 60, message = "Wiek musi byc 18><60")
    @Range(min=18, max=60, message = "Rycerz musi miec conajmniej 18 lat, a nie wiecej niz 60")
    private int age;


    private int level;

    private Quest quest;

    public Knight() {
        this.level = 1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }



    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        quest.setStarted(true);
        this.quest = quest;
    }
    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + "(" + age + "). Ma za zadanie: " + quest;
    }
}
