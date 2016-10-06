package by.epam.training.MenuSAX;
/**
 * Created by Алексей on 25.09.2016.
 */
public class Section {
    private String photo ="";
    private String name="";
    private String description="";
    private String portion="";
    private String price="";

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String string = "Name: " + name +"\n" + "Description: " + description + "\n"
                + "Portion: " + portion.toString()+ "\n" + "Price: " + price+ "\n";
        return string;
    }
}
