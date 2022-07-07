package com.example.razor_pay_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("entity")
    @Expose
    private String entity;
    @SerializedName("card")
    @Expose
    private Boolean card;
    @SerializedName("debit_card")
    @Expose
    private Boolean debitCard;
    @SerializedName("credit_card")
    @Expose
    private Boolean creditCard;
    @SerializedName("prepaid_card")
    @Expose
    private Boolean prepaidCard;
    @SerializedName("card_networks")
    @Expose
    private CardNetworks cardNetworks;
    @SerializedName("card_subtype")
    @Expose
    private CardSubtype cardSubtype;
    @SerializedName("amex")
    @Expose
    private Boolean amex;
    @SerializedName("netbanking")
    @Expose
    private Netbanking netbanking;
    @SerializedName("wallet")
    @Expose
    private Wallet wallet;
    @SerializedName("emi")
    @Expose
    private Boolean emi;
    @SerializedName("upi")
    @Expose
    private Boolean upi;
    @SerializedName("cardless_emi")
    @Expose
    private List<Object> cardlessEmi = null;
    @SerializedName("paylater")
    @Expose
    private Paylater paylater;
    @SerializedName("google_pay_cards")
    @Expose
    private Boolean googlePayCards;
    @SerializedName("app")
    @Expose
    private App app;
    @SerializedName("gpay")
    @Expose
    private Boolean gpay;
    @SerializedName("emi_types")
    @Expose
    private EmiTypes emiTypes;
    @SerializedName("debit_emi_providers")
    @Expose
    private DebitEmiProviders debitEmiProviders;
    @SerializedName("nach")
    @Expose
    private Boolean nach;
    @SerializedName("cod")
    @Expose
    private Boolean cod;
    @SerializedName("offline")
    @Expose
    private Boolean offline;
    @SerializedName("upi_intent")
    @Expose
    private Boolean upiIntent;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Boolean getCard() {
        return card;
    }

    public void setCard(Boolean card) {
        this.card = card;
    }

    public Boolean getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(Boolean debitCard) {
        this.debitCard = debitCard;
    }

    public Boolean getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Boolean creditCard) {
        this.creditCard = creditCard;
    }

    public Boolean getPrepaidCard() {
        return prepaidCard;
    }

    public void setPrepaidCard(Boolean prepaidCard) {
        this.prepaidCard = prepaidCard;
    }

    public CardNetworks getCardNetworks() {
        return cardNetworks;
    }

    public void setCardNetworks(CardNetworks cardNetworks) {
        this.cardNetworks = cardNetworks;
    }

    public CardSubtype getCardSubtype() {
        return cardSubtype;
    }

    public void setCardSubtype(CardSubtype cardSubtype) {
        this.cardSubtype = cardSubtype;
    }

    public Boolean getAmex() {
        return amex;
    }

    public void setAmex(Boolean amex) {
        this.amex = amex;
    }

    public Netbanking getNetbanking() {
        return netbanking;
    }

    public void setNetbanking(Netbanking netbanking) {
        this.netbanking = netbanking;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Boolean getEmi() {
        return emi;
    }

    public void setEmi(Boolean emi) {
        this.emi = emi;
    }

    public Boolean getUpi() {
        return upi;
    }

    public void setUpi(Boolean upi) {
        this.upi = upi;
    }

    public List<Object> getCardlessEmi() {
        return cardlessEmi;
    }

    public void setCardlessEmi(List<Object> cardlessEmi) {
        this.cardlessEmi = cardlessEmi;
    }

    public Paylater getPaylater() {
        return paylater;
    }

    public void setPaylater(Paylater paylater) {
        this.paylater = paylater;
    }

    public Boolean getGooglePayCards() {
        return googlePayCards;
    }

    public void setGooglePayCards(Boolean googlePayCards) {
        this.googlePayCards = googlePayCards;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public Boolean getGpay() {
        return gpay;
    }

    public void setGpay(Boolean gpay) {
        this.gpay = gpay;
    }

    public EmiTypes getEmiTypes() {
        return emiTypes;
    }

    public void setEmiTypes(EmiTypes emiTypes) {
        this.emiTypes = emiTypes;
    }

    public DebitEmiProviders getDebitEmiProviders() {
        return debitEmiProviders;
    }

    public void setDebitEmiProviders(DebitEmiProviders debitEmiProviders) {
        this.debitEmiProviders = debitEmiProviders;
    }

    public Boolean getNach() {
        return nach;
    }

    public void setNach(Boolean nach) {
        this.nach = nach;
    }

    public Boolean getCod() {
        return cod;
    }

    public void setCod(Boolean cod) {
        this.cod = cod;
    }

    public Boolean getOffline() {
        return offline;
    }

    public void setOffline(Boolean offline) {
        this.offline = offline;
    }

    public Boolean getUpiIntent() {
        return upiIntent;
    }

    public void setUpiIntent(Boolean upiIntent) {
        this.upiIntent = upiIntent;
    }
}
