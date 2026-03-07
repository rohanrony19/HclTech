package hcl.springboot.springbootproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hcl.springboot.springbootproject.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.pName=:pName")
	public List<Product> findByName(String pName);
	
	@Query("select p from Product p where p.pPrice >:pPrice") //jpql
	public List<Product> expensiveProduct(@Param("pPrice") double pPrice);
}
