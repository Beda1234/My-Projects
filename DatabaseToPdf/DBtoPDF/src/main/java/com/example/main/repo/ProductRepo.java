package com.example.main.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.main.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{

	
	@Query(value="SELECT COLUMN_NAME\r\n"
			+ "FROM INFORMATION_SCHEMA.COLUMNS\r\n"
			+ "WHERE TABLE_SCHEMA = 'excel' AND TABLE_NAME = 'product';",nativeQuery=true)
	public List<String> getAllColumn();

	
}