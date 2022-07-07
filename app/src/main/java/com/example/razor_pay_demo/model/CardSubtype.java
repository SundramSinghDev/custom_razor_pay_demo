package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardSubtype {
    @SerializedName("consumer")
    @Expose
    private Integer consumer;
    @SerializedName("business")
    @Expose
    private Integer business;
    @SerializedName("premium")
    @Expose
    private Integer premium;

    public Integer getConsumer() {
        return consumer;
    }

    public void setConsumer(Integer consumer) {
        this.consumer = consumer;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public Integer getPremium() {
        return premium;
    }

    public void setPremium(Integer premium) {
        this.premium = premium;
    }
}
