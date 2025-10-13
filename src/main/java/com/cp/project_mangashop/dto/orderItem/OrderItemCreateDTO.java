package com.cp.project_mangashop.dto.orderItem;

import java.time.LocalDate;
import java.util.List;

import com.cp.project_mangashop.dto.product.ProductDTO;
import com.cp.project_mangashop.entity.CartItem;
import com.cp.project_mangashop.entity.User;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class OrderItemCreateDTO {

	@NotNull(message = "L'id dell'order item è obbligatorio")
    private int id;
	
	@NotNull(message = "Il prodotto è obbligatorio")
    private int productId;

    @Positive(message = "La quantità deve essere positiva")
    private int quantity;
	
}
