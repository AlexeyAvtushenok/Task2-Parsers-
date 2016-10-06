package by.epam.training.MenuSAX;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Алексей on 25.09.2016.
 */
public class MenuSaxHandler extends DefaultHandler {
    private Menu menu = new Menu();
    private List<Section> coldSnacks;
    private List<Section> hotSnacks;
    private List<Section> breakfasts;
    private Section section;
    private StringBuilder text;
    private int flag;

    public Menu getMenu(){
        return menu;
    }
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

       text = new StringBuilder();
        if (qName.equals("Cold-snacks"))
        {coldSnacks = new ArrayList<>();
            flag =1;}
        if (qName.equals("Hot-snacks")) {
            hotSnacks = new ArrayList<>();
            flag = 2;
        }
        if (qName.equals("Breakfast")){
            breakfasts = new ArrayList<>();
        flag = 3;}
        if (qName.equals("FoodDescription"))
            section = new Section();

    }

    public void characters(char[] ch, int start, int length) throws SAXException{
        text.append(ch, start, length);
    }
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
    MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName){
            case PHOTO: section.setPhoto(text.toString().trim()); break;
            case NAME: section.setName(text.toString().trim());break;
            case DESCRIPTION: section.setDescription(text.toString().trim());break;
            case PORTION: section.setPortion(text.toString().trim());break;
            case PRICE: section.setPrice(text.toString().trim());break;
            case FOODDESCRIPTION: if (flag==1)coldSnacks.add(section); if (flag ==2) hotSnacks.add(section);
                if (flag==3) breakfasts.add(section); break;
            case COLD_SNACKS: menu.setColdSnacks(coldSnacks);break;
            case HOT_SNACKS: menu.setHotSnacks(hotSnacks); break;
            case BREAKFAST: menu.setBreakfasts(breakfasts); break;
        }

    }




}

