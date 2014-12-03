package com.bluemor.mvpdecoupling.bean;

public class Doter {
    private String dotaId;
    private String dotaAge;

    @Override
    public String toString() {
        return "Response -----\r\n dotaId: " + dotaId + "\r\n dotaAge: " + dotaAge;
    }

    public Doter(String dotaId, String dotaAge) {
        super();
        this.dotaId = dotaId;
        this.dotaAge = dotaAge;
    }

    public String getDotaId() {
        return dotaId;
    }

    public void setDotaId(String dotaId) {
        this.dotaId = dotaId;
    }

    public String getDotaAge() {
        return dotaAge;
    }

    public void setDotaAge(String dotaAge) {
        this.dotaAge = dotaAge;
    }

}
