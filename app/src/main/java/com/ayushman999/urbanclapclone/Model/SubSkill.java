package com.ayushman999.urbanclapclone.Model;

public class SubSkill {
    private String subskill;
    private int rate;

    public SubSkill(String subskill, int rate) {
        this.subskill = subskill;
        this.rate = rate;
    }

    public SubSkill() {
    }

    public String getSubskill() {
        return subskill;
    }

    public void setSubskill(String subskill) {
        this.subskill = subskill;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
