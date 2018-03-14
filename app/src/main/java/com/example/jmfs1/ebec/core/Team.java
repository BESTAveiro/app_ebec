package com.example.jmfs1.ebec.core;

import java.util.List;

/**
 * Created by root on 3/5/17.
 */

public class Team {

    // Attributes
    private int id;
    private String password;
    private String name;
    private int credits;
    private String code;
    private String modality;
    private List<String> participants;
    private List<MiniCompetition> mini_competitions;

    public Team() {

    }

    public Team(int id, String password, String name, int credits, String code, String modality,
                List<String> participants, List<MiniCompetition> mini_competitions) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.credits = credits;
        this.code = code;
        this.modality = modality;
        this.participants = participants;
        this.mini_competitions = mini_competitions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public List<MiniCompetition> getMini_competitions() {
        return mini_competitions;
    }

    public void setMini_competitions(List<MiniCompetition> mini_competitions) {
        this.mini_competitions = mini_competitions;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
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
