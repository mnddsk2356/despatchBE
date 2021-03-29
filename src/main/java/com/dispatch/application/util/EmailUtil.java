package com.dispatch.application.util;

import com.dispatch.application.model.AgreementRequest;
import com.itextpdf.io.font.FontConstants;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFontFactory;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;


import com.itextpdf.text.pdf.draw.LineSeparator;
import org.springframework.core.io.ClassPathResource;

public class EmailUtil {

    public static void sendAgreement(AgreementRequest agreementRequest) {
        String smtpHost = "smtp.gmail.com"; //replace this with a valid host
        int smtpPort = 587; //replace this with a valid port

        String sender = "moinamazon123@gmail.com"; //replace this with a valid sender email address
        String recipient = agreementRequest.getTransporterCompEmail(); //replace this with a valid recipient email address
        String content = "Dear "+agreementRequest.getTransporterComp()+"\n"+"Please Find your Attached Agreement"; //this will be the text of the email
        String subject = "Agreement"; //this will be the subject of the email
        String password = "bobbyshaik@1234";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender,password);
                    }
                });

        ByteArrayOutputStream outputStream = null;

        try {
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(content);

            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            //writePdf(outputStream);
           // writePdf();
            writeHeaderFooterPdf(agreementRequest);
            String  path = "/Agreement.pdf";
                String uploadDir = "uploads/company/" +agreementRequest.getShipperId()+"/Agreement/"+agreementRequest.getTransporterComp()+path;


           // byte[] bytes = outputStream.toByteArray();

            byte[] bytes = Files.readAllBytes(Paths.get(uploadDir));

            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("Agreement.pdf");

            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);

            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(sender);
            InternetAddress iaRecipient = new InternetAddress(recipient);

            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(subject);
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);

            //send off the email
            Transport.send(mimeMessage);



            System.out.println("sent from " + sender +
                    ", to " + recipient +
                    "; server = " + smtpHost + ", port = " + smtpPort);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if(null != outputStream) {
                try { outputStream.close(); outputStream = null; }
                catch(Exception ex) { }
            }
        }
    }
   /* public static void writePdf() throws Exception {
//        Document document = new Document();
//        PdfWriter.getInstance(document, outputStream);
//        document.open();
//        Paragraph paragraph = new Paragraph();
//        paragraph.add(new Chunk("hello!"));
//        document.add(paragraph);

       // String path = System.getProperty("user.dir");
       String  path = "/Agreement.pdf";
        String uploadDir = "uploads/company/" +path;
        // Creating a PdfWriter object using the path
        PdfWriter writer = new PdfWriter(uploadDir);

        // Creating a PdfDocument object
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Creating a Document object
        Document doc = new Document(pdfDoc);

// Creating an ImageData object

        File resource = new ClassPathResource("logo.png").getFile();
        ImageData data = ImageDataFactory.create(resource.getAbsolutePath());

        // Creating an Image object
        Image img = new Image(data);
        // Setting the position of the image to the center of the page
        //img.setFixedPosition(10, 20);
        img.setHeight(50);
        img.setWidth(50);

        //Adding text to the document
        Text text1 = new Text("Tutorials Point originated from the idea that there exists"+
                "a class of readers who respond better to online content and prefer to"+
                "learn new skills at their own pace from the comforts of their drawing rooms.");

        //Setting color to the text
        text1.setFontColor(ColorConstants.GREEN);

        //Setting font to the text
        text1.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));

        //Creating a paragraph 1
        Paragraph para1 = new Paragraph(text1);

        Text text2 = new Text("The journey commenced with a single tutorial on HTML in 2006"+
                "and elated by the response it generated, we worked our way to adding fresh"+
                "tutorials to our repository which now proudly flaunts a wealth of tutorials and"+
                "allied articles on topics ranging from programming languages to web designing to"+
                "academics and much more.");

                //Setting color to the text
                text2.setFontColor(ColorConstants.RED);

        //Setting font to the text
        text2.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));

        //Creating a paragraph 2
        Paragraph para2 = new Paragraph(text2);

        // Adding image to the document
        doc.add(img);
        //Adding paragraphs to the document
        doc.add(para1);
        doc.add(para2);



        //Closing the document
        doc.close();
        System.out.println("Text added successfully..");



    }*/

    public static void writeHeaderFooterPdf(AgreementRequest agreementRequest) throws FileNotFoundException, DocumentException {

        String  path = "/Agreement.pdf";
        String uploadDir = "uploads/company/" +agreementRequest.getShipperId()+"/Agreement/"+agreementRequest.getTransporterComp()+path;
        // create document
        Document document = new Document(PageSize.A4, 36, 36, 90, 36);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(uploadDir));

        // add header and footer
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);

        // write to document
        document.open();
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("                                                      Service Agreement"));
        // Creating a Line object
        LineSeparator ls = new LineSeparator();
        document.add(new Chunk(ls));
        document.add(new Paragraph("THIS GENERAL SERVICE AGREEMENT (the \"Agreement\") is dated on :"+new Date()));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("THIS is to certify "+agreementRequest.getTransporterComp()+" will provide "+agreementRequest.getTripAssigned()+" trips from date "+agreementRequest.getFromDate()+" to "+agreementRequest.getToDate()+" from "+agreementRequest.getSource()+" to "+agreementRequest.getDestination()+"."));
        document.add(new Paragraph("Along with shippment drop with specified location that comes between source to target."));
        document.add(new Paragraph("For this service "+agreementRequest.getTransporterComp()+" will paid "+agreementRequest.getTripAssigned() * agreementRequest.getAmount().intValue()+"  INR. Any loss or damage to Material will be pay by transporter ."));
        rectMargin(writer);
        rect(writer);
        Paragraph para1 = new Paragraph("Yours Faithfully");
        para1.setAlignment(Paragraph.ALIGN_RIGHT);
        para1.setSpacingAfter(50);
        document.add(para1);
        Paragraph para2 = new Paragraph("Raghav Mittal");
        para2.setAlignment(Paragraph.ALIGN_RIGHT);
        //para2.setSpacingAfter(50);
        document.add(para2);

        Paragraph para3 = new Paragraph("CEO , Company Name , Address");
        para3.setAlignment(Paragraph.ALIGN_RIGHT);
       // para3.setSpacingAfter(50);
        document.add(para3);

        document.newPage();
        rectMargin(writer);
        document.add(new Paragraph("Adding a footer to PDF Document using iText."));
        document.close();
    }



    public static void main(String[] args) {
        //email();
    }

    public static void rectMargin(PdfWriter writer) {

        PdfContentByte cb = writer.getDirectContent();
        try {
            cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 14);
            cb.saveState();
            cb.setColorStroke(new CMYKColor(1f, 0f, 0f, 0f));
            cb.setColorFill(new CMYKColor(1f, 0f, 0f, 0f));
            cb.rectangle(20,10,10,820);
            cb.fill();
            cb.restoreState();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rect(PdfWriter writer) {

        PdfContentByte cb = writer.getDirectContent();
        try {
            cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 14);

            cb.rectangle(10,10,500,800);

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
