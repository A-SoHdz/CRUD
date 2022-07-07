package stored.pract.product.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import stored.pract.product.entity.Category;
import stored.pract.product.entity.Product;
import stored.pract.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	//@Autowired
	private final ProductRepository productRepository;
	
	@Override
	public List<Product> listAllProduct() {
		
		return productRepository.findAll();
	}//ListProduct
	
	@Override
	public Product getProduct(Long id) {
		
		return productRepository.findById(id).orElse(null);
	}//getProduct

	@Override
	public Product createProduct(Product product) {
		product.setStatus("CREATED");
		product.setCreateAt(new Date());
		
		return null;
	}//createProduct
	
	@Override
	public Product updateProduct(Product product) {
		Product productDB = getProduct(product.getId());
		if (null == productDB) {
			return null;
		}//if 
		productDB.setName(product.getName());
		productDB.setDescription(product.getDescription());
		productDB.setCategory(product.getCategory());
		productDB.setPrice(product.getPrice());
		
		return productRepository.save(productDB);
	}//updateProduct

	@Override
	public Product deleteProduct(Long id) {
		Product productDB = getProduct(id);
		if (null == productDB) {
			return null;
		}//if 
		productDB.setStatus("DELETE");
		
		return productRepository.save(productDB);
	}//deleteProduct

	@Override
	public List<Product> findByCategory(Category category) {
		
		return productRepository.finByCategory(category);
	}//ListProduct findbyCat

	@Override
	public Product updateStock(Long id, Double quantity) {
		Product productDB = getProduct(id);
		if (null == productDB) {
			return null;
		}//if 
		Double stock = productDB.getStock() + quantity;
		productDB.setStock(stock);
		return productRepository.save(productDB);
	}//updateStock

	

	


}//class ProductServiceImpl
