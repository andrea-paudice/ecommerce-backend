package com.cp.project_mangashop.service.interfaces;

import java.util.List;

import com.cp.project_mangashop.dto.product.ProductDTO;
import com.cp.project_mangashop.entity.Product;

public interface ProductService {

	public List<ProductDTO> getAll();
	public List<ProductDTO> getAllNotDeleted();
	public Product getProductById(int id_prod);
	public ProductDTO insertProduct(Product product);
	public ProductDTO updateProduct(Product product);
	public void deleteProduct(int id_prod);
	
}
