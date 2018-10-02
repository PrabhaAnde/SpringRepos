package ande.prabhas.org.spring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Product {
	
	@PrimaryKeyColumn(name="productid",type=PrimaryKeyType.PARTITIONED,ordering=Ordering.DESCENDING)
	private String productid;
	
	@Column
	private String brand;
	
	@Column
	private Integer breadth;
	
	@Column
	private Map<String, String> camera=new HashMap<String,String>();
	
	@Column
	private Integer height;
	
	@Column
	private Set<String> keyfeatures=new HashSet<String>();
	
	@Column
	private Integer length;
	
	@Column
	private String modelid;
	
	@Column
	private String publisher;
	
	@Column(value="service_type")
	private List<String> serviceType=new ArrayList<String>();
	
	@Column
	private String title;

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getBreadth() {
		return breadth;
	}

	public void setBreadth(Integer breadth) {
		this.breadth = breadth;
	}

	public Map<String, String> getCamera() {
		return camera;
	}

	public void setCamera(Map<String, String> camera) {
		this.camera = camera;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Set<String> getKeyfeatures() {
		return keyfeatures;
	}

	public void setKeyfeatures(Set<String> keyfeatures) {
		this.keyfeatures = keyfeatures;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getModelid() {
		return modelid;
	}

	public void setModelid(String modelid) {
		this.modelid = modelid;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public List<String> getServiceType() {
		return serviceType;
	}

	public void setServiceType(List<String> serviceType) {
		this.serviceType = serviceType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
}
