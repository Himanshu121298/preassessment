package com.preassessment.test.QuestionOne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	Map<String, List<ProductEntity>> response = new HashMap<String, List<ProductEntity>>();
	
	@Autowired
	ProductDaoService productService;

	
	@PostMapping("/sortProducts")	
	public Map<String,List<ProductEntity>> getSortedProduct(@RequestBody Map<String,List<ProductEntity>> productmap){
		try {
			logger.info("Called SortProducts");
			response.put("productList", productService.getSortedProductsList(productmap.get("productList")));
		} catch (Exception e) {
			
			
			e.printStackTrace();
			throw new ResponseStatusException(
			          HttpStatus.INTERNAL_SERVER_ERROR, "Error inside Controller",e);
		}
		return response;
	}

}
