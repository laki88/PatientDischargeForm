package com.sanu.hospital;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.fop.apps.FOPException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Arrays;


public class Controller {

    @FXML
    private Label headerLabel;
    @FXML
    private Label patientLabel;
    @FXML
    private TextField patientName;
    @FXML
    private Label dateOfAdmissionLabel;
    @FXML
    private DatePicker dateOfAdmission;
    @FXML
    private Label ageLabel;
    @FXML
    private TextField age;
    @FXML
    private Label dateOfDischargeLabel;
    @FXML
    private DatePicker dateOfDischarge;
    @FXML
    private Label gLabel;
    @FXML
    private ComboBox g;
    @FXML
    private Label pLabel;
    @FXML
    private ComboBox p;
    @FXML
    private Label cLabel;
    @FXML
    private ComboBox c;
    @FXML
    private Label pogLabel;
    @FXML
    private ComboBox pogWeeks;
    @FXML
    private ComboBox pogDays;
    @FXML
    private Label bhtNoLabel;
    @FXML
    private TextField bhtNo;
    @FXML
    private Label bloodGroupLabel;
    @FXML
    private ComboBox bloodGroup;
    @FXML
    private Label lowerSegmentSectionLabel;
    @FXML
    private CheckBox elective;
    @FXML
    private CheckBox emergency;
    @FXML
    private Label indicationLabel;
    @FXML
    private TextField indication;
    @FXML
    private Label spinalDrLabel;
    @FXML
    private TextField spinalDr;
    @FXML
    private Label surgeonLabel;
    @FXML
    private TextField surgeon;
    @FXML
    private Label assistantLabel;
    @FXML
    private TextField assistant;
    @FXML
    private Label procedureAndFindingsLabel;
    @FXML
    private Label procedureAndFindingsText;
    @FXML
    private Label skinClosureWithSubCutText;
    @FXML
    private CheckBox monocryl;
    @FXML
    private CheckBox interruptedNylon;
    @FXML
    private CheckBox stepplers;
    @FXML
    private Label postOpInstructionsLabel;
    @FXML
    private TextArea postOpInstructions;
    @FXML
    private Label dateOfBirthLabel;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private Label timeOfBirthLabel;
    @FXML
    private ComboBox timeOfBirthHours;
    @FXML
    private ComboBox timeOfBirthMinutes;
    @FXML
    private Label genderLabel;
    @FXML
    private ComboBox gender;
    @FXML
    private Label birthWeightLabel;
    @FXML
    private TextField birthWeightKg;
    @FXML
    private TextField birthWeightG;
    @FXML
    private Label apgarAtBirthLabel;
    @FXML
    private ComboBox apgarAtBirth;
    @FXML
    private Label apgarAt5MinLabel;
    @FXML
    private ComboBox apgarAt5Min;
    @FXML
    private Label investigationLabel;
    @FXML
    private TextArea investigation;
    @FXML
    private Label contraceptiveAdviceLabel;
    @FXML
    private ComboBox contraceptiveAdvice;
    @FXML
    private Label hoShoLabel;
    @FXML
    private TextField hoSho;
    @FXML
    private Label dateLabel;
    @FXML
    private DatePicker date;
    @FXML
    private Label dearDrLabel;
    @FXML
    private Label removalToThisPatientOnLabel;
    @FXML
    private DatePicker removalToThisPatientOn;
    @FXML
    private Label thankYouLabel;
    @FXML
    private Label signedDoctorLabel;
    @FXML
    private Button printButton;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void handlePrinting() throws TransformerException, IOException, SAXException, ParserConfigurationException, PrintException {
        populateXMLValues();
        FOPPdfDemo.convertToPDF();

//        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
//        PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
//        patts.add(Sides.DUPLEX);
//        PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
//        if (ps.length == 0) {
//            throw new IllegalStateException("No Printer found");
//        }
//        System.out.println("Available printers: " + Arrays.asList(ps));
//
//        PrintService myService = null;
//        for (PrintService printService : ps) {
//            if (printService.getName().equals("Your printer name")) {
//                myService = printService;
//                break;
//            }
//        }
//
//        if (myService == null) {
//            throw new IllegalStateException("Printer not found");
//        }
//
//        FileInputStream fis = new FileInputStream("patientDischargeForm.pdf");
//        Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
//        DocPrintJob printJob = myService.createPrintJob();
//        printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
//        fis.close();

        resetForm();
    }

