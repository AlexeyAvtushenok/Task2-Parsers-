package by.epam.training.MyDOMParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 26.09.2016.
 */
public class Element  {
  private String name;
  private List<Attribute> attributeList;
  private String data;
  private List<Element> NodeList = new ArrayList<>();
  private Element parentElement;

  public List<Attribute> getAttributeList() {
    return attributeList;
  }

  void addToAttributeList(String attributeAndName) {
    String[] s = attributeAndName.split("=");
    Attribute attribute = new Attribute();
    attribute.setName(s[0]);
    attribute.setData(s[1]);
    attributeList.add(attribute);

  }

  public String getData() {
    return data;
  }

  void setData(String data) {
    String s = new String(data);
    this.data = s;
  }

  public List<Element> getNodeList() {
    return NodeList;
  }

  public void setNodeList(List<Element> nodeList) {
    NodeList = nodeList;
  }

  Element getParentElement() {
    return parentElement;
  }

  void setParentElement(Element parentElement) {
    this.parentElement = parentElement;
  }

 public String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  public List<Element> getElementsByTagName(String name)
  {
    List<Element> list = new ArrayList<>();
    for (Element e :NodeList) {
      if(e.getName().equals(name));
      list.add(e);
    }
    if (list.isEmpty())
    {
      throw new IllegalArgumentException();
    }
    else return list;

  }
  @Override
  public String toString() {
    return name+ "\n"+ NodeList+"\n" + data +"\n";
  }
}
