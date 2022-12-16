package pdf;

import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class pdfCreation {

    public static void createHtml(String input, String output, String xslt) throws FOPException, TransformerException, FileNotFoundException {
//        try {
//            TransformerFactory TF = TransformerFactory.newInstance();
//            Transformer transformer =
//                    TF.newTransformer(new StreamSource(new File(xslt)));
//            StreamSource SS = new StreamSource(new File(input));
//            StreamResult SR = new StreamResult(new File(output));
//            transformer.transform(SS, SR);
//            System.out.println("Fichiers generes avec succes  ");
//        }catch(Exception e) {
//            System.out.println(e.getMessage());
//        }

        File xslFile = new File(xslt);
        StreamSource xmlSource = new StreamSource(new File(input));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent fOUserAgent = fopFactory.newFOUserAgent();
        try (OutputStream outputStream = new java.io.FileOutputStream(output)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, fOUserAgent, outputStream);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
            System.out.println("done pdf creation");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}