    public void populateXMLValues() throws IOException, SAXException, ParserConfigurationException, TransformerException {
        //read from XML
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse("resources/values.xml");

        //modify XML
        Node patientNameNode = doc.getElementsByTagName("patientName").item(0);
        patientNameNode.setTextContent(patientName.getText());
        Node ageNode = doc.getElementsByTagName("age").item(0);
        ageNode.setTextContent(age.getText()+" Years");
        Node dateOfAdmissionNode = doc.getElementsByTagName("dateOfAdmission").item(0);
        dateOfAdmissionNode.setTextContent(dateOfAdmission.getValue().toString());
        Node dateOfDischargeNode = doc.getElementsByTagName("dateOfDischarge").item(0);
        dateOfDischargeNode.setTextContent(dateOfDischarge.getValue().toString());
        Node gNode = doc.getElementsByTagName("g").item(0);
        gNode.setTextContent((String) g.getValue());
        Node pNode = doc.getElementsByTagName("p").item(0);
        pNode.setTextContent((String) p.getValue());
        Node cNode = doc.getElementsByTagName("c").item(0);
        cNode.setTextContent((String) c.getValue());
        Node pogNode = doc.getElementsByTagName("pog").item(0);
        pogNode.setTextContent(pogWeeks.getValue() + " + " + pogDays.getValue());
        Node bhtNoNode = doc.getElementsByTagName("bhtNo").item(0);
        bhtNoNode.setTextContent(bhtNo.getText());
        Node bloodGroupNode = doc.getElementsByTagName("bloodGroup").item(0);
        bloodGroupNode.setTextContent((String) bloodGroup.getValue());
        Node electiveNode = doc.getElementsByTagName("elective").item(0);
        setImageOnSelected(electiveNode, elective);
        Node emergencyNode = doc.getElementsByTagName("emergency").item(0);
        setImageOnSelected(emergencyNode, emergency);
        Node indicationNode = doc.getElementsByTagName("indication").item(0);
        indicationNode.setTextContent(indication.getText());
        Node spinalDrNode = doc.getElementsByTagName("spinalDr").item(0);
        spinalDrNode.setTextContent("Dr. " + spinalDr.getText());
        Node surgeonNode = doc.getElementsByTagName("surgeon").item(0);
        surgeonNode.setTextContent("Dr. " + surgeon.getText());
        Node assistantNode = doc.getElementsByTagName("assistant").item(0);
        assistantNode.setTextContent(assistant.getText());

        Node monocrylNode = doc.getElementsByTagName("monocryl").item(0);
        setImageOnSelected(monocrylNode, monocryl);
        Node interruptedNylonNode = doc.getElementsByTagName("interruptedNylon").item(0);
        setImageOnSelected(interruptedNylonNode, interruptedNylon);
        Node stepplersNode = doc.getElementsByTagName("stepplers").item(0);
        setImageOnSelected(stepplersNode, stepplers);
        Node postOpInstructionsNode = doc.getElementsByTagName("postOpInstructions").item(0);
        postOpInstructionsNode.setTextContent(postOpInstructions.getText());
        Node dateOfBirthNode = doc.getElementsByTagName("dateOfBirth").item(0);
        dateOfBirthNode.setTextContent(dateOfBirth.getValue().toString());
        Node timeOfBirthNode = doc.getElementsByTagName("timeOfBirth").item(0);
        timeOfBirthNode.setTextContent(timeOfBirthHours.getValue() +" : "+ timeOfBirthMinutes.getValue());
        Node genderNode = doc.getElementsByTagName("gender").item(0);
        genderNode.setTextContent((String) gender.getValue());
        Node birthWeightNode = doc.getElementsByTagName("birthWeight").item(0);
        birthWeightNode.setTextContent(birthWeightKg.getText() +"."+ birthWeightG.getText() +" kg");
        Node apgarAtBirthNode = doc.getElementsByTagName("apgarAtBirth").item(0);
        apgarAtBirthNode.setTextContent((String) apgarAtBirth.getValue());
        Node apgarAt5minNode = doc.getElementsByTagName("apgarAt5min").item(0);
        apgarAt5minNode.setTextContent((String) apgarAt5Min.getValue());
        Node investigationNode = doc.getElementsByTagName("investigation").item(0);
        investigationNode.setTextContent(investigation.getText());
        Node contraceptiveAdviceNode = doc.getElementsByTagName("contraceptiveAdvice").item(0);
        contraceptiveAdviceNode.setTextContent((String) contraceptiveAdvice.getValue());
        Node hoShoNode = doc.getElementsByTagName("hoSho").item(0);
        hoShoNode.setTextContent("Dr. " + hoSho.getText());
        Node dateNode = doc.getElementsByTagName("date").item(0);
        dateNode.setTextContent(date.getValue().toString());
        Node removalDateNode = doc.getElementsByTagName("removalDate").item(0);
        removalDateNode.setTextContent(removalToThisPatientOn.getValue().toString());

        //write values to XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("resources/values.xml"));
        transformer.transform(source, result);
    }


    private void setImageOnSelected(Node node, CheckBox checkBox) {
        if(checkBox.isSelected()) {
            node.setTextContent("resources/selectedCheckbox.png");
        } else {
            node.setTextContent("resources/deselectedCheckbox.png");
        }
    }

    private void resetForm() {
        patientName.setText("");
        age.setText("");
        bhtNo.setText("");
        indication.setText("");
        surgeon.setText("");
        spinalDr.setText("");
        assistant.setText("");
        postOpInstructions.setText("");
        birthWeightKg.setText("");
        birthWeightG.setText("");
        investigation.setText("");
        hoSho.setText("");
    }
}