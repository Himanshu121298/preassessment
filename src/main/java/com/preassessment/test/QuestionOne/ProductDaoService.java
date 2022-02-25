package com.preassessment.test.QuestionOne;

import java.util.Comparator;
import java.util.List;


import org.springframework.stereotype.Component;


@Component
public class ProductDaoService {
	public List<ProductEntity> getSortedProductsList(List<ProductEntity> productEntity) {
		
		
		productEntity.sort(Comparator.comparing(ProductEntity::getProductId).thenComparing(ProductEntity::getLaunchDate).reversed());
		
		return productEntity;
	}

}
