package by.epam.training.MenuSAX;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 25.09.2016.
 */
public class Menu {
    private List<Section> coldSnacks = new ArrayList<>();// эм, а если бы у ная было 10 разных секций в меню, мы бы делали 10 коллекций?
    private List<Section> hotSnacks = new ArrayList<>();
    private List<Section> breakfasts = new ArrayList<>();

    public List<Section> getColdSnacks() {
        return coldSnacks;
    }

    public void setColdSnacks(List<Section> coldSnacks) {
        this.coldSnacks = coldSnacks;
    }

    public List<Section> getHotSnacks() {
        return hotSnacks;
    }

    public void setHotSnacks(List<Section> hotSnacks) {
        this.hotSnacks = hotSnacks;
    }

    public List<Section> getBreakfasts() {
        return breakfasts;
    }

    public void setBreakfasts(List<Section> breakfasts) {
        this.breakfasts = breakfasts;
    }

    @Override
    public String toString() {
        return "Menu: " + "\n"+
                "ColdSnacks: \n " + coldSnacks +
                "HotSnacks:\n" + hotSnacks +
                "Breakfasts:\n" + breakfasts;
    }
}
