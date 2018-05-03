package com.github.kamilcieslik.academic.time_bank_backend.db_file_read_write;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DatabaseXmlParser {
    private static DatabaseXmlParser instance = null;
    private String databasePath;

    private DatabaseXmlParser(String databasePath) {
        this.databasePath = databasePath;
    }

    public static DatabaseXmlParser getInstance(String databasePath) {
        if (instance == null)
            instance = new DatabaseXmlParser(databasePath);

        return instance;
    }

    public Database readFromXmlFile() throws JAXBException {
        File file = new File(databasePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Database) jaxbUnmarshaller.unmarshal(file);
    }

    public void writeToXmlFile(Database wishTemplate) throws JAXBException {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(Database.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(wishTemplate, new File(databasePath));
    }
}
