package productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productservice.entities.ProductEntity;
import productservice.model.Product;
import productservice.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
    private ProductRepository productRepository;
	
	public List<Product> listProducts() {
		
		Iterable<ProductEntity> productEntityList = productRepository.findAll();
		List<Product> products = new ArrayList<Product>();
		
		for (ProductEntity entity: productEntityList) {
			Product product = new Product();
			product.setId(entity.getId().toString());
			product.setName(entity.getName());
			product.setPrice(entity.getPrice());
			product.setCustomerId(entity.getCustomerId().toString());
			
			products.add(product);
		}
		
		return products;
	}

	public Long addProduct(Product product) {
		
		ProductEntity entity = new ProductEntity();
		
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setCustomerId(Long.parseLong(product.getCustomerId()));
		
		entity = productRepository.save(entity);
		
		logger.debug("Registered product " + product.getName());
		
		return entity.getId();
	}
}
