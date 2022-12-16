package reader;

import org.apache.poi.ss.usermodel.Cell;
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
import java.io.FileNotFoundException;
import java.io.IOException;

public class NoteXmlGenerate {
    public static Document NoteXmlGenerate(String pathIn) throws IOException, ParserConfigurationException {

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

            for(int i=5; i<sheet.getLastRowNum();i++) {
                Row row = sheet.getRow(i);
                Element elm = document.createElement("student");
                rootelm.appendChild(elm);

                Attr attr2 = document.createAttribute("CNE");
                attr2.setValue(formatter.formatCellValue(row.getCell(0)));
                elm.setAttributeNode(attr2);
                Attr attr3 = document.createAttribute("FirstName");
                attr3.setValue(formatter.formatCellValue(row.getCell(2)));
                elm.setAttributeNode(attr3);
                Attr attr4 = document.createAttribute("LastName");
                attr4.setValue(formatter.formatCellValue(row.getCell(1)));
                elm.setAttributeNode(attr4);


                Element notes = document.createElement("Notes");
                elm.appendChild(notes);

                Row row1=sheet.getRow(1);
                Row row2=sheet.getRow(2);
                Row row3=sheet.getRow(3);


                for (int j = 3; j < row.getLastCellNum(); j++) {
                    Element note = document.createElement("Note");
                    notes.appendChild(note);
                    int k=j;
                    int l=j;

                    do{
                    Attr attrn1 = document.createAttribute("CM");
                    attrn1.setValue(formatter.formatCellValue(row1.getCell(k)));
                    note.setAttributeNode(attrn1);
                    k--;}
                    while (row1.getCell(k+1).getStringCellValue().equals(""));

                    do{
                    Attr attrn2 = document.createAttribute("Module");
                    attrn2.setValue(formatter.formatCellValue(row2.getCell(l)));
                    note.setAttributeNode(attrn2);
                    l--;}
                    while (row2.getCell(l+1).getStringCellValue().equals(""));

                    Attr attrn3 = document.createAttribute("ElmModule");
                    attrn3.setValue(formatter.formatCellValue(row3.getCell(j)));
                    note.setAttributeNode(attrn3);

                    note.appendChild(document.createTextNode(formatter.formatCellValue(row.getCell(j))));
                }
            }
            return document;

    }

}
