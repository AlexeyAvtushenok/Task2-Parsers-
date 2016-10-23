package by.epam.training.MyDOMParser;

/**
 * Created by Алексей on 28.09.2016.
 */
// equaks? hashCode? toString?
public class Attribute {
    String name;// где атрибуты доступа?
    String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
