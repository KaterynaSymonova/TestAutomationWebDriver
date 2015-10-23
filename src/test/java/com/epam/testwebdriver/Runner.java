package com.epam.testwebdriver;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Kateryna_Symonova on 10/8/2015.
 */
public class Runner {

    public static final String TESTNG_XML = "./testng.xml";

    public static void main(String [] args ) throws IOException, SAXException, ParserConfigurationException {
        TestNG testNG = new TestNG();
        for (XmlSuite suite:new Parser(TESTNG_XML).parseToList()){
            testNG.setCommandLineSuite(suite);
        }
        testNG.run();
    }
}
