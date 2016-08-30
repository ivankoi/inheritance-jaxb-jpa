package com.ivankoi.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Created by ivankoi on 8/30/16.
 */
@Entity
public class ResearchForm {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Party authorisingParty;

    public Party getAuthorisingParty() {
        return authorisingParty;
    }

    public void setAuthorisingParty(Party authorisingParty) {
        this.authorisingParty = authorisingParty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
