package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manufacture")
public class Manufacture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mfg_Id;
	
	private String mfg_Name;
	
	private String mfg_Lisence;
	
	private String mfg_Address;
	
	@OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProductDetails> productDetails;

	public int getMfg_Id() {
		return mfg_Id;
	}

	public void setMfg_Id(int mfg_Id) {
		this.mfg_Id = mfg_Id;
	}

	public String getMfg_Name() {
		return mfg_Name;
	}

	public void setMfg_Name(String mfg_Name) {
		this.mfg_Name = mfg_Name;
	}

	public String getMfg_Lisence() {
		return mfg_Lisence;
	}

	public void setMfg_Lisence(String mfg_Lisence) {
		this.mfg_Lisence = mfg_Lisence;
	}

	public String getMfg_Address() {
		return mfg_Address;
	}

	public void setMfg_Address(String mfg_Address) {
		this.mfg_Address = mfg_Address;
	}

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	
	
}
