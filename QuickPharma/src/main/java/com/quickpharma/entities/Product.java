package com.quickpharma.entities;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Product_Id")
	private int productId;
	@Column(name="Name")
	private String productName;
	private String description;
	private double price;
	private int stocks;
	@Column(name="Product_Thumbnail")
	private String thumbnail;
	@Column(name="Manufacture_Date")
	@Temporal(TemporalType.DATE)
	private Date manufactureDate;
	@Column(name="Expiry_Date")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	
	
	  @JsonIgnore
	  @ManyToOne
	  @JoinColumn(name = "product_type_id") 
	  private ProductType productType;


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int productId, String productName, String description, double price, int stocks, String thumbnail,
			Date manufactureDate, Date expiryDate, ProductType productType) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stocks = stocks;
		this.thumbnail = thumbnail;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.productType = productType;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStocks() {
		return stocks;
	}


	public void setStocks(int stocks) {
		this.stocks = stocks;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public Date getManufactureDate() {
		return manufactureDate;
	}


	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public ProductType getProductType() {
		return productType;
	}


	public void setProductType(ProductType productType) {
		this.productType = productType;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", stocks=" + stocks + ", thumbnail=" + thumbnail + ", manufactureDate="
				+ manufactureDate + ", expiryDate=" + expiryDate + ", productType=" + productType + "]";
	}
	 
	

	
	
}
