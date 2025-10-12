package com.cp.project_mangashop.dto.product;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ProductDTO {

	private int prodId;
	@NotBlank(message = "Il nome del prodotto è obbligatorio")
	private String prodName;
	@Positive(message = "Il prezzo deve essere positivo")
	private double price;
	@NotBlank(message = "Il nome del brand è obbligatorio")
	private String brand;
	private String description;
	@NotBlank(message = "La categoria è obbligatoria")
    private String category;
    private LocalDate releaseDate;
    private boolean available;
    private int quantity;
    private boolean deleted;
    private String imageUrl;
    
}
