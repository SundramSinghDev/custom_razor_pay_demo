package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardNetworks {
    @SerializedName("AMEX")
    @Expose
    private Integer amex;
    @SerializedName("DICL")
    @Expose
    private Integer dicl;
    @SerializedName("MC")
    @Expose
    private Integer mc;
    @SerializedName("MAES")
    @Expose
    private Integer maes;
    @SerializedName("VISA")
    @Expose
    private Integer visa;
    @SerializedName("JCB")
    @Expose
    private Integer jcb;
    @SerializedName("RUPAY")
    @Expose
    private Integer rupay;
    @SerializedName("BAJAJ")
    @Expose
    private Integer bajaj;

    public Integer getAmex() {
        return amex;
    }

    public void setAmex(Integer amex) {
        this.amex = amex;
    }

    public Integer getDicl() {
        return dicl;
    }

    public void setDicl(Integer dicl) {
        this.dicl = dicl;
    }

    public Integer getMc() {
        return mc;
    }

    public void setMc(Integer mc) {
        this.mc = mc;
    }

    public Integer getMaes() {
        return maes;
    }

    public void setMaes(Integer maes) {
        this.maes = maes;
    }

    public Integer getVisa() {
        return visa;
    }

    public void setVisa(Integer visa) {
        this.visa = visa;
    }

    public Integer getJcb() {
        return jcb;
    }

    public void setJcb(Integer jcb) {
        this.jcb = jcb;
    }

    public Integer getRupay() {
        return rupay;
    }

    public void setRupay(Integer rupay) {
        this.rupay = rupay;
    }

    public Integer getBajaj() {
        return bajaj;
    }

    public void setBajaj(Integer bajaj) {
        this.bajaj = bajaj;
    }
}
