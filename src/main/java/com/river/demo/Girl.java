package com.river.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Girl {

    @Autowired
    private Outfit outfit;

    @PostConstruct
    public void postConstruct(){
        System.out.println("Instance of Girl AFTER initialization will run this method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Instance of Girl BEFOR destroy will run this method");
    }

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
