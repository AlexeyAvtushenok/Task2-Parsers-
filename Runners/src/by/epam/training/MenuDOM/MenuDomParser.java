package by.epam.training.MenuDOM;

import by.epam.training.MenuSAX.Menu;
import by.epam.training.MenuSAX.Section;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

/**
 * Created by Алексей on 26.09.2016.
 */
public class MenuDomParser {
    public static void main(String[] args) throws IOException, SAXException {
        DOMParser domParser = new DOMParser();
        domParser.parse("Menu.xml");
        Document document = domParser.getDocument();
        Element root = document.getDocumentElement();
        Menu menu = new Menu();
        List<Section> coldSnacks;
        List<Section> hotSnacks;
        List<Section> breakfasts;

        Element coldSnackElement =  (Element)root.getElementsByTagName("Cold-snacks").item(0);
        coldSnacks = getSections(coldSnackElement);
        Element hotSnackElement =  (Element)root.getElementsByTagName("Hot-snacks").item(0);
        hotSnacks = getSections(hotSnackElement);
        Element breakfastElement = (Element)root.getElementsByTagName("Breakfast").item(0);
        breakfasts = getSections(breakfastElement);
        menu.setColdSnacks(coldSnacks);
        menu.setHotSnacks(hotSnacks);
        menu.setBreakfasts(breakfasts);
        System.out.println(menu);

    }
    private static List<Section> getSections(Element menuType){

        List<Section> sections = new ArrayList<>();
Section section;

        NodeList food =  menuType.getElementsByTagName("FoodDescription");
        for (int i = 0; i < food.getLength(); i++)
        {section = new Section();
            Element foodElement = (Element) food.item(i);
            section.setPhoto(getChildElement(foodElement, "Photo").getTextContent().trim());
            section.setName(getChildElement(foodElement, "Name").getTextContent().trim());
            section.setDescription(getChildElement(foodElement, "Description").getTextContent().trim());
            section.setPortion(getChildElement(foodElement, "Portion").getTextContent().trim());
            section.setPrice(getChildElement(foodElement, "Price").getTextContent().trim());
            sections.add(section);
        }
        return sections;
    }
    private static Element getChildElement(Element foodElement, String name)
    {
       return  (Element) foodElement.getElementsByTagName(name).item(0);
    }



}

