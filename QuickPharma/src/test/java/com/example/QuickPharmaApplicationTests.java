package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Manufacture;
import com.example.entity.Product;
import com.example.repository.ManufactureRepository;
import com.example.repository.ProductRepository;

@SpringBootTest
class QuickPharmaApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ManufactureRepository mfgRepository;
	
	@Test
	void addProduct() {
		Product product = new Product();
		
		product.setProductName("VapoRub");
		product.setProductPrice(50.00);
		
		productRepository.save(product);
		
	}
	
	@Test
	void addManufacture() {
		Manufacture mfg = new Manufacture();
		mfg.setMfg_Address("Nagpur");
		mfg.setMfg_Lisence("HKN1234");
		mfg.setMfg_Name("Vicks");

		mfgRepository.save(mfg);
			
	}

}
