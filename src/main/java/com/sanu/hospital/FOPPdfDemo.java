package com.sanu.hospital;

import org.apache.fop.apps.*;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FOPPdfDemo {

    //Added to check the functionality
//    public static void main(String[] args) {
//        FOPPdfDemo fOPPdfDemo = new FOPPdfDemo();
//        try {
//            fOPPdfDemo.convertToPDF(null);
//        } catch (FOPException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (TransformerException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }


    /**
     * Method that will convert the given XML to PDF
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public void convertToPDF(String patientName) throws IOException, FOPException, TransformerException, URISyntaxException {
        // the XSL FO file
        StreamSource xsltSource = new StreamSource(getClass().getResourceAsStream("/xsl/values2fo.xsl"));
        // the XML file which provides the input
        String sourceLocation = getClass().getProtectionDomain().getCodeSource().getLocation().toExternalForm();
        String srcLocWithoutLastSlash = sourceLocation.substring(0, sourceLocation.length() - 1);
        StreamSource xmlSource = new StreamSource(srcLocWithoutLastSlash.substring(0, srcLocWithoutLastSlash.lastIndexOf("/"))+"/resources/values.xml");
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out;
        new File("PDFs").mkdirs();
        out = new java.io.FileOutputStream("PDFs/" + patientName + "-" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())+".pdf");

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsltSource);

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }

    /**
     * This method will convert the given XML to XSL-FO
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
//    public void convertToFO()  throws IOException, FOPException, TransformerException {
//        // the XSL FO file
//        File xsltFile = new File("values2fo.xsl");
//
//
//        /*TransformerFactory factory = TransformerFactory.newInstance();
//        Transformer transformer = factory.newTransformer(new StreamSource("F:\\Temp\\template.xsl"));*/
//
//        // the XML file which provides the input
//        StreamSource xmlSource = new StreamSource(new File("values.xml"));
//
//        // a user agent is needed for transformation
//        /*FOUserAgent foUserAgent = fopFactory.newFOUserAgent();*/
//        // Setup output
//        OutputStream out;
//
//        out = new java.io.FileOutputStream("F:\\Temp\\temp.fo");
//
//        try {
//            // Setup XSLT
//            TransformerFactory factory = TransformerFactory.newInstance();
//            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
//
//            // Resulting SAX events (the generated FO) must be piped through to FOP
//            //Result res = new SAXResult(fop.getDefaultHandler());
//
//            Result res = new StreamResult(out);
//
//            //Start XSLT transformation and FOP processing
//            transformer.transform(xmlSource, res);
//
//
//            // Start XSLT transformation and FOP processing
//            // That's where the XML is first transformed to XSL-FO and then
//            // PDF is created
//            transformer.transform(xmlSource, res);
//        } finally {
//            out.close();
//        }
//    }
}