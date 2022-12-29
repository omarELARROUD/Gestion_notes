package reader;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;

public class StudentXmlGenerate {
    public static Document StudentXmlGenerate(String pathIn) throws IOException, ParserConfigurationException {
        //READ EXCEL FILE
        FileInputStream FIS =new FileInputStream(pathIn);
        XSSFWorkbook wb = new XSSFWorkbook(FIS);
        XSSFSheet sheet = wb.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();


        Element rootelm=document.createElement("Students");
        document.appendChild(rootelm);


        Attr attr1 = document.createAttribute("Class");
        attr1.setValue("GINF2");
        rootelm.setAttributeNode(attr1);

        for(int i=1; i<sheet.getLastRowNum();i++){
            Row row =sheet.getRow(i);
            Element elm = document.createElement("student");
            rootelm.appendChild(elm);

            Attr attr2 = document.createAttribute("Capoge");
            attr2.setValue(formatter.formatCellValue(row.getCell(0)));
            elm.setAttributeNode(attr2);

            Attr attr3 = document.createAttribute("CIN");
            attr3.setValue(formatter.formatCellValue(row.getCell(1)));
            elm.setAttributeNode(attr3);

            Attr attr4 = document.createAttribute("CNE");
            attr4.setValue(formatter.formatCellValue(row.getCell(2)));
            elm.setAttributeNode(attr4);

            Attr attr5 = document.createAttribute("Inscription");
            attr5.setValue(formatter.formatCellValue(row.getCell(13)));
            elm.setAttributeNode(attr5);

            Element elm1 = document.createElement("FirstName");
            Element elm2 = document.createElement("LastName");
            Element elm3 = document.createElement("Email");
            Element elm4 = document.createElement("Phone");
            Element elm5 = document.createElement("Photo");

            elm1.appendChild(document.createTextNode(row.getCell(3)+""));
            elm2.appendChild(document.createTextNode(formatter.formatCellValue(row.getCell(4))));
            elm3.appendChild(document.createTextNode(formatter.formatCellValue(row.getCell(5))));
            elm4.appendChild(document.createTextNode(formatter.formatCellValue(row.getCell(9))));
            elm5.appendChild(document.createTextNode(row.getCell(14).getStringCellValue()));


            elm.appendChild(elm1);
            elm.appendChild(elm2);
            elm.appendChild(elm3);
            elm.appendChild(elm4);
            elm.appendChild(elm5);


        }
        return document;
    }
}
