package com.chernenkov.xml.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XmlValidator {
    static Logger logger = LogManager.getLogger();

    String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    String fileName = "data/cards.xml";
    String schemaName = "data/cards.xsd";
    SchemaFactory factory = SchemaFactory.newInstance(language);
    File schemaLocation = new File(schemaName);
    public void validate() {
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new CardErrorHandler());
            validator.validate(source);
        } catch (FileNotFoundException e){
           logger.error("file is not found");
        }
        catch (SAXException | IOException e) {
           logger.error(fileName + " is not correct or valid");
        }
    }
}
