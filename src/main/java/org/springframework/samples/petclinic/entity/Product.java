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
public class Product extends BaseEntity {

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String productName;

	@Column(nullable = false)
	private String productSku;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Integer stockQty;

	@Lob
	@Column(nullable = false)
	private String productDesc;

	@Column(nullable = false)
	private Integer status;
}
