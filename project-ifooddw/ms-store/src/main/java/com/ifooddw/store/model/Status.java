package com.ifooddw.store.model;

public enum Status {
    NEWORDER("Your order was a success."),
    ORDERREADY("Your order is on your way."),
    ORDERDELIVERED("Your order was delivered.");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
