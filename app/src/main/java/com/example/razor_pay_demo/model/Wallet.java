package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wallet {
    @SerializedName("mobikwik")
    @Expose
    private Boolean mobikwik;
    @SerializedName("payzapp")
    @Expose
    private Boolean payzapp;
    @SerializedName("olamoney")
    @Expose
    private Boolean olamoney;
    @SerializedName("airtelmoney")
    @Expose
    private Boolean airtelmoney;
    @SerializedName("freecharge")
    @Expose
    private Boolean freecharge;
    @SerializedName("jiomoney")
    @Expose
    private Boolean jiomoney;

    public Boolean getMobikwik() {
        return mobikwik;
    }

    public void setMobikwik(Boolean mobikwik) {
        this.mobikwik = mobikwik;
    }

    public Boolean getPayzapp() {
        return payzapp;
    }

    public void setPayzapp(Boolean payzapp) {
        this.payzapp = payzapp;
    }

    public Boolean getOlamoney() {
        return olamoney;
    }

    public void setOlamoney(Boolean olamoney) {
        this.olamoney = olamoney;
    }

    public Boolean getAirtelmoney() {
        return airtelmoney;
    }

    public void setAirtelmoney(Boolean airtelmoney) {
        this.airtelmoney = airtelmoney;
    }

    public Boolean getFreecharge() {
        return freecharge;
    }

    public void setFreecharge(Boolean freecharge) {
        this.freecharge = freecharge;
    }

    public Boolean getJiomoney() {
        return jiomoney;
    }

    public void setJiomoney(Boolean jiomoney) {
        this.jiomoney = jiomoney;
    }
}
