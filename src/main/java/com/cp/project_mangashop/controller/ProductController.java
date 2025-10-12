package com.cp.project_mangashop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.project_mangashop.dto.order.OrderDTO;
import com.cp.project_mangashop.dto.product.ProductDTO;
import com.cp.project_mangashop.dto.product.ProductDTOMapper;
import com.cp.project_mangashop.dto.product.ProductUpdateDTO;
import com.cp.project_mangashop.entity.Product;
import com.cp.project_mangashop.service.interfaces.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll() {
		List<ProductDTO> products = productService.getAll();
		
		if(products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/allFiltered")
	public ResponseEntity<?> getAllFiltered() {
		List<ProductDTO> products = productService.getAllNotDeleted();
		
		if(products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/{id_prod}")
	public ResponseEntity<?> get(@PathVariable int id_prod) {
		Product product = productService.getProductById(id_prod);
		ProductDTO productDTO = ProductDTOMapper.productToDTO(product);
		
		return new ResponseEntity<>(productDTO, HttpStatus.OK);
		
	}
	
	@PostMapping("/admin/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        
        	Product product = ProductDTOMapper.DTOtoProduct(productDTO);
    		
    		productService.insertProduct(product);
            return ResponseEntity.status(201).body(product);
		} 
	
	@PutMapping("/admin/update/{id_prod}")
    public ResponseEntity<?> updateProduct(@PathVariable int id_prod, @Valid @RequestBody ProductDTO updatedProduct) {
		Product existing = productService.getProductById(id_prod);
		ProductDTO existingDTO = ProductDTOMapper.productToDTO(existing);
		if(existingDTO.equals(updatedProduct)) {
			return new ResponseEntity<>("Nessuna modifica eseguita", HttpStatus.NOT_MODIFIED);
		}
		
		Product product = ProductDTOMapper.DTOtoProduct(updatedProduct);
		productService.updateProduct(product);

	    return ResponseEntity.ok(product);
		
    }
	
	@DeleteMapping(path = "/admin/soft-delete/{productId}")
	public ResponseEntity<?> softDeleteProduct(@PathVariable int productId) {
		Product existing = productService.getProductById(productId);
		// productService.deleteProduct(existing.getId_prod());
		
		// Soft delete per evitare problemi con gli ordini
		existing.setDeleted(true);
		productService.updateProduct(existing);
		
		return new ResponseEntity<>("Prodotto eliminato", HttpStatus.OK);
		
	}
	
	@PutMapping(path = "/reactivate/{productId}")
	public ResponseEntity<?> reactivateProduct(@PathVariable int productId) {
		Product product = productService.getProductById(productId);
		product.setDeleted(false);
		productService.updateProduct(product);
		
		return new ResponseEntity<>("Prodotto nuovamente attivato", HttpStatus.OK);
		
	}
	
}
