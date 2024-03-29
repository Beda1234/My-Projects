package com.api.controller;

import com.api.entity.Product;
import com.api.helper.Helper;
import com.api.message.ResponseMessage;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file) {
    	 String message = "";
    	if (Helper.checkExcelFormat(file)) {
            //true
         try {
        	 this.productService.save(file);
        	 message = "Uploaded the file successfully: " + file.getOriginalFilename();
        	 

             return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			
		}
            


        }
    	 message = "Please upload an excel file!";
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        
    }


    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct() {
       
    	try {
    	      List<Product> products = productService.getAllProducts();

    	      if (products.isEmpty()) {
    	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	      }

    	      return new ResponseEntity<>(products, HttpStatus.OK);
    	    } catch (Exception e) {
    	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	    }
    	
    	
    	
//    	return this.productService.getAllProducts();
    }

}
