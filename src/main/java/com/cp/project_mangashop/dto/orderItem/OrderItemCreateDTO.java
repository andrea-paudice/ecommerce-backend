package com.cp.project_mangashop.dto.orderItem;

import com.cp.project_mangashop.dto.product.ProductDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemCreateDTO {

	@NotNull(message = "L'id dell'order item è obbligatorio")
    private int id;
	
	@NotNull(message = "Il prodotto è obbligatorio")
    private int productId;

    @Positive(message = "La quantità deve essere positiva")
    private int quantity;
	
}
