package com.clockworkjava.kursspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Hi implements CommandLineRunner {
    @Override
    public void run (String... arg) throws Exception {
System.out.println("Hello World!!!!!!!!");
    }
}
