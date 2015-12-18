package org.ifollowyou.hmk.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class TablePdf {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        // step 1
        Document document = new Document();
        document.setPageSize(PageSize.A4);

        // step 2
        PdfWriter.getInstance(document, new FileOutputStream("table.pdf"));

        // step 3
        document.open();

        // step 4 create PDF contents
        document.add(TableBuilder.createTable());

        //step 5
        document.close();

        System.out.println("PDF Created!");
    }
}
