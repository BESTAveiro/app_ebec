package com.example.jmfs1.ebec.core;

/**
 * Created by root on 3/5/17.
 */

public class Team {

    // Attributes
    private String id;
    private String name;
    private int credits;
    private String code;

    public Team() {

    }

    public Team(String name, String id, int credits, String code) {
        this.name = name;
        this.id = id;
        this.credits = credits;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
