package org.example.Classes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private float limit, balance;
    private List<Purchase> purchaseList;

    public CreditCard(float limit) {
        this.limit = limit;
        this.balance = limit;
        this.purchaseList = new ArrayList<>();
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public float getLimit() {
        return limit;
    }

    public float getBalance() {
        return balance;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "limit=" + limit +
                ", balance=" + balance +
                ", purchaseList=" + purchaseList +
                '}';
    }
}