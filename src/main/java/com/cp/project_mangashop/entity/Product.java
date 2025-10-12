package com.cp.project_mangashop.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prod;
	@Column(name = "prod_name")
    private String prodName;
    private Double price;
    private String brand;
    private String description;
    private String category;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean available;
    private int quantity;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(columnDefinition = "TINYINT(1)")
	private boolean deleted = false;
    
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
    
    @OneToMany(mappedBy = "product")
    private List<CartItem> cartProduct;
    
}
