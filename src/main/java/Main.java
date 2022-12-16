import Students.xmlCreation;
import Emploi.*;
import pdf.*;
import net.sf.saxon.s9api.SaxonApiException;
import org.apache.fop.apps.FOPException;
import org.w3c.dom.Document;
import reader.StudentXmlGenerate;
import reader.NoteXmlGenerate;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static Validator.validateXmlSchema.validateXMLSchema;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SaxonApiException, FOPException {

        String SpathIn = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Students.xlsx";
        String SpathOut = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Students.xml";
        String SpathXsd="C:\\Users\\Admin\\IdeaProjects\\XML_Project\\XMLUtils\\GINF2_Students.xsd";

        String NpathIn = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Notes.xlsx";
        String NpathOut = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\GINF2_Notes.xml";


        String EpathOut="C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\Emploi_Ginf2.xml";
        String EpathIn="C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\Ginf2_Emploi.xml";
        String EmploiXquery ="C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\EmploiWeek.xquery";

        String EpathHtml = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\src\\main\\db\\EmploiWeek.pdf";
        String EpathXslt = "C:\\Users\\Admin\\IdeaProjects\\XML_Project\\XMLUtils\\Emploi.xsl";

        //generate XML
 Document document = StudentXmlGenerate.StudentXmlGenerate(SpathIn);
 Document document1 = NoteXmlGenerate.NoteXmlGenerate(NpathIn);



// CREATION XML Student
        xmlCreation studentXml = new xmlCreation();
        studentXml.xmlCreation(SpathOut,document);
        //validate xml xsd
        System.out.println("validate xml with xsd : "+validateXMLSchema(SpathXsd,SpathOut));

        studentXml.xmlCreation(NpathOut,document1);
        //validate xml xsd
//        System.out.println("validate xml with xsd : "+validateXMLSchema(NpathXsd,NpathOut));


// CREATION XML Emploi

        Emploi_XmlGenerate emp=new Emploi_XmlGenerate();
        emp.generateFile(EpathIn, new File(EmploiXquery),EpathOut,2);
        //html emploi
        pdfCreation.createHtml(EpathOut,EpathHtml,EpathXslt);

    }
}