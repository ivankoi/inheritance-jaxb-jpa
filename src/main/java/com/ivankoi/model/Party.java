package com.ivankoi.model;

/**
 * Created by ivankoi on 8/30/16.
 */
public class Party{
    protected String email;

    public Party(String email) {
        this.email = email;
    }

    public Party() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Party{" +
                "email='" + email + '\'' +
                '}';
    }
}
