package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailId;
	
	@OneToOne(mappedBy = "productdetails")
	private Product product;
	
	private int batch_Num;
	
	private LocalDate mfg_Date;
	
	private LocalDate expire_Date;
	
	@ManyToOne
	@JoinColumn(name="mfg_Id")
	private Manufacture manufacture;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getBatch_Num() {
		return batch_Num;
	}

	public void setBatch_Num(int batch_Num) {
		this.batch_Num = batch_Num;
	}

	public LocalDate getMfg_Date() {
		return mfg_Date;
	}

	public void setMfg_Date(LocalDate mfg_Date) {
		this.mfg_Date = mfg_Date;
	}

	public LocalDate getExpire_Date() {
		return expire_Date;
	}

	public void setExpire_Date(LocalDate expire_Date) {
		this.expire_Date = expire_Date;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}
	
	
}
