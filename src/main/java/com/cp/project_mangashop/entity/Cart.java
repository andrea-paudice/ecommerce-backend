package com.cp.project_mangashop.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@OneToOne
	@JoinColumn(name = "fk_user_id")
	private User user;

	@OneToMany(mappedBy = "cart")
	private List<CartItem> cartItems;
	
	private LocalDate creationDate;
	private LocalDate updateDate;
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", cartItems=" + cartItems + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + "]";
	}
	
	
	
}
