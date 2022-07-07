package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DebitEmiProviders {
    @SerializedName("HDFC")
    @Expose
    private Integer hdfc;

    public Integer getHdfc() {
        return hdfc;
    }

    public void setHdfc(Integer hdfc) {
        this.hdfc = hdfc;
    }
}
