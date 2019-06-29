package app.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javafx.stage.FileChooser;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;
/**
 * @file Pdf.java
 * @brief Klasa zajmująca się generowaniem pliku pdf.
 * @details Pdf.java jest to klasa odpowiadająca za generowanie pliku pdf za pomocą dostarczonego kodu html.
 */
public class Pdf {
    /**
     * @param html Kod języka html umieszczony w zmiennej typu String.
     * @throws IOException
     * @throws DocumentException
     * @details Metoda generate(), tworzy plik pdf na podstawie dostarczonego kodu html poprzez zmienną typu String.
     */
    public static void generate(String html) throws IOException, DocumentException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);

        String filePdf;

        if(file != null) {
            filePdf = file.toString();
            System.out.println(filePdf);
        } else {
            return;
        }

        OutputStream outputStream = new FileOutputStream(filePdf);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }
}