package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.repository.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {


    @Bean(name="inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }

@Autowired
    public void securityUsers(AuthenticationManagerBuilder auth){
        auth.inMemoryAuthentication().
                withUser("user1").password("user1").role("USER")
                .and()
                .withUser("user2").password("user2").role("ADMIN");
}
}
