package com.example.main.controller;

import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.main.entity.Product;
import com.example.main.pdf.ProductPdfExporter;
import com.example.main.repo.ProductRepo;
import com.example.main.service.ProductService;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ProductController 
{
	@Autowired
    private ProductService service;
	
	@Autowired
	private ProductRepo repo;
         
    @GetMapping("export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Product> listProducts = service.listAll();
        List<String> listColumnss = service.listColumn();

        
        listColumnss.forEach(e->{
      	System.out.println(e+"This is from column");
      });
        ProductPdfExporter exporter = new ProductPdfExporter(listProducts,listColumnss);
//      ProductPdfExporter exporterr = new ProductPdfExporter(listColumnss);
       
	
        exporter.export(response);

}
}