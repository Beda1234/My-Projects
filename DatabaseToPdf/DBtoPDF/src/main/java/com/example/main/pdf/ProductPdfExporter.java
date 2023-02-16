package com.example.main.pdf;

import java.util.List;


import java.awt.Color;
import java.io.IOException;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import jakarta.servlet.http.HttpServletResponse;

import com.example.main.entity.Product;

//Next, code a separate class that is responsible to generate a PDF document based on the input is a List collection of User objects, as shown below:
//This class will create a PDF representing the information about users in table format, with table header consists of these columns
//Pay attention to the export() method that takes an HttpServletRespone as the argument, because it will write the content of the PDF file into the output stream of the response, so the clients (web browsers) will be able to download the exported PDF document.
public class ProductPdfExporter  {
	
	
	
	private List<Product> listProducts;
	private List<String> listColumnss;

	public ProductPdfExporter(List<Product> listProducts,List<String> listColumnss) {
		this.listProducts = listProducts;
		this.listColumnss=listColumnss;
	}
	
	
	

	

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		System.out.println(listColumnss+"------------");
		for(String cname:listColumnss) {
		cell.setPhrase(new Phrase(cname, font));

		table.addCell(cell);

		}

	}

	private void writeTableData(PdfPTable table) {
		for (Product product : listProducts) {
			table.addCell(String.valueOf(product.getProductId()));
			table.addCell(product.getProductDesc());
			table.addCell(product.getProductName());
			table.addCell(product.getProductPrice().toString());
			table.addCell(product.getProductDiscount());
			table.addCell(product.getProductValue());
			table.addCell(product.getProductThing());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Products", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.0f, 1.5f, 1.0f, 1.0f, 1.0f, 1.0f ,1.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}