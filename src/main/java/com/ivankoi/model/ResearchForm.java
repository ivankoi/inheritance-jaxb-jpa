package com.ivankoi.model;

import javax.xml.bind.annotation.*;

/**
 * Created by ivankoi on 8/30/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Person.class, Organisation.class})
public class ResearchForm {

    @XmlElementRef
    private Party authorisingParty;

    public Party getAuthorisingParty() {
        return authorisingParty;
    }

    public void setAuthorisingParty(Party authorisingParty) {
        this.authorisingParty = authorisingParty;
    }
}
