package stored.pract.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stored.pract.product.entity.Category;

import stored.pract.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product>finByCategory(Category category);
}//interface
