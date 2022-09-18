package com.quickpharma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_types")
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int productTypeId;
	@Column(name = "type_name")
	private String productTypeName;
	@Column(name = "type_thumbnail")
	private String typeThumbnail;

	
	  @OneToMany(mappedBy = "productType" , cascade = CascadeType.ALL,orphanRemoval= true)
	  private List<Product> productList;
	 

	public ProductType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductType(int productTypeId, String productTypeName, String typeThumbnail, List<Product> productList) {
		super();
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
		this.typeThumbnail = typeThumbnail;
		this.productList = productList;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getTypeThumbnail() {
		return typeThumbnail;
	}

	public void setTypeThumbnail(String typeThumbnail) {
		this.typeThumbnail = typeThumbnail;
	}

	
	  public List<Product> getProductList() { return productList; }
	  
	  public void setProductList(List<Product> productList) { this.productList =
	  productList; }
	 

	@Override
	public String toString() {
		return "ProductType [productTypeId=" + productTypeId + ", productTypeName=" + productTypeName
				+ ", typeThumbnail=" + typeThumbnail + ", productList=" +  productList +  "]";
	}

}
