package com.example.jmfs1.ebec.core;

import java.util.List;

/**
 * Created by root on 3/5/17.
 */

public class TeamData {

    // Attributes
    private String id;
    private String password;
    private String modality;
    private List<String> participants;
    private List<MiniCompetition> mini_competitions;

    public TeamData() {

    }

    public TeamData(String id, String password, List<String> participants, String modality,
                    List<MiniCompetition> mini_competitions) {
        this.id = id;
        this.password = password;
        this.participants = participants;
        this.modality = modality;
        this.mini_competitions = mini_competitions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
