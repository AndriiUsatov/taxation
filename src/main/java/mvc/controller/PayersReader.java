package mvc.controller;

import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PayersReader {

    public HashMap<Long, String> read() throws IOException, SAXException, ParserConfigurationException {
        HashMap<Long, String> result = new HashMap<>();
        File[] payers = new File("src/main/resources/payers").listFiles();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        for(File file : payers) {
            Document document = builder.parse(file);
            Text txt = (Text) document.getDocumentElement().getFirstChild();
            result.put(Long.valueOf(file.getName().substring(0,10)),txt.getData().trim());
        }
        return result;
    }
}
