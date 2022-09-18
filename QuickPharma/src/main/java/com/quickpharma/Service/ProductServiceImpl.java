package com.quickpharma.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quickpharma.dao.ProductDao;
import com.quickpharma.dao.ProductTypeDao;
import com.quickpharma.entities.Product;
import com.quickpharma.entities.ProductType;
import com.quickpharma.utils.StorageService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Autowired
	private ProductTypeDao typeDao;
	
	@Autowired
	private StorageService storageService;
	
	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> product=productDao.findById(id);
		return product.orElse(null);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		productDao.deleteById(id);
		
	}

	@Override
	public Product save(Product product, MultipartFile thumbnail) {
		// TODO Auto-generated method stub
		String fileName=storageService.store(thumbnail);
		product.setThumbnail(fileName);
		return productDao.save(product);
	}

	@Override
	public Product update(Product p, MultipartFile thumbnail) {
		// TODO Auto-generated method stub
		String fileName=storageService.store(thumbnail);
		p.setThumbnail(fileName);
		return productDao.save(p);
	}

	@Override
	public List<Product> findByProductName(String name) {
		// TODO Auto-generated method stub
		
		return productDao.findByProductNameContaining(name);
	}

	@Override
	public Integer productCount() {
		// TODO Auto-generated method stub
		return productDao.productCount();
	}

	@Override
	public List<Product> findProductByProductTypeId(int id) {
		// TODO Auto-generated method stub
		Optional<ProductType> type = typeDao.findById(id);
		return productDao.findAllByProductType(type.orElse(null));
	}

}
