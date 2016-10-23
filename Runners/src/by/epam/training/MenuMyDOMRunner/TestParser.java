package by.epam.training.MenuMyDOMRunner;

import by.epam.training.MenuSAX.Menu;
import by.epam.training.MenuSAX.Section;
import by.epam.training.MyDOMParser.Document;
import by.epam.training.MyDOMParser.Element;
import by.epam.training.MyDOMParser.MyDOMParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 27.09.2016.
 */
// см комментарий в MenuDOM
public class TestParser {
    public static void main(String[] args) throws FileNotFoundException {
        MyDOMParser parser = new MyDOMParser();
        parser.parse("Menu.xml");
        Document document = parser.getDocument();
        Element root = document.getRootElement();
        Menu menu = new Menu();
        List<Section> coldSnacks;
        List<Section> hotSnacks;
        List<Section> breakfasts;

        Element coldSnackElement = (Element) root.getElementsByTagName("Cold-snacks").get(0);
        coldSnacks = getSections(coldSnackElement);
        Element hotSnackElement = (Element) root.getElementsByTagName("Hot-snacks").get(0);
        hotSnacks = getSections(hotSnackElement);
        Element breakfastElement = (Element) root.getElementsByTagName("Breakfast").get(0);
        breakfasts = getSections(breakfastElement);
        menu.setColdSnacks(coldSnacks);
        menu.setHotSnacks(hotSnacks);
        menu.setBreakfasts(breakfasts);
        System.out.println(menu);
    }


        private static List<Section> getSections(Element menuType) {

            List<Section> sections = new ArrayList<>();
            Section section;

            List<Element> food = menuType.getElementsByTagName("FoodDescription");
            for (int i = 0; i < food.size(); i++) {
                section = new Section();
                Element foodElement = food.get(i);
                section.setPhoto(getChildElement(foodElement, "Photo", 0).getData());
                section.setName(getChildElement(foodElement, "Name", 1).getData());
                section.setDescription(getChildElement(foodElement, "Description", 2).getData());
                section.setPortion(getChildElement(foodElement, "Portion", 3).getData());
                section.setPrice(getChildElement(foodElement, "Price", 4).getData());
                sections.add(section);
            }
            return sections;
        }
            private static Element getChildElement(Element foodElement, String name, int i)
            {
                return   foodElement.getElementsByTagName(name).get(i);
            }

}

