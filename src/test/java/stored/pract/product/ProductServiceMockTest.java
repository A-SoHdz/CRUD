package stored.pract.product;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import stored.pract.product.entity.Category;
import stored.pract.product.entity.Product;
import stored.pract.product.repository.ProductRepository;
import stored.pract.product.service.ProductService;
import stored.pract.product.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceMockTest {

	@Mock
	private  ProductRepository productRepository;
	
	private ProductService productService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		productService= new ProductServiceImpl(productRepository);
		Product computer= Product.builder()
				.id(1L)
				.name("computer")
				.category(Category.builder().id(1L).build())
				.price(Double.parseDouble("12.5"))
				.stock(Double.parseDouble("5"))
				.build();
		
		Mockito.when(productRepository.findById(1L))
		        .thenReturn(Optional.of(computer));
		Mockito.when(productRepository.save(computer)).thenReturn(computer);
		
	}//setup
	
	@Test
	public void whenValidGetID_ThenReturnProduct() {
		Product found= productService.getProduct(1L);
		Assertions.assertThat(found.getName()).isEqualTo("computer");
	}//whenvalidGetID
	
	@Test
	public void whenValidUpdateStock_ThenReturnNewStock() {
		Product newStock= productService.updateStock(1L,Double.parseDouble("8"));
	    Assertions.assertThat(newStock.getStock()).isEqualTo(13);
	}//whenvalid
	
}//class ProductServiceMockTest
