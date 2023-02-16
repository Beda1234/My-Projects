package com.example.main;



import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
//import java.itextpdf.?;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@SpringBootApplication
public class DBtoPdfInSingleClassApplication {

    public static void main(String[] args) {
        try {
            /* Create Connection objects for DB */
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel", "root",
                    "bedaprakash123@");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from product");
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int count = rsMetaData.getColumnCount();

            /*This is for Creating PDF */
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\RSTPL076\\Desktop\\DatabaseProduct.pdf"));

            /*Here The document is open after that we start adding content to our PDF page*/
            document.open();

            /*Here we add an image*/
            Image image = Image.getInstance(
                    "C:\\Users\\RSTPL076\\Documents\\Practice Application sts\\DatabaseToPdf\\DBtoPDF-In_Single_Class-1\\src\\main\\image\\Youngsoft-India.png");
            image.setAbsolutePosition(0, 0);
//			image.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getHeight());
            document.add(image);

            // create a cell object
            PdfPCell pdfPCell = new PdfPCell();
            pdfPCell.setBackgroundColor(BaseColor.BLUE);
            pdfPCell.setPadding(5);

            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            font.setColor(BaseColor.RED);

            Paragraph paragraph = new Paragraph("List of Products", font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            font.setColor(BaseColor.WHITE);
            font.setSize(9);
            PdfPTable pdfPTable = new PdfPTable(count);
            pdfPTable.setWidthPercentage(100f);
//			pdfPTable.setWidths(new float[] { 1.0f, 1.5f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f });
            pdfPTable.setSpacingBefore(10);

            // Setting Headers
            for (int i = 1; i <= count; i++) {
                String columnNameee = rsMetaData.getColumnName(i).toUpperCase();

                pdfPCell.setPhrase(new Phrase(columnNameee, font));
                pdfPTable.addCell(pdfPCell);

            }
            //Setting Column values
            while (rs.next()) {
                for (int i = 1; i <= count; i++) {
                    String columnNameee = rsMetaData.getColumnName(i);
                    pdfPCell = new PdfPCell(new Phrase(rs.getString(columnNameee)));
                    pdfPTable.addCell(pdfPCell);

                }
            }


            document.add(pdfPTable);
            document.close();

            /* Close all DB related objects */
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("downloaded successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}