package com.idlerealms.social_service.domain.model;


import java.util.UUID;

public class Guild {


    private final String name;
    private long goldVault;
    private final UUID ownerId;
    private int instructorLvl;

    public String getName() {
        return name;
    }

    public int getInstructorLvl() {
        return instructorLvl;
    }

    public void setInstructorLvl(int instructorLvl) {
        this.instructorLvl = instructorLvl;
    }

    public long getGoldVault() {
        return goldVault;
    }

    public void setGoldVault(long goldVault) {
        this.goldVault = goldVault;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public Guild(String name, long goldVault, UUID ownerId, int instructorLvl) {
        this.name = name;
        this.goldVault = goldVault;
        this.ownerId = ownerId;
        this.instructorLvl = instructorLvl;
    }

    public void addGold (long amount) {
        if (amount < 0 ) {
            throw new IllegalStateException("Amount of gold must be greater than 0");
        }

        this.goldVault += amount;
    }
}