package com.example.producingwebservice;

import com.refijet.lender.submission.client.soap.mortgage.mismo.DEALSETS;
import com.refijet.lender.submission.client.soap.mortgage.mismo.INDIVIDUAL;
import com.refijet.lender.submission.client.soap.mortgage.mismo.MESSAGE;
import com.refijet.lender.submission.client.soap.mortgage.mismo.MISMOString;
import com.refijet.lender.submission.client.soap.mortgage.mismo.NAME;
import com.refijet.lender.submission.client.soap.mortgage.mismo.ObjectFactory;
import com.refijet.lender.submission.client.soap.mortgage.mismo.PARTIES;
import com.refijet.lender.submission.client.soap.mortgage.mismo.PARTY;
import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Component
public class MortgageRepository {
    @PostConstruct
    public void initData() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("com.refijet.lender.submission.client.soap.mortgage.mismo");
        MESSAGE msg = new MESSAGE();

        DEALSETS dealsets = new DEALSETS();
        msg.setDEALSETS(dealsets);

        PARTIES parties = new PARTIES();
        PARTY party = new PARTY();
        parties.getPARTY().add(party);
        INDIVIDUAL individual = new INDIVIDUAL();
        party.setINDIVIDUAL(individual);
        dealsets.setPARTIES(parties);

        NAME name = new NAME();
        MISMOString mismoString = new MISMOString();
        mismoString.setValue("Some  Name");
        var factory = new ObjectFactory();
        name.setLastName(factory.createNAMELastName(mismoString));
        individual.setNAME(name);

        // create a Marshaller and marshal to a file
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(new JAXBElement(
                new QName("", "MESSAGE"), MESSAGE.class, msg), System.out);
    }

}
