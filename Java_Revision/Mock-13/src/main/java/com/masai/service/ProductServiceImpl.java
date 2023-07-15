package com.masai.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.entity.Product;
import com.masai.exception.ProductException;
import com.masai.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product addNewProduct(Product prod) throws ProductException {

		if (prod == null)
			throw new ProductException("Product details not found");

		return productRepo.save(prod);
	}

	@Override
	public Product updateProduct(Product prod) throws ProductException {
		if (prod == null)
			throw new ProductException("Product details not found");

		Optional<Product> opt = productRepo.findById(prod.getId());
		if (opt.isEmpty())
			throw new ProductException("Product not exist");
		Product product = opt.get();
		product.setDescription(prod.getDescription());
		product.setPrice(prod.getPrice());
		product.setProductName(prod.getProductName());
		return productRepo.save(product);
	}

	@Override
	public Product deleteProduct(Integer pId) throws ProductException {
		Optional<Product> opt = productRepo.findById(pId);
		if (opt.isEmpty())
			throw new ProductException("Product not exist");
		Product product = opt.get();
		productRepo.delete(product);
		return product;
	}

	@Override
	public Product getProductById(Integer pId) throws ProductException {
		Optional<Product> opt = productRepo.findById(pId);
		if (opt.isEmpty())
			throw new ProductException("Product not exist");
		Product product = opt.get();
		return product;
	}

	@Override
	public List<Product> getAllProduct() throws ProductException {
		List<Product> products = productRepo.findAll();
		if (products.isEmpty())
			throw new ProductException("Product not found in record");
		return products;
	}

	@Override
	public List<Product> getProductWithPageNoAndLimit(Integer pageNo, Integer limit) throws ProductException {
		Pageable p = PageRequest.of(pageNo-1, limit);
		Page<Product> page=  productRepo.findAll(p);
		return page.getContent();
	}

	@Override
	public List<Product> sortProductInOrder(String name, String direction) throws ProductException {
		
		return productRepo.findAll(direction.equals("asc")? Sort.by(name).ascending() : Sort.by(name).descending());
	}

}
