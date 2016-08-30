package com.ivankoi.domain;

import javax.persistence.*;

/**
 * Created by ivankoi on 8/30/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Party {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
