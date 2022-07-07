package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmiTypes {
    @SerializedName("credit")
    @Expose
    private Boolean credit;
    @SerializedName("debit")
    @Expose
    private Boolean debit;

    public Boolean getCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public Boolean getDebit() {
        return debit;
    }

    public void setDebit(Boolean debit) {
        this.debit = debit;
    }
}
