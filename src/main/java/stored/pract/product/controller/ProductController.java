package stored.pract.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stored.pract.product.entity.Product;
import stored.pract.product.service.ProductService;

@RestController
@RequestMapping(value= "/products")
public class ProductController {

	@Autowired
	private ProductService productService ;
	
	public ResponseEntity<List<Product>> listProduct(){
		List<Product> products= productService.listAllProduct();
		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}//if
		return ResponseEntity.ok(products);
		
	}//ResponseEntity
	
}//class ProductController
