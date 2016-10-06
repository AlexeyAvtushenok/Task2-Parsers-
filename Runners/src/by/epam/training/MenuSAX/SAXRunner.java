package by.epam.training.MenuSAX;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Created by Алексей on 25.09.2016.
 */
public class SAXRunner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("Menu.xml"));
        Menu menu= handler.getMenu();
        System.out.println(menu);


    }
}
