package by.epam.training.MyDOMParser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алексей on 27.09.2016.
 */
public class MyDOMParser {
    private Document document;
    private String header;

    public Document getDocument(){
        return Document.getDocument();
    }
    public void parse(String location) {
        document = getDocument();
        try {
            getInformationFromFile(location, document);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }

    }

    private static StringBuilder getInformationFromFile(String location, Document document) throws FileNotFoundException {
        File file = new File(location);

        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
            StringBuilder sb = new StringBuilder();
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            Element parentElement = new Element();


        StringBuilder flag = new StringBuilder("0");
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                   // if(isOpenTagCorrect(sb)||isCloseTagCorrect(sb)||isTextCorrect(sb))
                    parentElement = elementLogic(sb, document, parentElement, flag);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb;
    }
    private static Element elementLogic(StringBuilder sb, Document document, Element parentElement, StringBuilder flag){
        Element element = new Element();
        Pattern pattern = Pattern.compile("<([^/].*?)(( +?.*?=.*?)*?)>");
        Matcher matcher = pattern.matcher(sb.toString());
        Pattern pattern1 = Pattern.compile("</(.*?)(( +?.*?=.*?)*?)>");
        Matcher matcher1 = pattern1.matcher(sb.toString());
        Pattern pattern2 = Pattern.compile("([^\\s<])([А-Яа-яёЁ\\d\\s\\\\.,/]+)");
        Matcher matcher2 = pattern2.matcher(sb.toString());
        if ( matcher.find())
        {
            if (document.getRootElement() == null) {
                element.setName(matcher.group(1));
                for (int i =2; i < matcher.groupCount()-2; i++)
                {
                    element.addToAttributeList(matcher.group(i));
                }
                document.setRootElement(element);
                parentElement = element;
                deleteBuilder(sb);
                return parentElement;
                }
            else

            {   element = new Element();
                element.setName(matcher.group(1));
                for (int i =2; i < matcher.groupCount()-2; i++)
                {
                    element.addToAttributeList(matcher.group(i));
                }
                element.setParentElement(parentElement);
                parentElement.getNodeList().add(element);
                if (flag.toString().equals("0"))
                parentElement = element;
                deleteBuilder(sb);

            }
        }

        if ( matcher2.find()){
            if (sb.toString().equals(""))
                return parentElement;
            flag = new StringBuilder("1");
            element = parentElement;
            parentElement = element.getParentElement();
            element.setParentElement(parentElement);
            element.setData(matcher2.group());
            deleteBuilder(sb);
        }
        if (matcher1.find())
        {
            if(matcher1.group(1).equals(parentElement.getName()))
                parentElement=parentElement.getParentElement();
            flag = new StringBuilder("0");
            deleteBuilder(sb);


        }

    return parentElement;

    }
    private static void deleteBuilder(StringBuilder stringBuilder){
    stringBuilder.delete(0,stringBuilder.length());
    }
    private static boolean isOpenTagCorrect(StringBuilder stringBuilder){
        Pattern pattern = Pattern.compile("<([^/].*?)(( +?.*?=.*?)*?)>");
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        return matcher.find();

    }
    private static boolean isCloseTagCorrect(StringBuilder stringBuilder){
        Pattern pattern = Pattern.compile("</(.*?)(( +?.*?=.*?)*?)>");
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        return matcher.find();
    }
    private static boolean isTextCorrect(StringBuilder stringBuilder) {
        Pattern pattern = Pattern.compile("(^[^\\s<])([А-Яа-яёЁ\\d\\s\\\\.,/]+)");
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        return matcher.find();
    }
}
