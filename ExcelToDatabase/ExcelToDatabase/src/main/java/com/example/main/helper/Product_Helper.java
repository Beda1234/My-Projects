package com.example.main.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.main.entity.Product;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class Product_Helper {

	public static String Type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "Name", "Company", "Price", "Lunched" };
	static String SHEET = "Products";

	// This method is for check the file is excel type or not
	public static boolean checkExcelFormat(MultipartFile file)
	{
		if (!Type.equals(file.getContentType())) 
		{
			return false;
		}
		return true;
	}

	// This method convert the excel to list

	public static List<Product> convertExcelToListOfProduct(InputStream is)
	{
		
		try {
			
			  Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheet(SHEET);
			
			
			Iterator<Row> rows=sheet.iterator();
			List<Product> products = new ArrayList<Product>();
			int rowNumber = 0;
		      while (rows.hasNext()) 
		      {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) 
		        {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();
		        Product p=new Product();
		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) 
		        {
		          Cell currentCell = cellsInRow.next();
		          
		        switch (cellIdx) 
		        {
				case 0: 
				  {
					p.setProduct_id((int)currentCell.getNumericCellValue());
					break;
					
				  }
				case 1:
				  {
					p.setProduct_name(currentCell.getStringCellValue());
					break;
					
				  }
				case 2: 
				  {
					p.setProduct_company(currentCell.getStringCellValue());
					break;
					
				  }
				case 3: 
				  {
					p.setProduct_price(currentCell.getStringCellValue());
					break;
					
				  }
				case 4: 
				  {
					p.setProduct_lunched(currentCell.getBooleanCellValue());
					break;
					
				  }
				default:
				{
					break;
				}}
		        cellIdx++;
		        }
		        products.add(p);
		      }
		      workbook.close();
		      return products;}
		
		catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
	
		

}
	}