package com.ivankoi;

import com.ivankoi.model.Organisation;
import com.ivankoi.model.Party;
import com.ivankoi.model.Person;
import com.ivankoi.model.ResearchForm;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ivankoi on 8/30/16.
 */
public class XmlBinderTest {

    public static final String XML_FILE_PATH = "researchForm.xml";

    @Test
    public void testMarshalThenUnmarshallerWithPerson() throws JAXBException {
        ResearchForm originalForm = new ResearchForm();
        originalForm.setAuthorisingParty(new Person("ivan", "ivankovic", "ivankoi@gmail.com"));

        marshal(originalForm);
        ResearchForm fromDiskForm = unmarshal(XML_FILE_PATH, ResearchForm.class);

        assertThat(originalForm.getAuthorisingParty().toString(), equalTo(fromDiskForm.getAuthorisingParty().toString()));
    }

    @Test
    public void testMarshalThenUnmarshallerWithOrganisation() throws JAXBException {
        ResearchForm originalForm = new ResearchForm();
        originalForm.setAuthorisingParty(new Organisation("Very good company", "vg@me.com"));

        marshal(originalForm);
        ResearchForm fromDiskForm = unmarshal(XML_FILE_PATH, ResearchForm.class);

        assertThat(originalForm.getAuthorisingParty().toString(), equalTo(fromDiskForm.getAuthorisingParty().toString()));
    }

    private ResearchForm unmarshal(String xmlFilePath, Class clasz) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clasz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ResearchForm researchForm = (ResearchForm) jaxbUnmarshaller.unmarshal(new File(xmlFilePath));
        return researchForm;
    }

    private void marshal(ResearchForm researchFrom) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ResearchForm.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(researchFrom, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(researchFrom, new File(XML_FILE_PATH));
    }
}
