package com.cp.project_mangashop.dto.product;

import com.cp.project_mangashop.entity.Product;

public class ProductDTOMapper {

	public static ProductDTO productToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		
		dto.setProdId(product.getId_prod());
		dto.setProdName(product.getProdName());
		dto.setPrice(product.getPrice());
		dto.setBrand(product.getBrand());
		dto.setDescription(product.getDescription());
		dto.setCategory(product.getCategory());
		dto.setReleaseDate(product.getReleaseDate());
		dto.setAvailable(product.isAvailable());
		dto.setQuantity(product.getQuantity());
		dto.setDeleted(product.isDeleted());
		dto.setImageUrl(product.getImageUrl());
		
		return dto;
	}
	
	public static Product DTOtoProduct(ProductDTO dto) {
		Product product = new Product();
		
		product.setId_prod(dto.getProdId());
		product.setProdName(dto.getProdName());
		product.setPrice(dto.getPrice());
		product.setBrand(dto.getBrand());
		product.setDescription(dto.getDescription());
		product.setCategory(dto.getCategory());
		product.setReleaseDate(dto.getReleaseDate());
		product.setAvailable(dto.isAvailable());
		product.setQuantity(dto.getQuantity());
		product.setDeleted(dto.isDeleted());
		product.setImageUrl(dto.getImageUrl());
		
		return product;
	}
	
}
