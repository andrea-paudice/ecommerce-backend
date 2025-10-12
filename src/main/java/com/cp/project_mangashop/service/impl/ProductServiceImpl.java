package com.cp.project_mangashop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.project_mangashop.dto.product.ProductDTO;
import com.cp.project_mangashop.dto.product.ProductDTOMapper;
import com.cp.project_mangashop.entity.Product;
import com.cp.project_mangashop.repository.ProductRepository;
import com.cp.project_mangashop.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<ProductDTO> getAll() {
		List<Product> products = productRepo.findAll();
		List<ProductDTO> productsDTO = products.stream()
				.map(product -> ProductDTOMapper.productToDTO(product))
				.collect(Collectors.toList());
		
		return productsDTO;
	}

	@Override
	public List<ProductDTO> getAllNotDeleted() {
		List<Product> products = productRepo.findAllByDeletedIsFalse();
		List<ProductDTO> productsDTO = products
				.stream()
				.map(product -> ProductDTOMapper.productToDTO(product))
				.toList();
		
		return productsDTO;
	}
	
	@Override
	public Product getProductById(int id_prod) {
		Product product = productRepo.findById(id_prod)
				.orElseThrow(() -> new RuntimeException("Prodotto non trovato"));
		
		return product;
	}

	@Override
	public ProductDTO insertProduct(Product product) {
		productRepo.save(product);
		ProductDTO productDTO = ProductDTOMapper.productToDTO(product);
		
		return productDTO;
		
	}

	@Override
	public ProductDTO updateProduct(Product product) {
		productRepo.save(product);
		ProductDTO productDTO = ProductDTOMapper.productToDTO(product);
		
		return productDTO;
		
	}

	@Override
	public void deleteProduct(int id_prod) {
		productRepo.deleteById(id_prod);
		
	}

	

}
