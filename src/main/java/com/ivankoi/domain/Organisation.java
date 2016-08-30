package com.ivankoi.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ivankoi on 8/30/16.
 */
@Entity
public class Organisation extends Party {

    private String name;

    public Organisation() {
    }

    public Organisation(String name, String email) {
        super(email);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "name='" + name + '\'' +
                '}';
    }
}
