package com.example.main.service;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.main.entity.Product;
import com.example.main.helper.Product_Helper;
import com.example.main.repo.Product_Repository;

@Service
public class ProductService {

	@Autowired
	private Product_Repository productRepo;
	public void save(MultipartFile file)
	{
		try {
			List<Product> products=Product_Helper.convertExcelToListOfProduct(file.getInputStream());
			productRepo.saveAll(products);
		} catch (IOException e) {
			
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
	public List<Product> getAllProduct()
	{
		return productRepo.findAll();
	}
}
