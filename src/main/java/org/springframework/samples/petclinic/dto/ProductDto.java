package org.springframework.samples.petclinic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private Long id;

	private String productName;

	private String productSku;

	private Integer price;

	private Integer stockQty;

	private String productDesc;

	private Integer status;

}
