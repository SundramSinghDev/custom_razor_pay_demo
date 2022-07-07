package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class App {
    @SerializedName("cred")
    @Expose
    private Integer cred;
    @SerializedName("twid")
    @Expose
    private Integer twid;
    @SerializedName("trustly")
    @Expose
    private Integer trustly;
    @SerializedName("poli")
    @Expose
    private Integer poli;
    @SerializedName("sofort")
    @Expose
    private Integer sofort;
    @SerializedName("giropay")
    @Expose
    private Integer giropay;

    public Integer getCred() {
        return cred;
    }

    public void setCred(Integer cred) {
        this.cred = cred;
    }

    public Integer getTwid() {
        return twid;
    }

    public void setTwid(Integer twid) {
        this.twid = twid;
    }

    public Integer getTrustly() {
        return trustly;
    }

    public void setTrustly(Integer trustly) {
        this.trustly = trustly;
    }

    public Integer getPoli() {
        return poli;
    }

    public void setPoli(Integer poli) {
        this.poli = poli;
    }

    public Integer getSofort() {
        return sofort;
    }

    public void setSofort(Integer sofort) {
        this.sofort = sofort;
    }

    public Integer getGiropay() {
        return giropay;
    }

    public void setGiropay(Integer giropay) {
        this.giropay = giropay;
    }
}
