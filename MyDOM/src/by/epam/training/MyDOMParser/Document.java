package by.epam.training.MyDOMParser;

/**
 * Created by Алексей on 26.09.2016.
 */
public class Document {
    private static  Document INSTANCE;
    private Document(){};
    static Document getDocument() {// у метода потерян атрибут доступа
        // и зачем этот класс делать singleton?
        // ты что, парсить единственный файл собираешься за всю работу программы, и два документа сразу даже понадобится не могут?
        if (INSTANCE == null) {
            INSTANCE = new Document();
        }
        return INSTANCE;
    }
    private Element rootElement;// почитай code convention, и не путай где и что располагать
    private String header;

    public String getHeader() {return header;}
    public void setHeader(String header) {
        this.header = header;
    }

    public void setRootElement(Element rootElement) {
        this.rootElement = rootElement;
    }
    public Element getRootElement() {
        return rootElement;
    }

}
