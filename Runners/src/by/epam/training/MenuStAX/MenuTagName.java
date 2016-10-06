package by.epam.training.MenuStAX;

/**
 * Created by Алексей on 25.09.2016.
 */
public enum MenuTagName {
    MENU, COLD_SNACKS, HOT_SNACKS, BREAKFAST, FOODDESCRIPTION, PHOTO, NAME, DESCRIPTION, PORTION, PRICE;
    public static MenuTagName getElementTagName (String element){
        switch (element){
            case "Menu": return MENU;
            case "Cold-snacks" : return COLD_SNACKS;
            case "Hot-snacks" : return HOT_SNACKS;
            case "Breakfast": return BREAKFAST;
            case "FoodDescription" : return FOODDESCRIPTION;
            case "Photo" : return PHOTO;
            case "Name" : return NAME;
            case "Description" : return DESCRIPTION;
            case "Portion" : return PORTION;
            case "Price" : return PRICE;
            default: throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }

    }
}
