package com.github.kamilcieslik.academic.time_bank_backend.db_file_read_write;

import com.github.kamilcieslik.academic.time_bank_backend.TimeBankApplication;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DatabaseXmlParser {
    public static Database readFromXmlFile() throws JAXBException {
        File file = new File(TimeBankApplication.DATABASE_PATH);
        JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        try {
            return (Database) jaxbUnmarshaller.unmarshal(file);
        }
        catch (UnmarshalException e) {
            if (e.getCause()!=null && e.getCause() instanceof FileNotFoundException)
                return new Database();
            else
                throw e;
        }
    }

    public static void writeToXmlFile(Database wishTemplate) throws JAXBException {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(Database.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(wishTemplate, new File(TimeBankApplication.DATABASE_PATH));
    }
}
