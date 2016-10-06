package by.epam.training.MenuStAX;

import by.epam.training.MenuSAX.Menu;
import by.epam.training.MenuSAX.Section;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 25.09.2016.
 */
public class StAXMenuParser {
    public static void main(String[] args) throws FileNotFoundException{
        XMLInputFactory inputFactory =  XMLInputFactory.newInstance();
        try {
            InputStream inputStream = new FileInputStream("Menu.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            Menu menu = process(reader);
            System.out.println(menu);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static Menu process(XMLStreamReader reader) throws XMLStreamException {
        Menu menu = new Menu();
        List<Section> coldSnacks = new ArrayList<>();
        List<Section> hotSnacks = new ArrayList<>();
        List<Section> breakfast = new ArrayList<>();
        Section section = new Section();
        MenuTagName elementname = null;
        int flag = 0;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT :
                    elementname = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementname) {
                        case COLD_SNACKS:  flag = 1; break;
                        case HOT_SNACKS:  flag = 2; break;
                        case BREAKFAST:  flag = 3; break;
                        case FOODDESCRIPTION: section = new Section();
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {break;}
                    switch (elementname){
                        case PHOTO: section.setPhoto(text); break;
                        case NAME: section.setName(text); break;
                        case DESCRIPTION: section.setDescription(text); break;
                        case PORTION: section.setPortion(text); break;
                        case PRICE: section.setPrice(text); break;

                    }
                     break;
                case XMLStreamConstants.END_ELEMENT:
                    elementname = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementname){
                        case FOODDESCRIPTION: if (flag==1) coldSnacks.add(section); if (flag==2) hotSnacks.add(section);
                        if (flag==3) breakfast.add(section);break;
                        case COLD_SNACKS: menu.setColdSnacks(coldSnacks); break;
                        case HOT_SNACKS: menu.setHotSnacks(hotSnacks); break;
                        case BREAKFAST: menu.setBreakfasts(breakfast); break;
                    }
                    break;

            }
        }
        return menu;
    }
}
