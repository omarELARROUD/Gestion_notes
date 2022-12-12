import Students.xmlCreation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import reader.StudentXmlGenerate;
import reader.NoteXmlGenerate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileInputStream;
import java.io.IOException;

import static Validator.validateXmlSchema.validateXMLSchema;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {

        String SpathIn = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Students.xlsx";
        String SpathOut = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Students.xml";
        String SpathXsd="C:\\Users\\Admin\\IdeaProjects\\XML_Project\\XMLUtils\\GINF2_Students.xsd";

        String NpathIn = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Notes.xlsx";
        String NpathOut = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Notes.xml";


        //generate XML
 Document document = StudentXmlGenerate.StudentXmlGenerate(SpathIn);
 Document document1 = NoteXmlGenerate.NoteXmlGenerate(NpathIn);



// CREATION XML
        xmlCreation studentXml = new xmlCreation();
        studentXml.xmlCreation(SpathOut,document);
        //validate xml xsd
        System.out.println("validate xml with xsd : "+validateXMLSchema(SpathXsd,SpathOut));

        studentXml.xmlCreation(NpathOut,document1);
        //validate xml xsd
//        System.out.println("validate xml with xsd : "+validateXMLSchema(NpathXsd,NpathOut));
    }
}