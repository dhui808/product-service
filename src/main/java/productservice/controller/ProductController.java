package productservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import productservice.model.AddProductResponse;
import productservice.model.Product;
import productservice.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @GetMapping("/products/{id}")
    private Product getProductById(@PathVariable String id){
        return productService.listProducts().stream().filter(prd -> prd.getId().equalsIgnoreCase(id)).findFirst().get();
    }

    @GetMapping("/products/customers/{custId}")
    public List<Product> listProductsByCustomerId(@PathVariable String custId){
        return productService.listProducts().stream().filter(product -> product.getCustomerId().equalsIgnoreCase(custId)).collect(Collectors.toList());
    }
    
	@RequestMapping(method = RequestMethod.POST, value="/product/add", produces = "application/json")
	public AddProductResponse addProduct(@RequestBody Product product) {
		
		Long productId = productService.addProduct(product);
		AddProductResponse productResponse = new AddProductResponse();
		productResponse.setStatus("success");
		productResponse.setProductId(productId);
		System.out.println("addProduct called - productId = " + productId);
		
		return productResponse;
	}
}
