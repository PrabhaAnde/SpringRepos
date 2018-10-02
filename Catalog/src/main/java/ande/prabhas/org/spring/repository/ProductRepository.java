package ande.prabhas.org.spring.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import ande.prabhas.org.spring.model.Product;

public interface ProductRepository extends CassandraRepository<Product,String> {

//	@Override
//	List<Product> findAll();
	
	@Query("select * from product where productid = ?0")
	Product findByProductID(String productid);
}
