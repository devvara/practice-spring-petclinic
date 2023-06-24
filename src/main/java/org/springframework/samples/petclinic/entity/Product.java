package org.springframework.samples.petclinic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="product")
public class Product {

	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String productName;

	@Column(nullable = false)
	private String productSku;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false)
	private int stockQty;

	@Lob
	@Column(nullable = false)
	private String productDesc;

	@Column(nullable = false)
	private int status;

}
