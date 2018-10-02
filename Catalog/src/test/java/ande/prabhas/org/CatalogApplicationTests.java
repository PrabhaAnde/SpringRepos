package ande.prabhas.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Select.Where;

import ande.prabhas.org.spring.model.Product;
import ande.prabhas.org.springdata.config.CassandraConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CassandraConfig.class)
public class CatalogApplicationTests {
	
	@Autowired
	ApplicationContext ctxt;
	
//	@Autowired
//    private CassandraAdminOperations adminTemplate;

    @Autowired
    private CassandraOperations cassandraTemplate;

//    @Autowired
//    private ProductRepository proRepos;
    
	@Test
	public void contextLoads() {
		System.out.println("Test---"+ctxt.containsBean("CassandraConfig"));
		
	}

	/*@Test
	public void insertProduct()
	{
		 Product prod1= new Product();
		 prod1.setProductid("MOB4");
		 prod1.setBrand("Samsung");
		 prod1.setModelid("Samsung Note8");
		 prod1.setBreadth(5);
		 prod1.setHeight(20);
		 Map<String,String> camera=new HashMap<String,String>();
		 camera.put("front", "12MP");
		 camera.put("rear1", "16MP");
		 camera.put("rear2", "16MP");
		 prod1.setCamera(camera);
		 Set<String> featureSet = new HashSet<String>();
		 featureSet.add("MultiTouch Display");
		 featureSet.add("SPen Stylus");
		 featureSet.add("Animated message writing");
		 featureSet.add("Custom Themes");
		 prod1.setKeyfeatures(featureSet);
		 List<String> serviceType=new ArrayList<String>();
		 serviceType.add("1 year default warranty");
		 serviceType.add("Brokern or Damaged phones cannot be exchanged");
		 
		 
		 prod1.setServiceType(serviceType);
		 
		 cassandraTemplate.insert(prod1);
		 
		 System.out.println("Insertion is complete");
	}*/
	
	@Test
	public void getAll() {
		Select select=QueryBuilder.select().from("product");
		List<Product> listP=cassandraTemplate.select(select, Product.class);
		
		for(Product p:listP) {
			System.out.println(p.getProductid());
			System.out.println(p.getModelid());
			System.out.println(p.getTitle());
			System.out.println(p.getPublisher());
			System.out.println(p.getServiceType());
		}
					
		
	}
	
	
	@Test
	public void getProductByID() {
		Where where=QueryBuilder.select().from("product").where(QueryBuilder.eq("productid", "MOB3"));
		Product listP=cassandraTemplate.selectOne(where, Product.class);
		System.out.println("#########################");
		System.out.println(listP.getProductid());
		System.out.print(listP.getModelid());
		System.out.print(listP.getTitle());
		System.out.print(listP.getPublisher());
		System.out.print(listP.getServiceType());
		System.out.println("#########################");
		
		
					
		
	}
	
}
