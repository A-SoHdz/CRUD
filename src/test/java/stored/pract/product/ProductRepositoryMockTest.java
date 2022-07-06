package stored.pract.product;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import stored.pract.product.entity.Category;
import stored.pract.product.entity.Product;
import stored.pract.product.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	private void whenFindByCategory_thenRestumListProduct() {
		Product product01 = Product.builder()
				.name("computer")
				.category(Category.builder().id(1L).build())
				.description(null)
				.stock(Double.parseDouble("10"))
				.price(Double.parseDouble("1244.99"))
				.status("Created")
				.createAt(new Date()).build();
				productRepository.save(product01);
				
				List<Product> founds= productRepository.finByCategory(product01.getCategory());
				
				Assertions.assertThat(founds.size()).isEqualTo(3);
				
	}//whenfindbycategory
	
}//class ProductRepositoryMockTest
