
/*********


http://www.saxproject.org/

SAX is the Simple API for XML, originally a Java-only API.
SAX was the first widely adopted API for XML in Java, and is a �de facto� standard.
The current version is SAX 2.0.1, and there are versions for several programming language environments other than Java.

The following URL from Oracle is the JAVA documentation for the API

https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html


*********/
import org.xml.sax.InputSource;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import  java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserDataStore extends DefaultHandler {
    Laptop laptop;
    Phone phone;
    Speaker speaker;
    VoiceAssistant voiceAssistant;
    VR vr;
    Smartwatch smartwatch;
    Fitness fitness;
    Pettracker pettracker;
    Headphones headphones;

    static HashMap<String,Laptop> laptops;
    static HashMap<String,Phone> phones;
    static HashMap<String,Speaker> speakers;
    static HashMap<String,VoiceAssistant> voiceAssistants;
    static HashMap<String,VR> vrs;
    static HashMap<String,Pettracker> pettrackers;
    static HashMap<String,Fitness> fitnesss;
    static HashMap<String,Headphones> headphoness;
    static HashMap<String,Smartwatch> smartwatchs;



    String consoleXmlFileName;

    String elementValueRead;
	String currentElement="";
    public SaxParserDataStore()
	{
	}
	public SaxParserDataStore(String consoleXmlFileName) {
    this.consoleXmlFileName = consoleXmlFileName;
    laptops = new HashMap<String, Laptop>();
	phones=new  HashMap<String, Phone>();
	speakers=new HashMap<String, Speaker>();
   voiceAssistants = new HashMap<String,VoiceAssistant>();
	fitnesss=new HashMap<String, Fitness>();
  smartwatchs = new HashMap<String,Smartwatch>();
  headphoness = new HashMap<String,Headphones>();
  pettrackers = new HashMap<String,Pettracker>();
  vrs = new HashMap<String,VR>();


	parseDocument();

    }

   //parse the xml using sax parser to get the data
    private void parseDocument()
	{
  
    try {
       File inputFile = new File(consoleXmlFileName);
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(inputFile);
       doc.getDocumentElement().normalize();
       System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
       NodeList nList_laptop = doc.getElementsByTagName("laptop");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_laptop.getLength(); temp++) {
          Node nNode = nList_laptop.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             laptop = new Laptop();
             laptop.setId(eElement.getAttribute("id"));
             laptop.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             laptop.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             laptop.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             laptop.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             laptop.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          laptops.put(laptop.getId(),laptop);
       }

       //phones

       NodeList nList_phone = doc.getElementsByTagName("phone");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_phone.getLength(); temp++) {
          Node nNode = nList_phone.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             phone = new Phone();
             phone.setId(eElement.getAttribute("id"));
             phone.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             phone.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             phone.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             phone.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             phone.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          phones.put(phone.getId(),phone);
       }

       //speakers
       NodeList nList_speaker = doc.getElementsByTagName("speaker");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_speaker.getLength(); temp++) {
          Node nNode = nList_speaker.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             speaker = new Speaker();
             speaker.setId(eElement.getAttribute("id"));
             speaker.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             speaker.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             speaker.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             speaker.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             speaker.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          speakers.put(speaker.getId(),speaker);
       }

       // Voice Assistant
        NodeList nList_voice_assistant = doc.getElementsByTagName("voiceAssistant");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_voice_assistant.getLength(); temp++) {
          Node nNode = nList_voice_assistant.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             voiceAssistant = new VoiceAssistant();
             voiceAssistant.setId(eElement.getAttribute("id"));
             voiceAssistant.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             voiceAssistant.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             voiceAssistant.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             voiceAssistant.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             voiceAssistant.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          voiceAssistants.put(voiceAssistant.getId(),voiceAssistant);
       }

       //VR
       NodeList nList_vr = doc.getElementsByTagName("vr");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_vr.getLength(); temp++) {
          Node nNode = nList_vr.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             vr = new VR();
             vr.setId(eElement.getAttribute("id"));
             vr.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             vr.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             vr.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             vr.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             vr.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          vrs.put(vr.getId(),vr);
       }

       //HeadphonesList
       NodeList nList_headphones = doc.getElementsByTagName("headphone");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_headphones.getLength(); temp++) {
          Node nNode = nList_headphones.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             headphones = new Headphones();
             headphones.setId(eElement.getAttribute("id"));
             headphones.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             headphones.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             headphones.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             headphones.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             headphones.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          headphoness.put(headphones.getId(),headphones);
       }

       //Fintess
       NodeList nList_fitness = doc.getElementsByTagName("fitness");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_fitness.getLength(); temp++) {
          Node nNode = nList_fitness.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             fitness = new Fitness();
             fitness.setId(eElement.getAttribute("id"));
             fitness.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             fitness.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             fitness.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             fitness.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             fitness.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          fitnesss.put(fitness.getId(),fitness);
       }

       //SmartwatchList
       NodeList nList_smartwatch = doc.getElementsByTagName("watch");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_smartwatch.getLength(); temp++) {
          Node nNode = nList_smartwatch.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             smartwatch = new Smartwatch();
             smartwatch.setId(eElement.getAttribute("id"));
             smartwatch.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             smartwatch.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             smartwatch.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             smartwatch.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             smartwatch.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          smartwatchs.put(smartwatch.getId(),smartwatch);
       }

       //PettrackerList
       NodeList nList_pettracker = doc.getElementsByTagName("pettracker");
       System.out.println("----------------------------");

       for (int temp = 0; temp < nList_pettracker.getLength(); temp++) {
          Node nNode = nList_pettracker.item(temp);
          System.out.println("\nCurrent Element :" + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             pettracker = new Pettracker();
             pettracker.setId(eElement.getAttribute("id"));
             pettracker.setImage(eElement.getElementsByTagName("image").item(0).getTextContent());
             pettracker.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
             pettracker.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
             pettracker.setDiscount(Double.parseDouble(eElement.getElementsByTagName("discount").item(0).getTextContent()));
             pettracker.setCondition(eElement.getElementsByTagName("condition").item(0).getTextContent());
          }
          pettrackers.put(pettracker.getId(),pettracker);
       }



    } catch (Exception e) {
       e.printStackTrace();
    }
	}

 public static void addHashmap() {
		String TOMCAT_HOME = System.getProperty("catalina.home");
		new SaxParserDataStore(TOMCAT_HOME+"\\webapps\\WebStore\\ProductCatalog.xml");
    }
}
