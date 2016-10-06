package by.epam.training.MyDOMParser;

/**
 * Created by Алексей on 26.09.2016.
 */
public class Document {
    private static  Document INSTANCE;
    private Document(){};
    static Document getDocument() {
        if (INSTANCE == null) {
            INSTANCE = new Document();
        }
        return INSTANCE;
    }
    private Element rootElement;
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
