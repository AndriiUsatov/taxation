package mvc.controller;

import mvc.models.Payment;
import mvc.models.persons.Person;
import mvc.models.persons.PrivateIndividual;
import mvc.models.taxes.TaxesOfIndividuals;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PaymentSaver {


    private ArrayList<Payment> payments = new ArrayList<>();
    private File file;


    public PaymentSaver(String IDNumber) {
        this.file = new File("src/main/resources/" + IDNumber + ".xml");
    }

    public PaymentSaver(Payment paymentForSave) {
        payments.add(paymentForSave);
    }

    public void save() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        String path = "src/main/resources/" + payments.get(0).getPayer().getIDNumber() + ".xml";
        file = new File(path);
        if (!file.exists())
            file.createNewFile();
        else
            readFromFile();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element name = document.createElement("name");
        Text fullName = document.createTextNode(payments.get(0).getPayer().getFullName());
        name.appendChild(fullName);
        document.appendChild(name);

        for (Payment savePayment : payments) {
            Element payment = document.createElement("payment");
            name.appendChild(payment);
            Element dateElement = document.createElement("date");
            Text dateNode = document.createTextNode(Long.valueOf(savePayment.getDateOfPayment().getTime()).toString());
            Element purposeElement = document.createElement("purpose");
            Text purposeNode = document.createTextNode(Integer.valueOf(savePayment.getTax().getPurposeOfPayment()).toString());
            Element valueElement = document.createElement("value");
            Text valueNode = document.createTextNode(Double.valueOf(savePayment.getAmountOfPayment()).toString());
            payment.appendChild(dateElement);
            payment.appendChild(purposeElement);
            payment.appendChild(valueElement);
            dateElement.appendChild(dateNode);
            purposeElement.appendChild(purposeNode);
            valueElement.appendChild(valueNode);
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file)));
    }


    public void readFromFile() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element element = document.getDocumentElement();
        Text txt = (Text) element.getFirstChild();
        NodeList nodeList = element.getChildNodes();
        getElementsToArray(nodeList, txt.getData().trim(), file.getName().substring(0, 10));
    }

    private void getElementsToArray(NodeList nodeList, String fullName, String ID) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                if (((Element) nodeList.item(i)).getTagName().equals("payment")) {
                    Person tmPers = new PrivateIndividual(fullName, ID);
                    Date tmpDate = null;
                    int tmpPurpose = 0;
                    double tmpValue = 0;
                    NodeList childNodes = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        if (childNodes.item(j) instanceof Element) {
                            if (((Element) childNodes.item(j)).getTagName().equals("date")) {
                                tmpDate = new Date(Long.valueOf(((Text) childNodes.item(j).getFirstChild()).getData()));
                            }
                            if (((Element) childNodes.item(j)).getTagName().equals("purpose")) {
                                tmpPurpose = Integer.valueOf(((Text) childNodes.item(j).getFirstChild()).getData());
                            }
                            if (((Element) childNodes.item(j)).getTagName().equals("value")) {
                                tmpValue = Double.valueOf(((Text) childNodes.item(j).getFirstChild()).getData());
                            }
                        }
                    }
                    payments.add(new Payment(tmPers, new TaxesOfIndividuals(tmpPurpose), tmpDate, tmpValue));
                }
            }
        }
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }
}
