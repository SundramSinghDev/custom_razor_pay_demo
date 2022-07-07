package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paylater {
    @SerializedName("epaylater")
    @Expose
    private Boolean epaylater;
    @SerializedName("getsimpl")
    @Expose
    private Boolean getsimpl;
    @SerializedName("icic")
    @Expose
    private Boolean icic;
    @SerializedName("hdfc")
    @Expose
    private Boolean hdfc;
    @SerializedName("kkbk")
    @Expose
    private Boolean kkbk;
    @SerializedName("lazypay")
    @Expose
    private Boolean lazypay;

    public Boolean getEpaylater() {
        return epaylater;
    }

    public void setEpaylater(Boolean epaylater) {
        this.epaylater = epaylater;
    }

    public Boolean getGetsimpl() {
        return getsimpl;
    }

    public void setGetsimpl(Boolean getsimpl) {
        this.getsimpl = getsimpl;
    }

    public Boolean getIcic() {
        return icic;
    }

    public void setIcic(Boolean icic) {
        this.icic = icic;
    }

    public Boolean getHdfc() {
        return hdfc;
    }

    public void setHdfc(Boolean hdfc) {
        this.hdfc = hdfc;
    }

    public Boolean getKkbk() {
        return kkbk;
    }

    public void setKkbk(Boolean kkbk) {
        this.kkbk = kkbk;
    }

    public Boolean getLazypay() {
        return lazypay;
    }

    public void setLazypay(Boolean lazypay) {
        this.lazypay = lazypay;
    }

}
